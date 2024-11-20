package com.example.LibraryWIthFine.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int amountOfFine;

    @Column
    private int numberOfDaysBookKept;

    @OneToMany(mappedBy = "users",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Books> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfFine() {
        return amountOfFine;
    }

    public void setAmountOfFine(int amountOfFine) {
        this.amountOfFine = amountOfFine;
    }

    public int getNumberOfDaysBookKept() {
        return numberOfDaysBookKept;
    }

    public void setNumberOfDaysBookKept(int numberOfDaysBookKept) {
        this.numberOfDaysBookKept = numberOfDaysBookKept;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}
