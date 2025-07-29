package com.ashika.model.dto;

public record DepositHolderDTO(
    Long id,
    String type,
    String address,
    Boolean ckycCompliance,
    Long dob,
    String email,
    String landline,
    String mobile,
    String name,
    String nominee,
    String pan
) {}

