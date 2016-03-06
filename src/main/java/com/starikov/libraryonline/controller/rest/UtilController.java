package com.starikov.libraryonline.controller.rest;


import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UtilController {

    @Autowired
    private SessionFactory sessionFactory;

    private String test = "test";

    public String getTest() {
        return test;
    }

    @RequestMapping(value = "/getLetters", method = RequestMethod.GET)
    public List getLetters(){
        sessionFactory.getCurrentSession().beginTransaction();
        SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery("select left(name, 1) from book order by name");
        List list = sqlQuery.list();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return list;
    }
}
