package com.example.resttaskmate.service;

import com.example.resttaskmate.model.Author;
import java.util.List;

public interface AuthorService {
    Author save(Author author);

    Author getById(Long id);

    List<Author> getAll();

    void delete(Long id);
}
