package com.example.resttaskmate.dto.request;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthorRequestDto {
    @NotNull
    private String authorName;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private String phone;
    @NotNull
    private String email;
}
