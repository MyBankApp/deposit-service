package com.tyrdanov.deposit_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetDepositRequest {
    
    Long userId;

}
