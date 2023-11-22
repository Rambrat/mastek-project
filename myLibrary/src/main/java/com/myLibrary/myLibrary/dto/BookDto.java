package com.myLibrary.myLibrary.dto;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BookDto {
    public String id;
    public String title;
    public String author;
    public int ISBN;
    public Date publishedDate;
    public String genre;
}
