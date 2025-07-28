package com.ashika.model.dto;

public record EquityTransactionDTO(
        Long id,
        String startDate,
        String endDate,
        String companyName,
        String equityCategory,
        String exchange,
        String isin,
        String isinDescription,
        String narration,
        String orderId,
        Double rate,
        String transactionDateTime,
        String txnId,
        String type,
        Double units
) {}

