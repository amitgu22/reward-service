package com.customer.benefits.loyalty.model.exception;

public class RedemptionNotAllowedException extends RuntimeException {

    public RedemptionNotAllowedException(final String s){
        super(s);
    }
}
