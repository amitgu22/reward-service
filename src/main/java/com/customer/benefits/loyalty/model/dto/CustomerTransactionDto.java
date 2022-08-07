package com.customer.benefits.loyalty.model.dto;

import com.customer.benefits.loyalty.model.Customer;
import com.customer.benefits.loyalty.model.Transaction;
import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CustomerTransactionDto {
    private Long customerId;
    private String customerName;
    private String customerCity;
    private List<TransactionsDto> transactions = new ArrayList<>();
    private Double totalEarnedLoyaltyBonus;
    private Double redeemedLoyaltyBonus;
    private Double remainingLoyaltyBonus;

    public static CustomerTransactionDto from(Customer customer){
        return CustomerTransactionDto.builder().customerId(customer.getId())
                        .customerCity(customer.getCity())
                        .customerName(customer.getName())
                        .totalEarnedLoyaltyBonus(customer.getTransactions().stream().mapToDouble(Transaction::getTransactionAmount).sum())
                        .transactions(customer.getTransactions().stream().map(TransactionsDto::responseFrom).collect(Collectors.toList()))
                        .build();

    }

    public static CustomerTransactionDto fromRedemption(Customer customer,Double amount){

        CustomerTransactionDto customerTransactionDto = from(customer);
        customerTransactionDto.setTransactions(Collections.emptyList());
        customerTransactionDto.setRedeemedLoyaltyBonus(amount);
        customerTransactionDto.setRemainingLoyaltyBonus(customerTransactionDto.getTotalEarnedLoyaltyBonus() -
                customerTransactionDto.getRedeemedLoyaltyBonus());
        return customerTransactionDto;
    }
}
