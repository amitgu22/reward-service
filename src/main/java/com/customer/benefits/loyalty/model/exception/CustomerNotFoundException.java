package com.customer.benefits.loyalty.model.exception;

import java.text.MessageFormat;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(final Long id){
        super(MessageFormat.format("Could not find customer with id: {0}", id));
    }

}
