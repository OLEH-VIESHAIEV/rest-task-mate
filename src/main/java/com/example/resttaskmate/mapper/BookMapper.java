package com.example.resttaskmate.mapper;

import com.example.resttaskmate.dto.request.BookRequestDto;
import com.example.resttaskmate.dto.response.BookResponseDto;
import com.example.resttaskmate.model.Book;
import com.example.resttaskmate.service.AuthorService;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    private final AuthorService authorService;

    public BookMapper(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Book mapToModel(BookRequestDto requestDto) {
        Book book = new Book();
        book.setBookName(requestDto.getBookName());
        book.setPublishedAmount(requestDto.getPublishedAmount());
        book.setSoldAmount(requestDto.getSoldAmount());
        book.setAuthor(authorService.getById(requestDto.getAuthorId()));
        return book;
    }

    public BookResponseDto mapToDto(Book book) {
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setBookName(book.getBookName());
        bookResponseDto.setPublishedAmount(book.getPublishedAmount());
        bookResponseDto.setSoldAmount(book.getSoldAmount());
        bookResponseDto.setAuthorId(book.getAuthor().getId());
        return bookResponseDto;
    }
}
