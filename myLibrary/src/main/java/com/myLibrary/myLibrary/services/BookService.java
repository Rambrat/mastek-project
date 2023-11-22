package com.myLibrary.myLibrary.services;


import com.myLibrary.myLibrary.dto.BookDto;

import java.util.List;

public interface BookService {

    public BookDto saveBook(BookDto bookDto);
    public BookDto getBookById(String bookId);
    public List<BookDto> getAllBookDetails();
    public BookDto updateBook(String bookId,BookDto bookDto);
    public void deleteBookById(String bookId);
}
