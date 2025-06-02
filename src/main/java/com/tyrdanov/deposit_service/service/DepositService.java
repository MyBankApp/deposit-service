package com.tyrdanov.deposit_service.service;

import org.springframework.stereotype.Service;

import com.tyrdanov.deposit_service.dto.DepositRequest;
import com.tyrdanov.deposit_service.dto.GetDepositRequest;
import com.tyrdanov.deposit_service.dto.InterestResponse;
import com.tyrdanov.deposit_service.mapper.DepositMapper;
import com.tyrdanov.deposit_service.model.Deposit;
import com.tyrdanov.deposit_service.repository.DepositProductRepository;
import com.tyrdanov.deposit_service.repository.DepositRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepositService {

    private final DepositMapper mapper;
    private final DepositRepository depositRepository;
    private final DepositProductRepository productRepository;
    private final InterestCalculationService interestService;

    public Deposit getByUserId(GetDepositRequest request) {
        final var userId = request.getUserId();
        
        return depositRepository
                .findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Deposit not found"));
    }

    public Deposit openDeposit(DepositRequest request) {
        final var productId = request.getProductId();
        final var product = productRepository
                .findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        final var deposit = mapper.toModel(request, product);

        return depositRepository.save(deposit);
    }

    public InterestResponse calculateInterest(Long depositId) {
        final var deposit = depositRepository
                .findById(depositId)
                .orElseThrow(() -> new RuntimeException("Deposit not found"));

        return interestService.calculateInterest(deposit);
    }

}
