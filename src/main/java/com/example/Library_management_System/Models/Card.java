package com.example.Library_management_System.Models;

import com.example.Library_management_System.Enum.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Student_Cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp //Auto timestamp the time when on entry is created
    Date createdOn;

    @UpdateTimestamp  // sets time when an entry is updated
    Date updatedOn;

    @Enumerated(value = EnumType.STRING) // not understand enum so we converting into string
    private CardStatus cardStatus;

     // syntax for uni directional
     @OneToOne
     @JoinColumn
     private Students student; // this variable is used in parent class
    //while doing the bidirectional mapping





    // unidirection for card and book
    // card is parent wrt to book
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
   private List<Book> bookissued;


    public List<Book> getBookissued() {
        return bookissued;
    }

    public void setBookissued(List<Book> bookissued) {
        this.bookissued = bookissued;
    }

    // unidirection for card and Transaction
    // card is parest wrt to Transaction
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transactions>  transactions= new ArrayList<Transactions>();

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public Card(){
   bookissued = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }
}

