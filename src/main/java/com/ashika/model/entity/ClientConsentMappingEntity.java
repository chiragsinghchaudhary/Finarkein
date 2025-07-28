package com.ashika.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Client_Consent_Mapping")
@IdClass(ClientConsentMappingEntity.ClientConsentMappingId.class)
public class ClientConsentMappingEntity {

    @Id
    private String clientCode;

    @Id
    private String pan;

    @Id
    private String state;

    @Id
    private String consentStatus;

    @Id
    private String dataFetchStatus;

    private LocalDate dob;
    private String email;
    private String requestId;
    private String consentHandle;

    // Composite key class
    public static class ClientConsentMappingId implements Serializable {
        private String clientCode;
        private String pan;
        private String state;
        private String consentStatus;
        private String dataFetchStatus;

        // Getters & Setters
        public String getClientCode() { return clientCode; }
        public void setClientCode(String clientCode) { this.clientCode = clientCode; }

        public String getPan() { return pan; }
        public void setPan(String pan) { this.pan = pan; }

        public String getState() { return state; }
        public void setState(String state) { this.state = state; }

        public String getConsentStatus() { return consentStatus; }
        public void setConsentStatus(String consentStatus) { this.consentStatus = consentStatus; }

        public String getDataFetchStatus() { return dataFetchStatus; }
        public void setDataFetchStatus(String dataFetchStatus) { this.dataFetchStatus = dataFetchStatus; }
    }

    // Getters & Setters
    public String getClientCode() { return clientCode; }
    public void setClientCode(String clientCode) { this.clientCode = clientCode; }

    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getConsentStatus() { return consentStatus; }
    public void setConsentStatus(String consentStatus) { this.consentStatus = consentStatus; }

    public String getDataFetchStatus() { return dataFetchStatus; }
    public void setDataFetchStatus(String dataFetchStatus) { this.dataFetchStatus = dataFetchStatus; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getConsentHandle() { return consentHandle; }
    public void setConsentHandle(String consentHandle) { this.consentHandle = consentHandle; }
}

