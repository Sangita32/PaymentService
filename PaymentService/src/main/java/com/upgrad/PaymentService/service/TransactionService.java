package com.upgrad.PaymentService.service;

import com.upgrad.PaymentService.entities.TransactionDetailsEntity;

public interface TransactionService {

    public int createTransaction(TransactionDetailsEntity transactionDetailsEntity);

    public TransactionDetailsEntity getTransactionById(int id) throws Exception;
}
