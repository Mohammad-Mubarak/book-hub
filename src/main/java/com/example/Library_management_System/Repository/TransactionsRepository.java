package com.example.Library_management_System.Repository;

import com.example.Library_management_System.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Integer> {

    @Query(value = "select * from Transactions t where t.book_Id=:bookId and t.card_Id=:cardId and  is_issued_operation=true;",nativeQuery = true)
    List<Transactions> getTransactionsForBookAndCard(int bookId, int cardId);

}
