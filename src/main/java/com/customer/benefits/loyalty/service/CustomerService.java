package com.customer.benefits.loyalty.service;

import com.customer.benefits.loyalty.model.Customer;
import com.customer.benefits.loyalty.model.Transaction;
import com.customer.benefits.loyalty.model.exception.CustomerNotFoundException;
import com.customer.benefits.loyalty.model.exception.TransactionsAlreadyAssignedException;
import com.customer.benefits.loyalty.repository.CustomerRepository;
import com.customer.benefits.loyalty.util.STATUS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final TransactionService transactionService;

    /* TO-DO
        looking for configuration value but throwing number-format exception
        @Value(value = "{$threshold.amount}")
        private double threesHoldAmt;
    */


    @Autowired
    public CustomerService(CustomerRepository customerRepository, TransactionService transactionService) {
        this.customerRepository = customerRepository;
        this.transactionService = transactionService;
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getCustomers(){
        return StreamSupport
                .stream(customerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Customer getCustomer(Long id){
        return customerRepository.findById(id).orElseThrow(() ->
                new CustomerNotFoundException(id));
    }

    public Customer getCustomerAvailablePoints(Long id){
        Optional<Customer> customer =  customerRepository.findById(id);
        if(customer.isPresent() && isValidWeeklyTransactions(customer.get().getTransactions())) {
            customer.get().getTransactions().stream().forEach(transaction -> transaction.setStatus(STATUS.AVAILABLE.name()));
            return customer.orElse(new Customer());
        }else{

            return customer.orElse(new Customer());
        }
    }

    public boolean isValidWeeklyTransactions(List<Transaction> transactions){

        double threesHoldAmt = 500;


    /* for each -  performance is slow taking lot of time
        for (Transaction transaction : transactions) {
            daysOfWeek.add(transaction.getTransactionDate().getDayOfWeek());
            sumAmount+= transaction.getTransactionAmount();
        }

    */

        List<DayOfWeek> dayOfWeeks = transactions.parallelStream().map(transaction -> transaction.getTransactionDate().getDayOfWeek()).collect(Collectors.toList());
        double sumAmount = transactions.stream().mapToDouble(Transaction::getTransactionAmount).sum();

        return dayOfWeeks.size() == 7 && sumAmount > threesHoldAmt;
    }


    public Customer deleteCustomer(Long id){
        Customer customer = getCustomer(id);
        customerRepository.delete(customer);
        return customer;
    }

    @Transactional
    public Customer editCustomer(Long id, Customer customer){
        Customer customerToEdit = getCustomer(id);
        customerToEdit.setName(customer.getName());
        return customerToEdit;
    }

    @Transactional
    public Customer addTransactionToCustomer(Long CustomerId, Long itemId){
        Customer customer = getCustomer(CustomerId);
        Transaction transaction = transactionService.getTransaction(itemId);
        if(Objects.nonNull(transaction.getCustomer())){
            throw new TransactionsAlreadyAssignedException(itemId,
                    transaction.getCustomer().getId());
        }
        customer.addItem(transaction);
        transaction.setCustomer(customer);
        return customer;
    }

    @Transactional
    public Customer removeTransactionFromCustomer(Long CustomerId, Long transactionId){
        Customer customer = getCustomer(CustomerId);
        Transaction transaction = transactionService.getTransaction(transactionId);
        customer.removeItem(transaction);
        return customer;
    }

}
