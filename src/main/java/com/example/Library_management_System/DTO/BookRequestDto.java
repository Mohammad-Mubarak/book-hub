package com.example.Library_management_System.DTO;

import com.example.Library_management_System.Enum.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class BookRequestDto {
    private String name;
    private int pages;
    @Enumerated(value= EnumType.STRING)
    private Genre genre;
    private int authorId;

    public BookRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
