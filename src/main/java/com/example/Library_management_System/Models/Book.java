package com.example.Library_management_System.Models;

import com.example.Library_management_System.Enum.Genre;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private  int pages;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    // book is child wrt to author
    // setting here for foreign key : 3 steps
    @ManyToOne
    @JoinColumn  // add an extra attribute of authorId(parent table PK) for the foregin key of child table
    private author author; // this is parent entity we are connected with



    // book is also child wrt to card
    @ManyToOne
    @JoinColumn
    private  Card card;



    // book is also PARENT wrt to  Transaction
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transactions>  transactions= new ArrayList<Transactions>();


    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public com.example.Library_management_System.Models.author getAuthor() {
        return author;
    }

    public void setAuthor(com.example.Library_management_System.Models.author author) {
        this.author = author;
    }



    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean isBookissued() {
        return bookissued;
    }

    public void setBookissued(boolean bookissued) {
        this.bookissued = bookissued;
    }

    private boolean bookissued;
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

}


/*
we send data from postman we like
{
 "name": "mubarak",
 "pages":233,
 "author":{
  "id": 1
}

Book have author also so we have to pass
author id

 */