package com.stpl.javar.service.dto;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the CompanyMaster entity.
 */
public class CompanyMasterDTO implements Serializable {

    private String id;

    @NotNull
    private Integer companyMasterSid;

    @NotNull
    @Size(max = 50)
    private String companyId;

    @NotNull
    @Size(max = 50)
    private String companyNo;

    @NotNull
    @Size(max = 100)
    private String companyName;

    @NotNull
    private Instant companyStartDate;

    private Instant companyEndDate;

    private Integer lives;

    @Size(max = 50)
    private String financialSystem;

    @Size(max = 100)
    private String address1;

    @Size(max = 100)
    private String address2;

    @Size(max = 50)
    private String city;

    @Size(max = 50)
    private String zipCode;

    @Size(max = 50)
    private String regionCode;

    private Instant lastUpdatedDate;

    @Size(max = 4000)
    private String internalNotes;

    @NotNull
    @Size(max = 1)
    private String inboundStatus;

    @NotNull
    private Boolean recordLockStatus;

    @Size(max = 50)
    private String batchId;

    @Size(max = 50)
    private String source;

    @NotNull
    private Integer createdBy;

    @NotNull
    private Instant createdDate;

    @NotNull
    private Integer modifiedBy;

    @NotNull
    private Instant modifiedDate;

    private String companyTypeId;

    private String companyStatusId;

    private String companyCategoryId;

    private String companyGroupId;

    private String organizationKeyId;

    private String stateId;

    private String countryId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCompanyMasterSid() {
        return companyMasterSid;
    }

    public void setCompanyMasterSid(Integer companyMasterSid) {
        this.companyMasterSid = companyMasterSid;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Instant getCompanyStartDate() {
        return companyStartDate;
    }

    public void setCompanyStartDate(Instant companyStartDate) {
        this.companyStartDate = companyStartDate;
    }

    public Instant getCompanyEndDate() {
        return companyEndDate;
    }

    public void setCompanyEndDate(Instant companyEndDate) {
        this.companyEndDate = companyEndDate;
    }

    public Integer getLives() {
        return lives;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }

    public String getFinancialSystem() {
        return financialSystem;
    }

    public void setFinancialSystem(String financialSystem) {
        this.financialSystem = financialSystem;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Instant getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Instant lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getInternalNotes() {
        return internalNotes;
    }

    public void setInternalNotes(String internalNotes) {
        this.internalNotes = internalNotes;
    }

    public String getInboundStatus() {
        return inboundStatus;
    }

    public void setInboundStatus(String inboundStatus) {
        this.inboundStatus = inboundStatus;
    }

    public Boolean isRecordLockStatus() {
        return recordLockStatus;
    }

    public void setRecordLockStatus(Boolean recordLockStatus) {
        this.recordLockStatus = recordLockStatus;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Instant getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCompanyTypeId() {
        return companyTypeId;
    }

    public void setCompanyTypeId(String helperTableId) {
        this.companyTypeId = helperTableId;
    }

    public String getCompanyStatusId() {
        return companyStatusId;
    }

    public void setCompanyStatusId(String helperTableId) {
        this.companyStatusId = helperTableId;
    }

    public String getCompanyCategoryId() {
        return companyCategoryId;
    }

    public void setCompanyCategoryId(String helperTableId) {
        this.companyCategoryId = helperTableId;
    }

    public String getCompanyGroupId() {
        return companyGroupId;
    }

    public void setCompanyGroupId(String helperTableId) {
        this.companyGroupId = helperTableId;
    }

    public String getOrganizationKeyId() {
        return organizationKeyId;
    }

    public void setOrganizationKeyId(String helperTableId) {
        this.organizationKeyId = helperTableId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String helperTableId) {
        this.stateId = helperTableId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String helperTableId) {
        this.countryId = helperTableId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CompanyMasterDTO companyMasterDTO = (CompanyMasterDTO) o;
        if (companyMasterDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), companyMasterDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CompanyMasterDTO{" +
            "id=" + getId() +
            ", companyMasterSid=" + getCompanyMasterSid() +
            ", companyId='" + getCompanyId() + "'" +
            ", companyNo='" + getCompanyNo() + "'" +
            ", companyName='" + getCompanyName() + "'" +
            ", companyStartDate='" + getCompanyStartDate() + "'" +
            ", companyEndDate='" + getCompanyEndDate() + "'" +
            ", lives=" + getLives() +
            ", financialSystem='" + getFinancialSystem() + "'" +
            ", address1='" + getAddress1() + "'" +
            ", address2='" + getAddress2() + "'" +
            ", city='" + getCity() + "'" +
            ", zipCode='" + getZipCode() + "'" +
            ", regionCode='" + getRegionCode() + "'" +
            ", lastUpdatedDate='" + getLastUpdatedDate() + "'" +
            ", internalNotes='" + getInternalNotes() + "'" +
            ", inboundStatus='" + getInboundStatus() + "'" +
            ", recordLockStatus='" + isRecordLockStatus() + "'" +
            ", batchId='" + getBatchId() + "'" +
            ", source='" + getSource() + "'" +
            ", createdBy=" + getCreatedBy() +
            ", createdDate='" + getCreatedDate() + "'" +
            ", modifiedBy=" + getModifiedBy() +
            ", modifiedDate='" + getModifiedDate() + "'" +
            ", companyType=" + getCompanyTypeId() +
            ", companyStatus=" + getCompanyStatusId() +
            ", companyCategory=" + getCompanyCategoryId() +
            ", companyGroup=" + getCompanyGroupId() +
            ", organizationKey=" + getOrganizationKeyId() +
            ", state=" + getStateId() +
            ", country=" + getCountryId() +
            "}";
    }
}
