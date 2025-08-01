package com.ashika.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClientConsentMappingHistDTO(
        String clientCode,
        String pan,
        String state,
        String consentStatus,
        String dataFetchStatus,
        LocalDateTime lastUpdatedTime,
        LocalDate dob,
        String email,
        String requestId,
        String consentHandle
) {}

