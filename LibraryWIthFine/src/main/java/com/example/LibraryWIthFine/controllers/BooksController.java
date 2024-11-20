package com.example.LibraryWIthFine.controllers;

import com.example.LibraryWIthFine.entities.Author;
import com.example.LibraryWIthFine.entities.Books;
import com.example.LibraryWIthFine.entities.Genre;
import com.example.LibraryWIthFine.entities.Users;
import com.example.LibraryWIthFine.services.AuthorService;
import com.example.LibraryWIthFine.services.BooksService;
import com.example.LibraryWIthFine.services.GenreService;
import com.example.LibraryWIthFine.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<Books>> getAllBooks(){

        List<Books> allBooks = booksService.getAllBooks();

        return ResponseEntity.ok(allBooks);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBooksById(@PathVariable Long id){

        Books existingBook = booksService.getBookById(id);

        if(existingBook == null){
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.ok(existingBook);
        }

    }

    @PostMapping
    public ResponseEntity<Books> saveBooks(@RequestBody Books books){

        List<Author> existingAuthors = new ArrayList<>();

        for(Author author: books.getAuthors()){

            Author authorInPlace = authorService.getAuthorById(author.getId());

            if(authorInPlace == null){

                return ResponseEntity.notFound().build();

            }

            existingAuthors.add(authorInPlace);

        }

        books.setAuthors(existingAuthors);

        List<Genre> existingGenre = new ArrayList<>();

        for(Genre genre: books.getGenres()){

            Genre genreInPlace = genreService.getGenreById(genre.getId());

            if(genreInPlace == null){

                return ResponseEntity.notFound().build();

            }

            existingGenre.add(genreInPlace);

        }

        books.setGenres(existingGenre);

        Users existingUsers = books.getUsers();

        Users userInPlace = usersService.getUserById(existingUsers.getId());

        books.setUsers(existingUsers);



        Books existingBooks = booksService.saveOrUpdateBook(books);

        return ResponseEntity.ok(books);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Books> updateBooks(@PathVariable Long id,@RequestBody Books books){

        List<Author> existingAuthors = new ArrayList<>();

        for(Author author: books.getAuthors()){

            Author authorInPlace = authorService.getAuthorById(author.getId());

            if(authorInPlace == null){

                return ResponseEntity.notFound().build();

            }

            existingAuthors.add(authorInPlace);

        }

        books.setAuthors(existingAuthors);

        List<Genre> existingGenre = new ArrayList<>();

        for(Genre genre: books.getGenres()){

            Genre genreInPlace = genreService.getGenreById(genre.getId());

            if(genreInPlace == null){

                return ResponseEntity.notFound().build();

            }

            existingGenre.add(genreInPlace);

        }

        books.setGenres(existingGenre);

        Users existingUsers = books.getUsers();

        Users userInPlace = usersService.getUserById(existingUsers.getId());

        books.setUsers(existingUsers);

        Books existingBooks = booksService.saveOrUpdateBook(books);

        books.setId(id);

        booksService.saveOrUpdateBook(books);

        return ResponseEntity.ok(books);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooks(@PathVariable Long id) {

        booksService.deleteBookById(id);

        return ResponseEntity.noContent().build();

    }


}
