package com.ashika.model.dto;

public record EquitySummaryDTO(
        Long id,
        Double currentValue,
        String holdingMode,
        String isin,
        String isinDescription,
        String issuerName,
        Double lastTradedPrice,
        Double units
) {}

