package com.upgrad.PaymentService.repository;

import com.upgrad.PaymentService.entities.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetailsEntity,Integer> {
}
