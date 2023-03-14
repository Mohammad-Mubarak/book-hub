package com.example.Library_management_System.Models;

import com.example.Library_management_System.Enum.Genre;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private  int age;
    private String country;
    private double Rating;

    // bidirectional mapping here
    // parent wrt to Book
    @OneToMany(mappedBy ="author",cascade = CascadeType.ALL)
   private List<Book> booksWritten;



    public author() {
        booksWritten = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public List<Book> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(List<Book> booksWritten) {
        this.booksWritten = booksWritten;
    }
}
