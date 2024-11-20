package com.example.LibraryWIthFine.controllers;

import com.example.LibraryWIthFine.entities.Users;
import com.example.LibraryWIthFine.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(){

        List<Users> allUsers = usersService.getAllUsers();

        return ResponseEntity.ok(allUsers);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id){

        Users existingUsers = usersService.getUserById(id);

        if(existingUsers == null){

            return ResponseEntity.noContent().build();

        }
        else{

            return ResponseEntity.ok(existingUsers);

        }

    }

    @PostMapping
    public ResponseEntity<Users> saveUser(@RequestBody Users users){

        usersService.saveOrUpdateUser(users);

        return ResponseEntity.ok(users);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id,@RequestBody Users users){

        Users existingUser = usersService.getUserById(id);

        if(existingUser == null){

            usersService.saveOrUpdateUser(users);

            return ResponseEntity.noContent().build();

        }
        else{

            users.setId(id);

            usersService.saveOrUpdateUser(users);

            return ResponseEntity.ok(users);

        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){

        usersService.deleteUserById(id);

        return ResponseEntity.noContent().build();

    }

}
