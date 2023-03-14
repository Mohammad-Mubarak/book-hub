package com.example.Library_management_System.Controller;

import com.example.Library_management_System.DTO.StudentMobileNoUpdateDTO;
import com.example.Library_management_System.Models.Students;
import com.example.Library_management_System.Service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class studentController {

    @Autowired
    studentService studentservice;

    @PostMapping("/add")
    public String addStudent(@RequestBody Students student){
        return  studentservice.addStudent(student);

    }


    @GetMapping("/findnamebyemail")
    public String addStudent(@RequestParam("email")String email){
        return  studentservice.getStudentName(email);

    }

    @PutMapping("/updatemobno")
    public String updateNumber(@RequestBody StudentMobileNoUpdateDTO students){
        return studentservice.UpdateStudent(students);
    }


}
