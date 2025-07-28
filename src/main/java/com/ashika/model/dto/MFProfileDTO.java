package com.ashika.model.dto;

public record MFProfileDTO(
        Long id,
        String address,
        String dematId,
        Long dob,
        String email,
        String folioNo,
        Boolean kycCompliance,
        String landline,
        String mobile,
        String name,
        String nominee,
        String pan
) {}

