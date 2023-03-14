package com.example.Library_management_System.Service;

import com.example.Library_management_System.DTO.AuthorRequestDto;
import com.example.Library_management_System.DTO.AuthorResponseDto;
import com.example.Library_management_System.DTO.BookResponseDto;
import com.example.Library_management_System.Models.Book;
import com.example.Library_management_System.Models.author;
import com.example.Library_management_System.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository author;


    public String createAuthor(AuthorRequestDto auth){

        // convert authorRequestDto --> Author

        author newauthor = new author();


        // we are setting attiributes so we can save into database
        // correct values into database
        newauthor.setName(auth.getName());
        newauthor.setAge(auth.getAge());
        newauthor.setCountry(auth.getCountry());
        newauthor.setRating(auth.getRating());



        author.save(newauthor);
        return "Author added successfullly";

    }

    public AuthorResponseDto getAuthor(Integer id){
        author authorr =  author.findById(id).get();
        //Set its attributes.
        //List<Book> --> List<BookResponseDto>
        List<Book> bookList = authorr.getBooksWritten();

        List<BookResponseDto> booksWrittenDto = new ArrayList<>();

        for(Book b : bookList){

            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.setGenre(b.getGenre());
            bookResponseDto.setPage(b.getPages());
            bookResponseDto.setName(b.getName());

            booksWrittenDto.add(bookResponseDto);
        }


        AuthorResponseDto authorResponseDto = new AuthorResponseDto();

        //Set attributes for authorResponse Dto
        authorResponseDto.setBooksWritten(booksWrittenDto);
        authorResponseDto.setName(authorr.getName());
        authorResponseDto.setAge(authorr.getAge());
        authorResponseDto.setRating(authorr.getRating());

        return authorResponseDto;

    }



}
