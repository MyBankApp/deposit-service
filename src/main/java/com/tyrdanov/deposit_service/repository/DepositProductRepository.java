package com.tyrdanov.deposit_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyrdanov.deposit_service.model.DepositProduct;

@Repository
public interface DepositProductRepository extends JpaRepository<DepositProduct, Long> {
}
