package com.example.LibraryWIthFine.repository;

import com.example.LibraryWIthFine.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre,Long> {
}
