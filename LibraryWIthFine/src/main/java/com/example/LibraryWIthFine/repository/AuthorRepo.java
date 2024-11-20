package com.example.LibraryWIthFine.repository;

import com.example.LibraryWIthFine.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Long> {
}
