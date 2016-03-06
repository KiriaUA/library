package com.starikov.libraryonline.service;

import com.starikov.libraryonline.entities.Genre;
import com.starikov.libraryonline.repository.idao.GenreDAO;
import com.starikov.libraryonline.service.IService.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements IGenreService {

    @Autowired
    private GenreDAO genreDAO;

    @Override
    public List<Genre> getGenres() {
        return genreDAO.getGenres();
    }
}
