package com.starikov.libraryonline.repository.idao;


import com.starikov.libraryonline.entities.Genre;

import java.util.List;

public interface GenreDAO {
    List<Genre> getGenres();
}
