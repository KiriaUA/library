package com.starikov.libraryonline.controller;


import com.starikov.libraryonline.entities.Genre;
import com.starikov.libraryonline.repository.idao.AuthorDAO;
import com.starikov.libraryonline.service.IService.IBookService;
import com.starikov.libraryonline.service.IService.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IGenreService genreService;

    @Autowired
    private AuthorDAO authorDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String testView(Model model){
        model.addAttribute("books", bookService.getBooks());
        model.addAttribute("author", authorDAO.getAuthors());
        return "welcome";
    }

    @RequestMapping("getGenres")
    @ResponseBody
    public List<Genre> getGenres(){
        return genreService.getGenres();
    }
}
