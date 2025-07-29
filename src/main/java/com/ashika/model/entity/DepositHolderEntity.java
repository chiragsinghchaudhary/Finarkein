package com.ashika.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "deposit_profile")
public class DepositHolderEntity {

    private String type;
    private String address;
    private Boolean ckycCompliance;
    private Long dob;
    private String email;
    private String landline;
    private String mobile;
    private String name;
    private String nominee;
    
    @Id
    private String pan;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Boolean getCkycCompliance() { return ckycCompliance; }
    public void setCkycCompliance(Boolean ckycCompliance) { this.ckycCompliance = ckycCompliance; }

    public Long getDob() { return dob; }
    public void setDob(Long dob) { this.dob = dob; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getLandline() { return landline; }
    public void setLandline(String landline) { this.landline = landline; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNominee() { return nominee; }
    public void setNominee(String nominee) { this.nominee = nominee; }

    public String getPan() { return pan; }
    public void setPan(String pan) { this.pan = pan; }
}

