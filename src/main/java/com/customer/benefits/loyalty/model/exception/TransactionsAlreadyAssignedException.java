package com.customer.benefits.loyalty.model.exception;

import java.text.MessageFormat;

public class TransactionsAlreadyAssignedException extends RuntimeException{
    public TransactionsAlreadyAssignedException(final Long itemId, final Long cartId){
        super(MessageFormat.format("Item: {0} is already assigned to cart: {1}", itemId, cartId));
    }
}
