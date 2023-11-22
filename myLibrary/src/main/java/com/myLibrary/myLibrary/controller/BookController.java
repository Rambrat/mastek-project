package com.myLibrary.myLibrary.controller;

import com.myLibrary.myLibrary.dto.BookDto;
import com.myLibrary.myLibrary.helper.ApiResponseMsg;
import com.myLibrary.myLibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/save-book")
    public ResponseEntity<BookDto> saveBook(@RequestBody BookDto bookDto){

        BookDto savedBook = bookService.saveBook(bookDto);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/{bookId}")
     public ResponseEntity<BookDto> getBookById(@PathVariable String bookId){
        BookDto bookById = bookService.getBookById(bookId);
        return new ResponseEntity<>(bookById,HttpStatus.OK);
    }

    @GetMapping("/all-book-details")
    public ResponseEntity<List<BookDto>> getAllBookInLibrary(){
        List<BookDto> allBookDetails = bookService.getAllBookDetails();
        return ResponseEntity.ok(allBookDetails);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookDto> UpdateBookById(@PathVariable String bookId,@RequestBody BookDto bookDto){
        BookDto updateBookById = bookService.updateBook(bookId,bookDto);
        return new ResponseEntity<>(updateBookById,HttpStatus.OK);
    }

    @DeleteMapping("/{deleteBookId}")
    public ResponseEntity<ApiResponseMsg> deleteBookById(@PathVariable String deleteBookId){
        bookService.deleteBookById(deleteBookId);

        ApiResponseMsg apiResponseMsg = ApiResponseMsg.builder()
                .message("Successfully Deleted")
                .status(HttpStatus.OK)
                .success(true).build();

        return ResponseEntity.ok(apiResponseMsg);
    }
}
