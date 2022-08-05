package com.customer.benefits.loyalty.model.exception;

import java.text.MessageFormat;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(final Long id){
        super(MessageFormat.format("Could not find cart with id: {0}", id));
    }

}
