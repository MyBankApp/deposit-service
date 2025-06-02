package com.tyrdanov.deposit_service.mapper;

import java.time.LocalDate;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.tyrdanov.deposit_service.dto.DepositRequest;
import com.tyrdanov.deposit_service.model.Deposit;
import com.tyrdanov.deposit_service.model.DepositProduct;

@Mapper
public interface DepositMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", source = "product")
    @Mapping(target = "endDate", source = "product", qualifiedByName = "getEndDate")
    @Mapping(target = "startDate", source = "request", qualifiedByName = "getStartDate")
    Deposit toModel(DepositRequest request, DepositProduct product);

    @Named("getEndDate")
    default LocalDate getEndDate(DepositProduct product) {
        return LocalDate.now().plusMonths(product.getTermMonths());
    }

    @Named("getStartDate")
    default LocalDate getStartDate(DepositRequest request) {
        return LocalDate.now();
    }

}
