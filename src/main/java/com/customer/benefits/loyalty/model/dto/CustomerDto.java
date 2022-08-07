package com.customer.benefits.loyalty.model.dto;

import com.customer.benefits.loyalty.model.Customer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDto {

    @ApiModelProperty(hidden = true)
    private Long customerId;
    private String customerName;
    private String customerCity;
    @ApiModelProperty(hidden = true)
    private Double redeemedPoints;


    public static CustomerDto from(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(customer.getId());
        customerDto.setCustomerName(customer.getName());
        customerDto.setCustomerCity(customer.getCity());

        return customerDto;
    }
}
