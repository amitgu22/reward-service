package com.customer.benefits.loyalty.model;

import com.customer.benefits.loyalty.model.dto.TransactionsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Transaction")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private String transactionDescription;
    private Double transactionAmount;
    private Double loyaltyPoints;

    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDate transactionDate;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    private String status;

    public static Transaction from(TransactionsDto transactionsDto){
        return Transaction.builder().transactionDescription(transactionsDto.getTransactionDescription())
                .transactionAmount(transactionsDto.getTransactionAmount())
                .transactionDate(transactionsDto.getTransactionDate())
                .transactionDescription(transactionsDto.getTransactionDescription())
                .loyaltyPoints(populateLoyaltyPoints(transactionsDto)).
                build();




    }

    private static Double populateLoyaltyPoints(TransactionsDto transactionsDto){

        // logic for loyalty calculation

        double transactionAmount  = transactionsDto.getTransactionAmount() ;
        double value = 0;

        if(transactionAmount < 5000)
            value= transactionAmount;
        else if(transactionAmount == 5000)
            value = 5000;
        else if(transactionAmount > 5000 && transactionAmount < 7500)
            value = 2 * (transactionAmount -5000) + 5000;
        else if(transactionAmount > 7500)
            value+= 5000 +  2 * (2500) + 3 * (transactionAmount - 7500);

    return value;
    }
}
