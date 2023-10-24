package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("issue-book/{bookId}/{cardId}")
    public ResponseEntity issueBook(@PathVariable("bookId") Integer bookId , @PathVariable("cardId") Integer cardId) {
        try{
            return new ResponseEntity<>(transactionService.issueBook(bookId,cardId) , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }
    }

    @PostMapping("return-book/{bookId}/{cardId}")
    public ResponseEntity returnBook(@PathVariable("bookId") Integer bookId , @PathVariable("cardId") Integer cardId) {
        try{
            return new ResponseEntity<>(transactionService.returnBook(bookId,cardId) , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
        }
    }
}
