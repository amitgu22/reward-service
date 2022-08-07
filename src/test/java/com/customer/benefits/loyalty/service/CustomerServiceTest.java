package com.customer.benefits.loyalty.service;

import com.customer.benefits.loyalty.model.dto.CustomerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    @Mock
    CustomerService customerService;

    @Mock
    CustomerDto customerDto;


    @BeforeEach
    void setUp() {
        customerDto.setCustomerCity("BERLIN");

    }

    @Test
    void addCustomer() {


    }

    @Test
    void getCustomers() {
    }

    @Test
    void getCustomer() {
    }

    @Test
    void getCustomerAvailablePoints() {
    }

    @Test
    void isValidWeeklyTransactions() {
    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void editCustomer() {
    }

    @Test
    void addTransactionToCustomer() {
    }

    @Test
    void removeTransactionFromCustomer() {
    }
}