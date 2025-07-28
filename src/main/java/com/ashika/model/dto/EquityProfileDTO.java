package com.ashika.model.dto;

public record EquityProfileDTO(
        Long id,
        String address,
        String dematId,
        Long dob,
        String email,
        Boolean kycCompliance,
        String landline,
        String mobile,
        String name,
        String nominee,
        String pan
) {}

