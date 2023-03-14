package com.example.Library_management_System.DTO;


// dtos depend on api calls
// add attributes as required

public class StudentMobileNoUpdateDTO {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public StudentMobileNoUpdateDTO() {
    }

    int id;
    private  String mobileno;


}
