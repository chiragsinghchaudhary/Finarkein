package com.ashika.model.dto;

public record DepositTransactionDTO(
        Long id,
        String endDate,
        String startDate,
        Double amount,
        Double currentBalance,
        String mode,
        String narration,
        String reference,
        String transactionId,
        Long transactionTimestamp,
        String type,
        String valueDate
) {}

