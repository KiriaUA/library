package com.starikov.libraryonline.utils;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class Utils implements IUtils{

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public List<String> getLetters(){
        List<String> characters = new ArrayList<>();
        sessionFactory.getCurrentSession().beginTransaction();
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("select left(name, 1) from book order by name");
        for (Object ch : sqlQuery.list()) {
            characters.add((String) ch);
        }
        sessionFactory.getCurrentSession().getTransaction().commit();
        return characters;
    }
}
