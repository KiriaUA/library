package com.starikov.libraryonline.repository;

import com.starikov.libraryonline.entities.Genre;
import com.starikov.libraryonline.repository.idao.GenreDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDAOImpl implements GenreDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Genre> getGenres() {
        sessionFactory.getCurrentSession().beginTransaction();
        List list = sessionFactory.getCurrentSession().createQuery("from Genre order by name").list();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return list;
    }
}
