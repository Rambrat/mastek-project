package com.myLibrary.myLibrary.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "book_details_table")
@Builder
public class Book {

    @Id
    public String id;
    @Column(name = "book_title", length = 100)
    public String title;
    @Column(name = "book_author", length = 100)
    public String author;
    public int ISBN;
    public Date publishedDate;
    public String genre;
}
