package com.pexon.api.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{

    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks()
    {
        return bookRepository.findAll();
    }

    public Book setBook(Book newBook) { return bookRepository.save(newBook); }

    public void deleteById(int id) { bookRepository.deleteById(id); }

}
