package com.example.Library_management_System.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "AllStudent")
public class Students {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private  String  name;

    @Column(unique = true)
    private   String email;

    private  String mobileno;

    private  int age;


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    //Syntax for bi directional
    //name of variable of the parent entity that you have written in child class foreign key attribute
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
     private Card card;



    /*
    steps to find that  // just for rembember

    1.go to the child class (In this case)
    2. out of all the attributes select the foreign key attribute that is helping you connect
    with parent class
    (Ref : @OneToOne
           @JoinColumn
           private Student student;)
    3. choose the variable name of the parentEnty(refrence : student)
     */







    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Students() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
