package com.example.resttaskmate.controller;

import com.example.resttaskmate.dto.request.BookRequestDto;
import com.example.resttaskmate.dto.response.BookResponseDto;
import com.example.resttaskmate.mapper.BookMapper;
import com.example.resttaskmate.model.Book;
import com.example.resttaskmate.service.BookService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService,
                          BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    public BookResponseDto save(@RequestBody BookRequestDto requestDto) {
        return bookMapper.mapToDto(bookService.save(bookMapper.mapToModel(requestDto)));
    }

    @GetMapping("/{id}")
    public BookResponseDto getById(@PathVariable Long id) {
        return bookMapper.mapToDto(bookService.getById(id));
    }

    @PutMapping("/{id}")
    public BookResponseDto update(@PathVariable Long id,
                                  @Valid @RequestBody BookRequestDto requestDto) {
        Book book = bookMapper.mapToModel(requestDto);
        book.setId(id);
        return bookMapper.mapToDto(bookService.save(book));
    }

    @GetMapping
    public List<BookResponseDto> getAll() {
        return bookService.getAll()
                .stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @GetMapping("/by-author-name")
    public List<BookResponseDto> getAllByAuthorName(@RequestParam String authorName) {
        return bookService.getAllByAuthorName(authorName)
                .stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/most-selling")
    public BookResponseDto getMostSellingBookByAuthorName(@RequestParam String authorName) {
        return bookMapper.mapToDto(bookService.getMostSellingBookByAuthorName(authorName));
    }

    @GetMapping("/most-published")
    public BookResponseDto getMostPublishedBookByAuthorName(@RequestParam String authorName) {
        return bookMapper.mapToDto(bookService.getMostPublishedBookByAuthorName(authorName));
    }

    @GetMapping("/most-selling/by-part-name")
    public List<BookResponseDto> getAllMostSellingBooksByPartAuthorName(
            @RequestParam String authorPartName) {
        return bookService.getAllMostSellingBooksByPartAuthorName(authorPartName)
                .stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/most-published/by-part-name")
    public List<BookResponseDto> getAllMostPublishedBooksByPartAuthorName(
            @RequestParam String authorPartName) {
        return bookService.getAllMostPublishedBooksByPartAuthorName(authorPartName)
                .stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/most-successful-book/by-part-name")
    public List<BookResponseDto> getAllMostSuccessfulBooksByPartAuthorName(
            @RequestParam String authorPartName) {
        return bookService.getAllMostSuccessfulBooksByPartAuthorName(authorPartName)
                .stream()
                .map(bookMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
