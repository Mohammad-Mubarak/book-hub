package com.example.Library_management_System.DTO;

import com.example.Library_management_System.Enum.Genre;

public class BookResponseDto {

//    BookResponseDto bookResponseDto = new BookResponseDto();
//            bookResponseDto.setGenre(b.getGenre());
//            bookResponseDto.setPages(b.getPages());
//            bookResponseDto.setName(b.getName());
//
//            booksWrittenDto.add(bookResponseDto);
//}
     private Genre genre;
     private int page;
     private String name;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
