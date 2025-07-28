package com.ashika.model.dto;

import java.time.LocalDate;

public record ClientConsentMappingDTO(
        String clientCode,
        String pan,
        String state,
        String consentStatus,
        String dataFetchStatus,
        LocalDate dob,
        String email,
        String requestId,
        String consentHandle
) {}
