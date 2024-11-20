package com.example.LibraryWIthFine.services;

import com.example.LibraryWIthFine.entities.Author;
import com.example.LibraryWIthFine.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    public List<Author> getAllAuthors(){

        return authorRepo.findAll();

    }

    public Author getAuthorById(Long id){

        return authorRepo.findById(id).
                orElseThrow(() -> new RuntimeException("Author not found with given id."));

    }

    public Author saveOrUpdateAuthor(Author author){

        return authorRepo.save(author);

    }

    public void deleteAuthorById(Long id){

        authorRepo.deleteById(id);

    }

}
