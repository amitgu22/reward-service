package com.customer.benefits.loyalty.model.dto;

import com.customer.benefits.loyalty.model.Customer;
import com.customer.benefits.loyalty.model.Transaction;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CustomerTransactionDto {
    private Long customerId;
    private String customerName;
    private String customerCity;
    private List<TransactionsDto> transactions = new ArrayList<>();
    private Double availableLoyaltyBonus;

    public static CustomerTransactionDto from(Customer customer){
        CustomerTransactionDto customerDto = new CustomerTransactionDto();
        customerDto.setCustomerId(customer.getId());
        customerDto.setCustomerName(customer.getName());
        customerDto.setCustomerCity(customer.getCity());
        customerDto.setAvailableLoyaltyBonus(customer.getTransactions().stream().mapToDouble(Transaction::getTransactionAmount).sum());
        customerDto.setTransactions(customer.getTransactions().stream().map(TransactionsDto::responseFrom).collect(Collectors.toList()));
        return customerDto;
    }
}
