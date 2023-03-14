package com.example.Library_management_System.Repository;

import com.example.Library_management_System.Models.author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<author,Integer> {

}
