package com.tyrdanov.deposit_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tyrdanov.deposit_service.model.DepositProduct;
import com.tyrdanov.deposit_service.repository.DepositProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepositProductService {
    
    private final DepositProductRepository repository;

    public List<DepositProduct> getAll() {
        return repository.findAll();
    }

}
