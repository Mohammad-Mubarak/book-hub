package com.example.Library_management_System.Repository;

import com.example.Library_management_System.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentRepository extends JpaRepository<Students,Integer> {

      Students findByEmail(String email);



}
