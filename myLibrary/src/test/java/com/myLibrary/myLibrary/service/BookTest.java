package com.myLibrary.myLibrary.service;

import com.myLibrary.myLibrary.entities.Book;
import com.myLibrary.myLibrary.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class BookTest {

    //@Autowired
    @MockBean
    private BookRepository bookRepository;

    private Book bookDetails;

    @BeforeEach
    public void init(){
      bookDetails = Book.builder()
              .id("abcdefgh")
                .author("TestAuthor")
                .ISBN(12345)
                .title("TestTitle")
                .genre("TestGenre").build();

    }

    @Test
    public void saveBookTest(){
        Mockito.when(bookRepository.save(Mockito.any())).thenReturn(bookDetails);
        Assertions.assertEquals(bookDetails.getAuthor(),"TestAuthor");
    }

    @Test
    public void saveBookById(){
        Mockito.when(bookRepository.findById(Mockito.anyString())).thenReturn(Optional.ofNullable(bookDetails));
        Assertions.assertEquals(bookDetails.getId(),"abcdefgh");
    }

}
