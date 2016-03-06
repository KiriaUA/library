package com.starikov.libraryonline.repository.idao;


import com.starikov.libraryonline.entities.Author;
import com.starikov.libraryonline.entities.Book;
import com.starikov.libraryonline.entities.Genre;

import java.util.List;

public interface BookDAO {
    List<Book> getBooks();
    List<Book> getBooksByAuthor(Author author);
    List<Book> getBooksByName(String name);
    List<Book> getBooksByGenre(Genre genre);
    List<Book> getBooksByLetter(Character letter);
}
