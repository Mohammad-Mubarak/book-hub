package com.example.Library_management_System.Service;

import com.example.Library_management_System.DTO.IssueBookRequestDto;
import com.example.Library_management_System.Enum.CardStatus;
import com.example.Library_management_System.Enum.TransactionStatus;
import com.example.Library_management_System.Models.Book;
import com.example.Library_management_System.Models.Card;
import com.example.Library_management_System.Models.Transactions;
import com.example.Library_management_System.Repository.BookRepository;
import com.example.Library_management_System.Repository.CardRepository;
import com.example.Library_management_System.Repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionsService {

    @Autowired
    TransactionsRepository transactionsRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;


    public String issueBook(IssueBookRequestDto IssueBookDto) throws Exception{
        int cardId = IssueBookDto.getCardId();
        int bookId = IssueBookDto.getBookId();

         // we are geting this bcz we want to set trasaction layer attributes
        Book book= bookRepository.findById(bookId).get();

        Card card = cardRepository.findById(bookId).get();


        // Make transaction entity set it attributes AND SAVE IT

        Transactions transactions = new Transactions();

        // Setting it attributes
        transactions.setTransactionId(UUID.randomUUID().toString());

        // set foreign key and bidirectional mappint settings
        transactions.setCard(card);
        transactions.setBook(book);
        transactions.setIssuedOperation(true);
        transactions.setTransactionStatus(TransactionStatus.PENDING);


        // attributes left is passed / failed

        //Do some validation
        if(book==null || book.isBookissued()==true){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionsRepository.save(transactions);
            throw new Exception("Book is not available");

        }

        if(card == null || card.getCardStatus() != CardStatus.ACTIVATED){
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionsRepository.save(transactions);
            throw new Exception("Card not activated");
        }


        // we reached the success
        transactions.setTransactionStatus(TransactionStatus.SUCCESS);


        // seting book attributes
        book.setBookissued(true);

        // btw the book and transaction bidirectional
        List<Transactions> transactionsHistory = book.getTransactions();
        transactionsHistory.add(transactions);
        book.setTransactions(transactionsHistory);



        // Need to make changes in card setting card attributes

        List<Book> issusedbookforcard = card.getBookissued();
        issusedbookforcard.add(book);
        card.setBookissued(issusedbookforcard);

       // card and the transaction : bidirectional transaction
        List<Transactions> transactionsHistoryforcard = card.getTransactions();
        transactionsHistoryforcard.add(transactions);
        card.setTransactions(transactionsHistoryforcard);



        // Save the prarent
        cardRepository.save(card);

        return "book is issued successfully";
        // due to cascadeing effect book and transaction automatically save

    }

 public String getTransactionsForBookAndCard(int bookId, int cardId){
        List<Transactions> transactionsList = transactionsRepository.getTransactionsForBookAndCard(bookId, cardId);
        String transactionId = transactionsList.get(0).getTransactionId();
        return transactionId;
  }




}
