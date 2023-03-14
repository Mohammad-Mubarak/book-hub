package com.example.Library_management_System.Repository;

import com.example.Library_management_System.Models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Integer> {
}
