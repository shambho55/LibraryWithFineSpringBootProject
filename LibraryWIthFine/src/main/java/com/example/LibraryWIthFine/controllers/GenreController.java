package com.example.LibraryWIthFine.controllers;

import com.example.LibraryWIthFine.entities.Genre;
import com.example.LibraryWIthFine.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public ResponseEntity<List<Genre>> getAllGenres(){

        List<Genre> allGenres = genreService.getAllGenres();

        return ResponseEntity.ok(allGenres);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable Long id){

        Genre existingGenre = genreService.getGenreById(id);

        if(existingGenre == null){

            return ResponseEntity.noContent().build();

        }
        else {

            return ResponseEntity.ok(existingGenre);

        }

    }

    @PostMapping
    public ResponseEntity<Genre> saveGenre(@RequestBody Genre genre){

        genreService.saveOrUpdateGenre(genre);

        return ResponseEntity.ok(genre);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable Long id,@RequestBody Genre genre){

        Genre existingGenre = genreService.getGenreById(id);

        if(existingGenre == null){

            genreService.saveOrUpdateGenre(genre);

            return ResponseEntity.noContent().build();

        }
        else {

            genre.setId(id);

            genreService.saveOrUpdateGenre(genre);

            return ResponseEntity.ok(genre);

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id){

        genreService.deleteGenreById(id);

        return ResponseEntity.noContent().build();

    }

}
