package com.example.resttaskmate.mapper;

import com.example.resttaskmate.dto.request.AuthorRequestDto;
import com.example.resttaskmate.dto.response.AuthorResponseDto;
import com.example.resttaskmate.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public Author mapToModel(AuthorRequestDto requestDto) {
        Author author = new Author();
        author.setAuthorName(requestDto.getAuthorName());
        author.setBirthDate(requestDto.getBirthDate());
        author.setPhone(requestDto.getPhone());
        author.setEmail(requestDto.getEmail());
        return author;
    }

    public AuthorResponseDto mapToDto(Author author) {
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setId(author.getId());
        authorResponseDto.setAuthorName(author.getAuthorName());
        authorResponseDto.setBirthDate(author.getBirthDate());
        authorResponseDto.setPhone(author.getPhone());
        authorResponseDto.setEmail(author.getEmail());
        return authorResponseDto;
    }
}
