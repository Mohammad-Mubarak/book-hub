package com.example.Library_management_System.DTO;

public class AuthorRequestDto {

    // this is JUST object which is used for taking value from postmen

    // it will contain all the values what we want to send from postmen

    // id is not here because we want to send From postmen

    private String name;
    private int age;
    private String country;
    private double rating;

    public AuthorRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


}
