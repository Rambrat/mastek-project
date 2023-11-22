package com.myLibrary.myLibrary.services.impl;

import com.myLibrary.myLibrary.dto.BookDto;
import com.myLibrary.myLibrary.entities.Book;
import com.myLibrary.myLibrary.exceptions.ResourceNotFoundException;
import com.myLibrary.myLibrary.repository.BookRepository;
import com.myLibrary.myLibrary.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public BookDto saveBook(BookDto bookDto) {

        String book_id = UUID.randomUUID().toString();
        bookDto.setId(book_id);
        bookDto.setPublishedDate(new Date());
        Book book = modelMapper.map(bookDto, Book.class);
        bookRepository.save(book);
        return modelMapper.map(book,BookDto.class);
    }

    @Override
    public BookDto getBookById(String bookId) {

        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("book not found for book_id" + bookId));
        return modelMapper.map(book,BookDto.class);
    }

    @Override
    public List<BookDto> getAllBookDetails() {
        List<Book> books = bookRepository.findAll();
        return Collections.singletonList(modelMapper.map(books, BookDto.class));
    }

    @Override
    public BookDto updateBook(String bookId, BookDto bookDto) {

        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("book not found for book_id" + bookId));
        book.setAuthor(bookDto.getAuthor());
        book.setGenre(bookDto.getGenre());
        book.setISBN(bookDto.getISBN());
        book.setTitle(bookDto.getTitle());

        bookRepository.save(book);
        return modelMapper.map(book,BookDto.class);
    }

    @Override
    public void deleteBookById(String bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("book not found for book_id" + bookId));
         bookRepository.delete(book);
    }
}
