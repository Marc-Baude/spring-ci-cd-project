package com.pexon.api.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController
{
    @Autowired
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(path="api/v1/author")
    public List<Author> getAuthors()
    {
        return authorService.getAuthors();
    }

    @PostMapping(path="api/v1/author")
    public Author setAuthor(@RequestBody Author newAuthor) { return authorService.setAuthor(newAuthor);}

    @DeleteMapping(path="api/v1/author/{id}")
    public void deleteAuthor(@PathVariable int id) { authorService.deleteById(id);}
}
