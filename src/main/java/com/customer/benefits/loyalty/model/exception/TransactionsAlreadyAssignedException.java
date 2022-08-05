package com.customer.benefits.loyalty.model.exception;

import java.text.MessageFormat;

public class TransactionsAlreadyAssignedException extends RuntimeException{
    public TransactionsAlreadyAssignedException(final Long itemId, final Long cartId){
        super(MessageFormat.format("Transaction: {0} is already assigned to customer: {1}", itemId, cartId));
    }
}
