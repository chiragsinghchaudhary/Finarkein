package com.ashika.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;

@Entity
@Table(name = "Client_Consent_Mapping_Hist",indexes = {
	    @Index(name = "idx_client_consent_hist_requestId", columnList = "requestId"),
	    @Index(name = "idx_client_consent_hist_pan_requestId", columnList = "pan, requestId")
	})
public class ClientConsentMappingHistEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private String pan;
	@Column(nullable = false)
	private String requestId; 
    private String clientCode;
    @Column(nullable = false)
    private String runType;
    private String state;
    private String consentStatus;
    private String dataFetchStatus;
    private LocalDate dob;
    private String consentHandle;
    private LocalDateTime lastUpdatedTime;

    // Getters & Setters
    
}
