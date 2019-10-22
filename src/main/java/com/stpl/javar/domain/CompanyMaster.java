package com.stpl.javar.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A CompanyMaster.
 */
@Document(collection = "company_master")
public class CompanyMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("company_master_sid")
    private Integer companyMasterSid;

    @NotNull
    @Size(max = 50)
    @Field("company_id")
    private String companyId;

    @NotNull
    @Size(max = 50)
    @Field("company_no")
    private String companyNo;

    @NotNull
    @Size(max = 100)
    @Field("company_name")
    private String companyName;

    @NotNull
    @Field("company_start_date")
    private Instant companyStartDate;

    @Field("company_end_date")
    private Instant companyEndDate;

    @Field("lives")
    private Integer lives;

    @Size(max = 50)
    @Field("financial_system")
    private String financialSystem;

    @Size(max = 100)
    @Field("address_1")
    private String address1;

    @Size(max = 100)
    @Field("address_2")
    private String address2;

    @Size(max = 50)
    @Field("city")
    private String city;

    @Size(max = 50)
    @Field("zip_code")
    private String zipCode;

    @Size(max = 50)
    @Field("region_code")
    private String regionCode;

    @Field("last_updated_date")
    private Instant lastUpdatedDate;

    @Size(max = 4000)
    @Field("internal_notes")
    private String internalNotes;

    @NotNull
    @Size(max = 1)
    @Field("inbound_status")
    private String inboundStatus;

    @NotNull
    @Field("record_lock_status")
    private Boolean recordLockStatus;

    @Size(max = 50)
    @Field("batch_id")
    private String batchId;

    @Size(max = 50)
    @Field("source")
    private String source;

    @NotNull
    @Field("created_by")
    private Integer createdBy;

    @NotNull
    @Field("created_date")
    private Instant createdDate;

    @NotNull
    @Field("modified_by")
    private Integer modifiedBy;

    @NotNull
    @Field("modified_date")
    private Instant modifiedDate;

    @DBRef
    @Field("companyType")
    @JsonIgnoreProperties("companyMasters")
    private HelperTable companyType;

    @DBRef
    @Field("companyStatus")
    @JsonIgnoreProperties("companyMasters")
    private HelperTable companyStatus;

    @DBRef
    @Field("companyCategory")
    @JsonIgnoreProperties("companyMasters")
    private HelperTable companyCategory;

    @DBRef
    @Field("companyGroup")
    @JsonIgnoreProperties("companyMasters")
    private HelperTable companyGroup;

    @DBRef
    @Field("organizationKey")
    @JsonIgnoreProperties("companyMasters")
    private HelperTable organizationKey;

    @DBRef
    @Field("state")
    @JsonIgnoreProperties("companyMasters")
    private HelperTable state;

    @DBRef
    @Field("country")
    @JsonIgnoreProperties("companyMasters")
    private HelperTable country;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCompanyMasterSid() {
        return companyMasterSid;
    }

    public CompanyMaster companyMasterSid(Integer companyMasterSid) {
        this.companyMasterSid = companyMasterSid;
        return this;
    }

    public void setCompanyMasterSid(Integer companyMasterSid) {
        this.companyMasterSid = companyMasterSid;
    }

    public String getCompanyId() {
        return companyId;
    }

    public CompanyMaster companyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public CompanyMaster companyNo(String companyNo) {
        this.companyNo = companyNo;
        return this;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public CompanyMaster companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Instant getCompanyStartDate() {
        return companyStartDate;
    }

    public CompanyMaster companyStartDate(Instant companyStartDate) {
        this.companyStartDate = companyStartDate;
        return this;
    }

    public void setCompanyStartDate(Instant companyStartDate) {
        this.companyStartDate = companyStartDate;
    }

    public Instant getCompanyEndDate() {
        return companyEndDate;
    }

    public CompanyMaster companyEndDate(Instant companyEndDate) {
        this.companyEndDate = companyEndDate;
        return this;
    }

    public void setCompanyEndDate(Instant companyEndDate) {
        this.companyEndDate = companyEndDate;
    }

    public Integer getLives() {
        return lives;
    }

    public CompanyMaster lives(Integer lives) {
        this.lives = lives;
        return this;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }

    public String getFinancialSystem() {
        return financialSystem;
    }

    public CompanyMaster financialSystem(String financialSystem) {
        this.financialSystem = financialSystem;
        return this;
    }

    public void setFinancialSystem(String financialSystem) {
        this.financialSystem = financialSystem;
    }

    public String getAddress1() {
        return address1;
    }

    public CompanyMaster address1(String address1) {
        this.address1 = address1;
        return this;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public CompanyMaster address2(String address2) {
        this.address2 = address2;
        return this;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public CompanyMaster city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public CompanyMaster zipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public CompanyMaster regionCode(String regionCode) {
        this.regionCode = regionCode;
        return this;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Instant getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public CompanyMaster lastUpdatedDate(Instant lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
        return this;
    }

    public void setLastUpdatedDate(Instant lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getInternalNotes() {
        return internalNotes;
    }

    public CompanyMaster internalNotes(String internalNotes) {
        this.internalNotes = internalNotes;
        return this;
    }

    public void setInternalNotes(String internalNotes) {
        this.internalNotes = internalNotes;
    }

    public String getInboundStatus() {
        return inboundStatus;
    }

    public CompanyMaster inboundStatus(String inboundStatus) {
        this.inboundStatus = inboundStatus;
        return this;
    }

    public void setInboundStatus(String inboundStatus) {
        this.inboundStatus = inboundStatus;
    }

    public Boolean isRecordLockStatus() {
        return recordLockStatus;
    }

    public CompanyMaster recordLockStatus(Boolean recordLockStatus) {
        this.recordLockStatus = recordLockStatus;
        return this;
    }

    public void setRecordLockStatus(Boolean recordLockStatus) {
        this.recordLockStatus = recordLockStatus;
    }

    public String getBatchId() {
        return batchId;
    }

    public CompanyMaster batchId(String batchId) {
        this.batchId = batchId;
        return this;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getSource() {
        return source;
    }

    public CompanyMaster source(String source) {
        this.source = source;
        return this;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public CompanyMaster createdBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public CompanyMaster createdDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public CompanyMaster modifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Instant getModifiedDate() {
        return modifiedDate;
    }

    public CompanyMaster modifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public HelperTable getCompanyType() {
        return companyType;
    }

    public CompanyMaster companyType(HelperTable helperTable) {
        this.companyType = helperTable;
        return this;
    }

    public void setCompanyType(HelperTable helperTable) {
        this.companyType = helperTable;
    }

    public HelperTable getCompanyStatus() {
        return companyStatus;
    }

    public CompanyMaster companyStatus(HelperTable helperTable) {
        this.companyStatus = helperTable;
        return this;
    }

    public void setCompanyStatus(HelperTable helperTable) {
        this.companyStatus = helperTable;
    }

    public HelperTable getCompanyCategory() {
        return companyCategory;
    }

    public CompanyMaster companyCategory(HelperTable helperTable) {
        this.companyCategory = helperTable;
        return this;
    }

    public void setCompanyCategory(HelperTable helperTable) {
        this.companyCategory = helperTable;
    }

    public HelperTable getCompanyGroup() {
        return companyGroup;
    }

    public CompanyMaster companyGroup(HelperTable helperTable) {
        this.companyGroup = helperTable;
        return this;
    }

    public void setCompanyGroup(HelperTable helperTable) {
        this.companyGroup = helperTable;
    }

    public HelperTable getOrganizationKey() {
        return organizationKey;
    }

    public CompanyMaster organizationKey(HelperTable helperTable) {
        this.organizationKey = helperTable;
        return this;
    }

    public void setOrganizationKey(HelperTable helperTable) {
        this.organizationKey = helperTable;
    }

    public HelperTable getState() {
        return state;
    }

    public CompanyMaster state(HelperTable helperTable) {
        this.state = helperTable;
        return this;
    }

    public void setState(HelperTable helperTable) {
        this.state = helperTable;
    }

    public HelperTable getCountry() {
        return country;
    }

    public CompanyMaster country(HelperTable helperTable) {
        this.country = helperTable;
        return this;
    }

    public void setCountry(HelperTable helperTable) {
        this.country = helperTable;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CompanyMaster companyMaster = (CompanyMaster) o;
        if (companyMaster.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), companyMaster.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CompanyMaster{" +
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
            "}";
    }
}
