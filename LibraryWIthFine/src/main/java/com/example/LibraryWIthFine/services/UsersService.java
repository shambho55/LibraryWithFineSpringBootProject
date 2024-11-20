package com.example.LibraryWIthFine.services;

import com.example.LibraryWIthFine.entities.Users;
import com.example.LibraryWIthFine.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;

    public List<Users> getAllUsers(){
        return usersRepo.findAll();
    }

    public Users getUserById(Long id){

        return usersRepo.findById(id).
                orElseThrow(() -> new RuntimeException("User not found with given id."));

    }

    public Users saveOrUpdateUser(Users users){

        return usersRepo.save(users);

    }

    public void deleteUserById(Long id){

        usersRepo.deleteById(id);

    }

}
