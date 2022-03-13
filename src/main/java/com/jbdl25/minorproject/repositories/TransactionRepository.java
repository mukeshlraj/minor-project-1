package com.jbdl25.minorproject.repositories;

import com.jbdl25.minorproject.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
