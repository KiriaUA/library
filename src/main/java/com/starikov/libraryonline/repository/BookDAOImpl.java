package com.starikov.libraryonline.repository;

import com.starikov.libraryonline.entities.Author;
import com.starikov.libraryonline.entities.Book;
import com.starikov.libraryonline.entities.Genre;
import com.starikov.libraryonline.repository.idao.BookDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private ProjectionList bookProjection;

    public BookDAOImpl() {
        bookProjection = Projections.projectionList();
        bookProjection.add(Projections.property("id"), "id");
        bookProjection.add(Projections.property("name"), "name");
        bookProjection.add(Projections.property("pageCount"), "pageCount");
        bookProjection.add(Projections.property("isbn"), "isbn");
        bookProjection.add(Projections.property("image"), "image");
        bookProjection.add(Projections.property("descr"), "descr");
        bookProjection.add(Projections.property("rate"), "rate");
        bookProjection.add(Projections.property("voteCount"), "voteCount");
        bookProjection.add(Projections.property("publisher"), "publisher");
        bookProjection.add(Projections.property("publishYear"), "publishYear");
        bookProjection.add(Projections.property("genre"), "genre");
        bookProjection.add(Projections.property("author"), "author");
    }


    @Transactional
    @Override
    public List<Book> getBooks() {
        return createBookList(createBookCriteria());
    }

    @Transactional
    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return createBookList(createBookCriteria().add(Restrictions.ilike("author.name", author.getName(), MatchMode.ANYWHERE)));
    }

    @Transactional
    @Override
    public List<Book> getBooksByName(String name) {
        return createBookList(createBookCriteria().add(Restrictions.ilike("b.name", name, MatchMode.ANYWHERE)));
    }

    @Transactional
    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        return createBookList(createBookCriteria().add(Restrictions.ilike("genre.name", genre.getName(), MatchMode.ANYWHERE)));
    }

    @Transactional
    @Override
    public List<Book> getBooksByLetter(Character letter) {
        return createBookList(createBookCriteria().add(Restrictions.ilike("name", letter.toString(), MatchMode.START)));
    }

    private void createAliases(DetachedCriteria detachedCriteria) {
        detachedCriteria.createAlias("b.author", "author");
        detachedCriteria.createAlias("b.publisher", "publisher");
        detachedCriteria.createAlias("b.genre", "genre");
    }

    private List<Book> createBookList(DetachedCriteria detachedCriteria){
        sessionFactory.getCurrentSession().beginTransaction();
        Criteria executableCriteria = detachedCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        executableCriteria.addOrder(Order.asc("b.name"))
                .setProjection(bookProjection)
                .setResultTransformer(Transformers.aliasToBean(Book.class));
        List<Book> list = executableCriteria.list();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return list;
    }

    private DetachedCriteria createBookCriteria(){
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Book.class, "b");
        createAliases(detachedCriteria);
        return detachedCriteria;
    }
}
