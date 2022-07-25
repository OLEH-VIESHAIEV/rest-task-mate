package com.example.resttaskmate.service.impl;

import com.example.resttaskmate.model.Book;
import com.example.resttaskmate.repository.BookRepository;
import com.example.resttaskmate.service.BookService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Couldn't get book by id " + id));
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllByAuthorName(String authorName) {
        return bookRepository.findAllByAuthorName(authorName);
    }

    @Override
    public Book getMostSellingBookByAuthorName(String authorName) {
        return bookRepository.findMostSellingBookByAuthorName(authorName);
    }

    @Override
    public Book getMostPublishedBookByAuthorName(String authorName) {
        return bookRepository.findMostPublishedBookByAuthorName(authorName);
    }

    @Override
    public List<Book> getAllMostSellingBooksByPartAuthorName(String authorName) {
        return bookRepository.findAllMostSellingBooksByPartAuthorName(authorName);
    }

    @Override
    public List<Book> getAllMostPublishedBooksByPartAuthorName(String authorName) {
        return bookRepository.findAllMostPublishedBooksByPartAuthorName(authorName);
    }

    @Override
    public List<Book> getAllMostSuccessfulBooksByPartAuthorName(String authorName) {
        return bookRepository.findAllMostSuccessfulBooksByPartAuthorName(authorName);
    }
}
