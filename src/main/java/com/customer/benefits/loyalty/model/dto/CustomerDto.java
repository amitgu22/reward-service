package com.customer.benefits.loyalty.model.dto;

import com.customer.benefits.loyalty.model.Customer;
import lombok.Data;

@Data
public class CustomerDto {
    private Long customerId;
    private String customerName;
    private String customerCity;


    public static CustomerDto from(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(customer.getId());
        customerDto.setCustomerName(customer.getName());
        customerDto.setCustomerCity(customer.getCity());

        return customerDto;
    }
}
