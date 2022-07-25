package com.example.resttaskmate.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookRequestDto {
    @NotNull
    private String bookName;
    @Min(value = 1)
    private Long authorId;
    @Min(value = 0)
    private Long publishedAmount;
    @Min(value = 0)
    private Long soldAmount;
}
