package com.stpl.javar.service.mapper;

import com.stpl.javar.domain.*;
import com.stpl.javar.service.dto.CompanyMasterDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity CompanyMaster and its DTO CompanyMasterDTO.
 */
@Mapper(componentModel = "spring", uses = {HelperTableMapper.class})
public interface CompanyMasterMapper extends EntityMapper<CompanyMasterDTO, CompanyMaster> {

    @Mapping(source = "companyType.id", target = "companyTypeId")
    @Mapping(source = "companyStatus.id", target = "companyStatusId")
    @Mapping(source = "companyCategory.id", target = "companyCategoryId")
    @Mapping(source = "companyGroup.id", target = "companyGroupId")
    @Mapping(source = "organizationKey.id", target = "organizationKeyId")
    @Mapping(source = "state.id", target = "stateId")
    @Mapping(source = "country.id", target = "countryId")
    CompanyMasterDTO toDto(CompanyMaster companyMaster);

    @Mapping(source = "companyTypeId", target = "companyType")
    @Mapping(source = "companyStatusId", target = "companyStatus")
    @Mapping(source = "companyCategoryId", target = "companyCategory")
    @Mapping(source = "companyGroupId", target = "companyGroup")
    @Mapping(source = "organizationKeyId", target = "organizationKey")
    @Mapping(source = "stateId", target = "state")
    @Mapping(source = "countryId", target = "country")
    CompanyMaster toEntity(CompanyMasterDTO companyMasterDTO);

    default CompanyMaster fromId(String id) {
        if (id == null) {
            return null;
        }
        CompanyMaster companyMaster = new CompanyMaster();
        companyMaster.setId(id);
        return companyMaster;
    }
}
