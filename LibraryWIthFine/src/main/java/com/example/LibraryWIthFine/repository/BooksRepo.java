package com.example.LibraryWIthFine.repository;

import com.example.LibraryWIthFine.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepo extends JpaRepository<Books,Long> {
}
