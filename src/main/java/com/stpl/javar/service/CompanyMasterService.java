package com.stpl.javar.service;

import com.stpl.javar.domain.CompanyMaster;
import com.stpl.javar.repository.CompanyMasterRepository;
import com.stpl.javar.service.dto.CompanyMasterDTO;
import com.stpl.javar.service.mapper.CompanyMasterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing CompanyMaster.
 */
@Service
public class CompanyMasterService {

    private final Logger log = LoggerFactory.getLogger(CompanyMasterService.class);

    private CompanyMasterRepository companyMasterRepository;

    private CompanyMasterMapper companyMasterMapper;

    public CompanyMasterService(CompanyMasterRepository companyMasterRepository, CompanyMasterMapper companyMasterMapper) {
        this.companyMasterRepository = companyMasterRepository;
        this.companyMasterMapper = companyMasterMapper;
    }

    /**
     * Save a companyMaster.
     *
     * @param companyMasterDTO the entity to save
     * @return the persisted entity
     */
    public CompanyMasterDTO save(CompanyMasterDTO companyMasterDTO) {
        log.debug("Request to save CompanyMaster : {}", companyMasterDTO);

        CompanyMaster companyMaster = companyMasterMapper.toEntity(companyMasterDTO);
        companyMaster = companyMasterRepository.save(companyMaster);
        return companyMasterMapper.toDto(companyMaster);
    }

    /**
     * Get all the companyMasters.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    public Page<CompanyMasterDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CompanyMasters");
        return companyMasterRepository.findAll(pageable)
            .map(companyMasterMapper::toDto);
    }


    /**
     * Get one companyMaster by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    public Optional<CompanyMasterDTO> findOne(String id) {
        log.debug("Request to get CompanyMaster : {}", id);
        return companyMasterRepository.findById(id)
            .map(companyMasterMapper::toDto);
    }

    /**
     * Delete the companyMaster by id.
     *
     * @param id the id of the entity
     */
    public void delete(String id) {
        log.debug("Request to delete CompanyMaster : {}", id);
        companyMasterRepository.deleteById(id);
    }
}
