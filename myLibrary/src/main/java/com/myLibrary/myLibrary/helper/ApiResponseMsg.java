package com.myLibrary.myLibrary.helper;


import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ApiResponseMsg {

    public String message;
    HttpStatus status;
    boolean success;
}
