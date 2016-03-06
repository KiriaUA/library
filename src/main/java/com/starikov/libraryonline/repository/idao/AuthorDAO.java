package com.starikov.libraryonline.repository.idao;


import com.starikov.libraryonline.entities.Author;

import java.util.List;

public interface AuthorDAO {
    List<Author> getAuthors();
}
