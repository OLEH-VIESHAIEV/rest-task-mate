package com.example.resttaskmate.service.impl;

import com.example.resttaskmate.model.Author;
import com.example.resttaskmate.repository.AuthorRepository;
import com.example.resttaskmate.service.AuthorService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Couldn't get author by id " + id));
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
