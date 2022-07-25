package com.example.resttaskmate.controller;

import com.example.resttaskmate.dto.request.AuthorRequestDto;
import com.example.resttaskmate.dto.response.AuthorResponseDto;
import com.example.resttaskmate.mapper.AuthorMapper;
import com.example.resttaskmate.model.Author;
import com.example.resttaskmate.service.AuthorService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    public AuthorController(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping
    public AuthorResponseDto save(@RequestBody @Valid AuthorRequestDto requestDto) {
        return authorMapper.mapToDto(authorService.save(authorMapper.mapToModel(requestDto)));
    }

    @GetMapping("/{id}")
    public AuthorResponseDto getById(@PathVariable Long id) {
        return authorMapper.mapToDto(authorService.getById(id));
    }

    @GetMapping
    public List<AuthorResponseDto> getAll() {
        return authorService.getAll()
                .stream()
                .map(authorMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("{id}")
    public AuthorResponseDto update(@PathVariable Long id,
                                    @Valid @RequestBody AuthorRequestDto requestDto) {
        Author author = authorMapper.mapToModel(requestDto);
        author.setId(id);
        return authorMapper.mapToDto(authorService.save(author));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
}
