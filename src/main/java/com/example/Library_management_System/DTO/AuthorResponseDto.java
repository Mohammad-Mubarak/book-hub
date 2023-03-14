package com.example.Library_management_System.DTO;

import java.util.List;

public class AuthorResponseDto {
 private String name;
 private  int age;
 private double rating;
 private List<BookResponseDto> booksWritten;

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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<BookResponseDto> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(List<BookResponseDto> booksWritten) {
        this.booksWritten = booksWritten;
    }
}
