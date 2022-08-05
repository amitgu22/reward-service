package com.customer.benefits.loyalty.model;

import com.customer.benefits.loyalty.model.dto.CustomerDto;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "cust_Id")
    private Long id;
    private String name;
    private String city;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = false
            //mappedBy = "customer",
            //targetEntity = Customer.class

    )
    @JoinColumn(name = "CUSTOMER_ID")
    private List<Transaction> transactions = new ArrayList<>();




    public void addItem(Transaction transaction){
        transactions.add(transaction);
    }

    public void removeItem(Transaction transaction){
        transactions.remove(transaction);
    }

    public static Customer from(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setName(customerDto.getCustomerName());
        customer.setCity(customerDto.getCustomerCity());
        customer.setId(customerDto.getCustomerId());
        //customer.getTransactions().stream().filter(transaction -> transaction.setCustomer(customer)).collect(Collectors.toList());
        //customer.setTransactions(customerDto.getTransactions().stream().map(Transaction::from).collect(Collectors.toList()));
        return customer;
    }
}
