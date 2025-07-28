package com.ashika.model.dto;

public record MFTransactionDTO(
        Long id,
        String startDate,
        String endDate,
        String amc,
        String amfiCode,
        Double amount,
        String isin,
        String isinDescription,
        Integer lockInDays,
        String lockInFlag,
        String mode,
        String narration,
        Double nav,
        String navDate,
        String registrar,
        String schemeCode,
        String schemePlan,
        String transactionDate,
        String txnId,
        String type,
        String ucc,
        Double units
) {}

