package com.example.LibraryWIthFine.services;

import com.example.LibraryWIthFine.entities.Books;
import com.example.LibraryWIthFine.repository.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BooksRepo booksRepo;

    public List<Books> getAllBooks(){
        return booksRepo.findAll();
    }

    public Books getBookById(Long id){

        return booksRepo.findById(id).
                orElseThrow(() -> new RuntimeException("Books not found with given id."));

    }

    public Books saveOrUpdateBook(Books books){

        return booksRepo.save(books);

    }

    public void deleteBookById(Long id){

        booksRepo.deleteById(id);

    }

}
