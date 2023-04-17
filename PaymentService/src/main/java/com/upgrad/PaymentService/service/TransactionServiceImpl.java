package com.upgrad.PaymentService.service;

import com.upgrad.PaymentService.entities.TransactionDetailsEntity;
import com.upgrad.PaymentService.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactonRepository;

    /*public TransactionServiceImpl(TransactionRepository transactonRepository) {
        this.transactonRepository = transactonRepository;
    }*/

    @Override
    public int createTransaction(TransactionDetailsEntity transactionDetailsEntity) {
        return transactonRepository.save(transactionDetailsEntity).getTransactionId();
    }

    @Override
    public TransactionDetailsEntity getTransactionById(int id) throws Exception {
        Optional<TransactionDetailsEntity> transactionDetailsEntityOp = transactonRepository.findById(id);

        if(transactionDetailsEntityOp.isPresent())
            return transactionDetailsEntityOp.get();
        else
            throw new Exception("Transaction id is invalid");
    }
}
