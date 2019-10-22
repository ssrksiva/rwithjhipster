package com.stpl.javar.service.mapper;

import com.stpl.javar.domain.*;
import com.stpl.javar.service.dto.HelperTableDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity HelperTable and its DTO HelperTableDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface HelperTableMapper extends EntityMapper<HelperTableDTO, HelperTable> {


    @Mapping(target = "companyMasters", ignore = true)
    HelperTable toEntity(HelperTableDTO helperTableDTO);

    default HelperTable fromId(String id) {
        if (id == null) {
            return null;
        }
        HelperTable helperTable = new HelperTable();
        helperTable.setId(id);
        return helperTable;
    }
}
