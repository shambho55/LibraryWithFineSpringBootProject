package com.example.LibraryWIthFine.services;

import com.example.LibraryWIthFine.entities.Genre;
import com.example.LibraryWIthFine.repository.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepo genreRepo;

    public List<Genre> getAllGenres(){

        return genreRepo.findAll();

    }

    public Genre getGenreById(Long id){

        return genreRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found with given id."));

    }

    public Genre saveOrUpdateGenre(Genre genre){

        return genreRepo.save(genre);

    }

    public void deleteGenreById(Long id){

        genreRepo.deleteById(id);

    }

}
