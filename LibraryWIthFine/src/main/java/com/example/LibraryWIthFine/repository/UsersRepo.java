package com.example.LibraryWIthFine.repository;

import com.example.LibraryWIthFine.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users,Long> {
}
