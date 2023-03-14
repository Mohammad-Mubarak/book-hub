package com.example.Library_management_System.Service;

import com.example.Library_management_System.DTO.BookRequestDto;
import com.example.Library_management_System.Models.Book;
import com.example.Library_management_System.Models.author;
import com.example.Library_management_System.Repository.AuthorRepository;
import com.example.Library_management_System.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository BookRepo;

    public void addBook(BookRequestDto book){
        // i want to get the author entity
        int authorid =book.getAuthorId();


        // now i will be fetching the author entity
        author author = authorRepository.findById(authorid).get();

        // basic attirubtes are already set from postmen

         //we have created this entity so we  can save it on to database
        Book newbook =new Book();


        //basic attributes are being from dto to the entity layer
        newbook.setGenre(book.getGenre());
        newbook.setBookissued(false);
        newbook.setName(book.getName());
        newbook.setPages(book.getPages());


        // setting the foeign key attr in the child class
        newbook.setAuthor(author);


        // need to update the list of book written
        List<Book> bookList = author.getBooksWritten();

        // adding the book to the list
        bookList.add(newbook);

        // setting back to the previous author list
        author.setBooksWritten(bookList);


        // Now we have to save the book and also the author
        // why? because author entry is updated so we need to save the author


        // saving the author
        authorRepository.save(author);
        // save funtion work as update and save both

    }


}
