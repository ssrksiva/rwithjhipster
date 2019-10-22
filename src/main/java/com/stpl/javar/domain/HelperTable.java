package com.stpl.javar.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A HelperTable.
 */
@Document(collection = "helper_table")
public class HelperTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Field("helper_table_sid")
    private Integer helperTableSid;

    @Size(max = 100)
    @Field("description")
    private String description;

    @Size(max = 50)
    @Field("list_name")
    private String listName;

    @Field("ref_count")
    private BigDecimal refCount;

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

    @Size(max = 1000)
    @Field("alias_name")
    private String aliasName;

    @DBRef
    @Field("companyMaster")
    private Set<CompanyMaster> companyMasters = new HashSet<>();
   
    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getHelperTableSid() {
        return helperTableSid;
    }

    public HelperTable helperTableSid(Integer helperTableSid) {
        this.helperTableSid = helperTableSid;
        return this;
    }

    public void setHelperTableSid(Integer helperTableSid) {
        this.helperTableSid = helperTableSid;
    }

    public String getDescription() {
        return description;
    }

    public HelperTable description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getListName() {
        return listName;
    }

    public HelperTable listName(String listName) {
        this.listName = listName;
        return this;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public BigDecimal getRefCount() {
        return refCount;
    }

    public HelperTable refCount(BigDecimal refCount) {
        this.refCount = refCount;
        return this;
    }

    public void setRefCount(BigDecimal refCount) {
        this.refCount = refCount;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public HelperTable createdBy(Integer createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public HelperTable createdDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public HelperTable modifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Instant getModifiedDate() {
        return modifiedDate;
    }

    public HelperTable modifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
        return this;
    }

    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getAliasName() {
        return aliasName;
    }

    public HelperTable aliasName(String aliasName) {
        this.aliasName = aliasName;
        return this;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }


    public void setCompanyMasters(Set<CompanyMaster> companyMasters) {
        this.companyMasters = companyMasters;
    }

    public Set<CompanyMaster> getCompanyMasters() {
        return companyMasters;
    }

    public HelperTable companyMasters(Set<CompanyMaster> companyMasters) {
        this.companyMasters = companyMasters;
        return this;
    }

    public HelperTable addCompanyMaster(CompanyMaster companyMaster) {
        this.companyMasters.add(companyMaster);
        companyMaster.setCountry(this);
        return this;
    }

    public HelperTable removeCompanyMaster(CompanyMaster companyMaster) {
        this.companyMasters.remove(companyMaster);
        companyMaster.setCountry(null);
        return this;
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
        HelperTable helperTable = (HelperTable) o;
        if (helperTable.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), helperTable.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "HelperTable{" +
            "id=" + getId() +
            ", helperTableSid=" + getHelperTableSid() +
            ", description='" + getDescription() + "'" +
            ", listName='" + getListName() + "'" +
            ", refCount=" + getRefCount() +
            ", createdBy=" + getCreatedBy() +
            ", createdDate='" + getCreatedDate() + "'" +
            ", modifiedBy=" + getModifiedBy() +
            ", modifiedDate='" + getModifiedDate() + "'" +
            ", aliasName='" + getAliasName() + "'" +
            "}";
    }
}
