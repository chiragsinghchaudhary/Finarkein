package com.ashika.model.dto;

public record DepositSummaryDTO(
        Long id,
        Long balanceDatetime,
        String branch,
        String currency,
        Double currentBalance,
        Double currentODLimit,
        Double drawingLimit,
        String exchangeRate,
        String facility,
        String ifscCode,
        String micrCode,
        String openingDate,
        String status,
        String type,
        String transactionType,
        Double amount
) {}

