package com.customer.benefits.loyalty.controller;

import com.customer.benefits.loyalty.model.Customer;
import com.customer.benefits.loyalty.model.dto.CustomerDto;
import com.customer.benefits.loyalty.model.dto.CustomerTransactionDto;
import com.customer.benefits.loyalty.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody final CustomerDto customerDto){
        Customer customer = customerService.addCustomer(Customer.from(customerDto));
        return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getCustomers(){
        List<Customer> customers = customerService.getCustomers();
        List<CustomerDto> CustomersDto = customers.stream().map(CustomerDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(CustomersDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CustomerTransactionDto> getCustomer(@PathVariable final Long id){
        Customer customer = customerService.getCustomer(id);
        return new ResponseEntity<>(CustomerTransactionDto.from(customer), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable final Long id){
        Customer customer = customerService.deleteCustomer(id);
        return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CustomerDto> editCustomer(@PathVariable final Long id,
                                                @RequestBody final CustomerDto customerDto){
        Customer customer = customerService.editCustomer(id, Customer.from(customerDto));
        return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.OK);
    }

    @PostMapping(value = "{CustomerId}/transactions/{transactionId}/add")
    public ResponseEntity<CustomerTransactionDto> addItemToCustomer(@PathVariable final Long CustomerId,
                                                     @PathVariable final Long transactionId){
        Customer customer = customerService.addTransactionToCustomer(CustomerId, transactionId);
        return new ResponseEntity<>(CustomerTransactionDto.from(customer), HttpStatus.OK);
    }

    @DeleteMapping(value = "{CustomerId}/transactions/{transactionId}/remove")
    public ResponseEntity<CustomerDto> removeItemFromCustomer(@PathVariable final Long CustomerId,
                                                          @PathVariable final Long transactionId){
        Customer customer = customerService.removeTransactionFromCustomer(CustomerId, transactionId);
        return new ResponseEntity<>(CustomerDto.from(customer), HttpStatus.OK);
    }

    @GetMapping(value = "/available/{id}")
    public ResponseEntity<CustomerTransactionDto> getAllAvailablePoints(@PathVariable final Long id){
        Customer customer = customerService.getCustomerAvailablePoints(id);
        return new ResponseEntity<>(CustomerTransactionDto.from(customer), HttpStatus.OK);
    }

    @GetMapping(value = "/pending/{id}")
    public ResponseEntity<CustomerTransactionDto> getAllPendingPoints(@PathVariable final Long id){
        Customer customer = customerService.getCustomerAvailablePoints(id);
        return new ResponseEntity<>(CustomerTransactionDto.from(customer), HttpStatus.OK);
    }
}