package com.pexon.api.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService
{
    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthors()
    {
        return authorRepository.findAll();
    }

    public Author setAuthor(Author newAuthor) { return authorRepository.save(newAuthor);}

    public void deleteById(int id) { authorRepository.deleteById(id);}
}
