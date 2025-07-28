package com.ashika.model.dto;

public record MFSummaryDTO(
        Long id,
        Double costValue,
        Double currentValue,
        String fatcaStatus,
        String amc,
        String amfiCode,
        Double closingUnits,
        String folioNo,
        String isin,
        String isinDescription,
        Double lienUnits,
        Double lockinUnits,
        Double nav,
        String navDate,
        String registrar,
        String schemeCategory,
        String schemeCode,
        String schemeOption,
        String schemeTypes,
        String ucc
) {}
