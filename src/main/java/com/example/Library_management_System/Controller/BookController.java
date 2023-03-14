package com.example.Library_management_System.Controller;
import com.example.Library_management_System.DTO.BookRequestDto;
import com.example.Library_management_System.Models.Book;
import com.example.Library_management_System.Models.author;
import com.example.Library_management_System.Repository.AuthorRepository;
import com.example.Library_management_System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookService bookService;

    @PostMapping("/addbook")
    public String newBook(@RequestBody BookRequestDto book){
           bookService.addBook(book);
          return  "Book added successfully";

    }
}
