package com.upgrad.PaymentService.controller;

import com.upgrad.PaymentService.dto.TransactionDTO;
import com.upgrad.PaymentService.entities.TransactionDetailsEntity;
import com.upgrad.PaymentService.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    ModelMapper modelMapper;

    /**
     * Make payment
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity makePayment(TransactionDTO transactionDTO){

        TransactionDetailsEntity newTransaction = modelMapper.map(transactionDTO,TransactionDetailsEntity.class);
        int tranId =transactionService.createTransaction(newTransaction);

        return new ResponseEntity(tranId, HttpStatus.CREATED);

    }

    /**
     *  Get transaction
     */

    @GetMapping(value = "/{transactionId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPaymentById(@PathVariable(name = "transactionId") int transactionId ) throws Exception {

        TransactionDetailsEntity transactionDetails = transactionService.getTransactionById(transactionId);
        TransactionDTO transactionDTO = modelMapper.map(transactionDetails,TransactionDTO.class);

        return new ResponseEntity(transactionDTO,HttpStatus.OK);

    }
}
