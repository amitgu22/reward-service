package com.customer.benefits.loyalty.model.dto;

import com.customer.benefits.loyalty.model.Transaction;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TransactionsDto {

    private String transactionDescription;

    private Double transactionAmount;

    private LocalDate transactionDate;

    @ApiModelProperty(hidden = true)
    private Double loyaltyPoints;



    @ApiModelProperty(hidden = true)
    private Long transactionId;

    @ApiModelProperty(hidden = true)
    private String status;



    public static TransactionsDto from(Transaction transaction){
        TransactionsDto transactionsDto = new TransactionsDto();
        //transactionsDto.setLoyaltyPoints(transaction.getLoyaltyPoints());
        transactionsDto.setTransactionDescription(transaction.getTransactionDescription());
        transactionsDto.setTransactionAmount(transaction.getTransactionAmount());
        transactionsDto.setTransactionDate(transaction.getTransactionDate());
        //transactionsDto.setTransactionId(transaction.getTransactionId());
        //transactionsDto.setCustomerId(transaction.getCustomer().getId());
        return transactionsDto;
    }

    public static TransactionsDto responseFrom(Transaction transaction){
        TransactionsDto transactionsDto = new TransactionsDto();
        transactionsDto.setLoyaltyPoints(transaction.getLoyaltyPoints());
        transactionsDto.setTransactionDescription(transaction.getTransactionDescription());
        transactionsDto.setTransactionAmount(transaction.getTransactionAmount());
        transactionsDto.setTransactionDate(transaction.getTransactionDate());
        transactionsDto.setTransactionId(transaction.getTransactionId());
        transactionsDto.setStatus(transaction.getStatus());
        //transactionsDto.setCustomerId(transaction.getCustomer().getId());
        return transactionsDto;
    }
}
