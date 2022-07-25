package com.example.resttaskmate.service;

import com.example.resttaskmate.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    Book getById(Long id);

    List<Book> getAll();

    void delete(Long id);

    List<Book> getAllByAuthorName(String authorName);

    Book getMostSellingBookByAuthorName(String authorName);

    Book getMostPublishedBookByAuthorName(String authorName);

    List<Book> getAllMostSellingBooksByPartAuthorName(String authorPartName);

    List<Book> getAllMostPublishedBooksByPartAuthorName(String authorPartName);

    List<Book> getAllMostSuccessfulBooksByPartAuthorName(String authorPartName);
}
