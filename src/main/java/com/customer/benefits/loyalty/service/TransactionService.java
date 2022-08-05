package com.customer.benefits.loyalty.service;

import com.customer.benefits.loyalty.model.Transaction;
import com.customer.benefits.loyalty.model.exception.TransactionNotFoundException;
import com.customer.benefits.loyalty.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction addTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactions(){
        return StreamSupport
                .stream(transactionRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Transaction getTransaction(Long id){
        return transactionRepository.findById(id).orElseThrow(() ->
                new TransactionNotFoundException(id));
    }

    public Transaction deleteTransaction(Long id){
        Transaction transaction = getTransaction(id);
        transactionRepository.delete(transaction);
        return transaction;
    }

    @Transactional
    public Transaction editTransaction(Long id, Transaction transaction){
        Transaction transactionToEdit = getTransaction(id);
        transactionToEdit.setTransactionDescription(transaction.getTransactionDescription());
        return transactionToEdit;
    }
}
