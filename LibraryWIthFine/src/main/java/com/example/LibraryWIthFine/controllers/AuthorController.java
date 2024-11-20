package com.example.LibraryWIthFine.controllers;

import com.example.LibraryWIthFine.entities.Author;
import com.example.LibraryWIthFine.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(){

        List<Author> allAuthors = authorService.getAllAuthors();

        return ResponseEntity.ok(allAuthors);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id){

        Author existingAuthor = authorService.getAuthorById(id);

        if(existingAuthor == null){

            return ResponseEntity.noContent().build();

        }
        else{

            return ResponseEntity.ok(existingAuthor);

        }

    }

    @PostMapping
    public ResponseEntity<Author> saveAuthor(@RequestBody Author author){

        authorService.saveOrUpdateAuthor(author);

        return ResponseEntity.ok(author);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id,@RequestBody Author author){

        Author existingAuthor = authorService.getAuthorById(id);

        if(existingAuthor == null){

            authorService.saveOrUpdateAuthor(author);

            return ResponseEntity.noContent().build();

        }
        else{

            author.setId(id);
            authorService.saveOrUpdateAuthor(author);

            return ResponseEntity.ok(author);

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id){

        authorService.deleteAuthorById(id);

        return ResponseEntity.noContent().build();

    }

}
