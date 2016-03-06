package com.starikov.libraryonline.service;

import com.starikov.libraryonline.entities.Author;
import com.starikov.libraryonline.entities.Book;
import com.starikov.libraryonline.entities.Genre;
import com.starikov.libraryonline.repository.idao.BookDAO;
import com.starikov.libraryonline.service.IService.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return bookDAO.getBooksByAuthor(author);
    }

    @Override
    public List<Book> getBooksByName(String name) {
        return bookDAO.getBooksByName(name);
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        return bookDAO.getBooksByGenre(genre);
    }

    @Override
    public List<Book> getBooksByLetter(Character letter) {
        return bookDAO.getBooksByLetter(letter);
    }
}
