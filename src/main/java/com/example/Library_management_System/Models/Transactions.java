package com.example.Library_management_System.Models;

import com.example.Library_management_System.Enum.TransactionStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Enumerated(value=EnumType.STRING)
    private TransactionStatus transactionStatus;

    private  int fine;
    private  String transactionId= UUID.randomUUID().toString();


    @CreationTimestamp
    private Date transactionDate;


    private boolean IsIssuedOperation;

    //mapping to card and book Transaction IS child wrt to card and book

    //connecting with book
    @ManyToOne
    @JoinColumn
    private Book book;


    //connecting with card
    @ManyToOne
    @JoinColumn
    private Card card;//book entity PK come here and become foregin key

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Transactions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isIssuedOperation() {
        return IsIssuedOperation;
    }

    public void setIssuedOperation(boolean issuedOperation) {
        IsIssuedOperation = issuedOperation;
    }
}
