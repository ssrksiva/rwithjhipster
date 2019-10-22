package com.stpl.javar.service;

import com.stpl.javar.domain.HelperTable;
import com.stpl.javar.repository.HelperTableRepository;
import com.stpl.javar.service.dto.HelperTableDTO;
import com.stpl.javar.service.mapper.HelperTableMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing HelperTable.
 */
@Service
public class HelperTableService {

    private final Logger log = LoggerFactory.getLogger(HelperTableService.class);

    private HelperTableRepository helperTableRepository;

    private HelperTableMapper helperTableMapper;

    public HelperTableService(HelperTableRepository helperTableRepository, HelperTableMapper helperTableMapper) {
        this.helperTableRepository = helperTableRepository;
        this.helperTableMapper = helperTableMapper;
    }

    /**
     * Save a helperTable.
     *
     * @param helperTableDTO the entity to save
     * @return the persisted entity
     */
    public HelperTableDTO save(HelperTableDTO helperTableDTO) {
        log.debug("Request to save HelperTable : {}", helperTableDTO);

        HelperTable helperTable = helperTableMapper.toEntity(helperTableDTO);
        helperTable = helperTableRepository.save(helperTable);
        return helperTableMapper.toDto(helperTable);
    }

    /**
     * Get all the helperTables.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    public Page<HelperTableDTO> findAll(Pageable pageable) {
        log.debug("Request to get all HelperTables");
        return helperTableRepository.findAll(pageable)
            .map(helperTableMapper::toDto);
    }


    /**
     * Get one helperTable by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    public Optional<HelperTableDTO> findOne(String id) {
        log.debug("Request to get HelperTable : {}", id);
        return helperTableRepository.findById(id)
            .map(helperTableMapper::toDto);
    }

    /**
     * Delete the helperTable by id.
     *
     * @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete HelperTable : {}", id);
        helperTableRepository.deleteById(id);
    }
}
