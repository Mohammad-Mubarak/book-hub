package com.example.Library_management_System.Controller;

import com.example.Library_management_System.DTO.AuthorRequestDto;
import com.example.Library_management_System.DTO.AuthorResponseDto;
import com.example.Library_management_System.Models.author;
import com.example.Library_management_System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/addAuthor")
    public  String addAuthor(@RequestBody AuthorRequestDto author){
        return  authorService.createAuthor(author);

    }

    @GetMapping("/getAuthor")
    public AuthorResponseDto getAuthor(@RequestParam("authorId")Integer authorId){
        return authorService.getAuthor(authorId);
    }



}
