package com.pexon.api.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController
{
    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping(path="api/v1/book")
    public List<Book> getBooks()
    {
        return bookService.getBooks();
    }

    @PostMapping(path="api/v1/book")
    public Book setBook(@RequestBody Book newBook) { return bookService.setBook(newBook); }

    @DeleteMapping(path="api/v1/book/{id}")
    public void deleteBook(@PathVariable int id) { bookService.deleteById(id);}
}
