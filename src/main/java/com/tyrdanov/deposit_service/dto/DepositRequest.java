package com.tyrdanov.deposit_service.dto;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepositRequest {

    Long userId;

    BigDecimal amount;

    Long productId;

}
