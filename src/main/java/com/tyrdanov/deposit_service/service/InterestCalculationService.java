package com.tyrdanov.deposit_service.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.tyrdanov.deposit_service.dto.InterestResponse;
import com.tyrdanov.deposit_service.model.Deposit;

@Service
public class InterestCalculationService {

    public BigDecimal calculateSimpleInterest(BigDecimal amount, BigDecimal rate, int months) {
        return amount
                .multiply(rate)
                .multiply(BigDecimal.valueOf(months))
                .divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateCompoundInterest(BigDecimal amount, BigDecimal rate, int months) {
        final var monthlyRate = rate.divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_UP);
        BigDecimal total = amount;

        for (int i = 0; i < months; i++) {
            total = total.add(total.multiply(monthlyRate));
        }

        return total.subtract(amount).setScale(2, RoundingMode.HALF_UP);
    }

    public InterestResponse calculateInterest(Deposit deposit) {
        final var product = deposit.getProduct();
        BigDecimal interest = null;

        if (product.isCapitalization()) {
            interest = calculateCompoundInterest(
                    deposit.getAmount(),
                    product.getInterestRate(),
                    product.getTermMonths());
        } else {
            interest = calculateSimpleInterest(
                    deposit.getAmount(),
                    product.getInterestRate(),
                    product.getTermMonths());
        }

        return InterestResponse
                .builder()
                .interest(interest)
                .formula("Формула: " + (product.isCapitalization() ? "с капитализацией" : "простые проценты"))
                .build();
    }

}
