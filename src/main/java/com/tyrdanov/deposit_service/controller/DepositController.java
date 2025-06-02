package com.tyrdanov.deposit_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyrdanov.deposit_service.dto.DepositRequest;
import com.tyrdanov.deposit_service.dto.InterestResponse;
import com.tyrdanov.deposit_service.model.Deposit;
import com.tyrdanov.deposit_service.service.DepositService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/deposits")
public class DepositController {

    private final DepositService service;

    @PostMapping("/open")
    public Deposit openDeposit(@RequestBody DepositRequest request) {
        return service.openDeposit(request);
    }

    @GetMapping("/{id}/interest")
    public InterestResponse getInterest(@PathVariable Long id) {
        return service.calculateInterest(id);
    }
}
