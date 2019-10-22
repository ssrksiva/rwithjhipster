package com.stpl.javar.service.dto;

import java.time.Instant;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the HelperTable entity.
 */
public class HelperTableDTO implements Serializable {

    private String id;

    @NotNull
    private Integer helperTableSid;

    @Size(max = 100)
    private String description;

    @Size(max = 50)
    private String listName;

    private BigDecimal refCount;

    @NotNull
    private Integer createdBy;

    @NotNull
    private Instant createdDate;

    @NotNull
    private Integer modifiedBy;

    @NotNull
    private Instant modifiedDate;

    @Size(max = 1000)
    private String aliasName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getHelperTableSid() {
        return helperTableSid;
    }

    public void setHelperTableSid(Integer helperTableSid) {
        this.helperTableSid = helperTableSid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public BigDecimal getRefCount() {
        return refCount;
    }

    public void setRefCount(BigDecimal refCount) {
        this.refCount = refCount;
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

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HelperTableDTO helperTableDTO = (HelperTableDTO) o;
        if (helperTableDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), helperTableDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "HelperTableDTO{" +
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
