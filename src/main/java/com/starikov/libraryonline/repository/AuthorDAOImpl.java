package com.starikov.libraryonline.repository;


import com.starikov.libraryonline.entities.Author;
import com.starikov.libraryonline.repository.idao.AuthorDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Author> getAuthors() {
        sessionFactory.getCurrentSession().beginTransaction();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Author.class);
        Criteria executableCriteria = detachedCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        List<Author> list = executableCriteria.list();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return list;
    }
}
