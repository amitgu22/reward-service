package com.customer.benefits.loyalty.controller;

import com.customer.benefits.loyalty.model.Transaction;
import com.customer.benefits.loyalty.model.dto.TransactionsDto;
import com.customer.benefits.loyalty.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionsDto> addTransaction(@RequestBody final TransactionsDto transactionsDto){
        Transaction transaction = transactionService.addTransaction(Transaction.from(transactionsDto));
        return new ResponseEntity<>(TransactionsDto.responseFrom(transaction), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TransactionsDto>> getTransactions(){
        List<Transaction> transactions = transactionService.getTransactions();
        List<TransactionsDto> TransactionsDto = transactions.stream().map(com.customer.benefits.loyalty.model.dto.TransactionsDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(TransactionsDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<TransactionsDto> getTransaction(@PathVariable final Long id){
        Transaction transaction = transactionService.getTransaction(id);
        return new ResponseEntity<>(TransactionsDto.from(transaction), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<TransactionsDto> deleteTransaction(@PathVariable final Long id){
        Transaction transaction = transactionService.deleteTransaction(id);
        return new ResponseEntity<>(TransactionsDto.from(transaction), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<TransactionsDto> editTransaction(@PathVariable final Long id,
                                                    @RequestBody final TransactionsDto transactionsDto){
        Transaction editedTransaction = transactionService.editTransaction(id, Transaction.from(transactionsDto));
        return new ResponseEntity<>(TransactionsDto.from(editedTransaction), HttpStatus.OK);
    }
}
