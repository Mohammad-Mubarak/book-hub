package com.example.Library_management_System.Controller;

import com.example.Library_management_System.DTO.IssueBookRequestDto;
import com.example.Library_management_System.Service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    TransactionsService transactionsService;


    @PostMapping("issueBook")
    public String issueBook(@RequestBody IssueBookRequestDto IssueBookDto) {
        try{
          return transactionsService.issueBook(IssueBookDto);

        }catch (Exception e){
            return  e.getMessage();
        }
    }

    @GetMapping("txninfo")
    public  String getTxnInfo(@RequestParam("bookId") Integer bookId, @RequestParam("cardId") Integer cardId){
      String id=  transactionsService.getTransactionsForBookAndCard(bookId, cardId);
      return  id;

    }

}
