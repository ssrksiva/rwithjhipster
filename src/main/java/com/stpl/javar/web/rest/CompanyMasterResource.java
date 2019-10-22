package com.stpl.javar.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.stpl.javar.service.CompanyMasterService;
import com.stpl.javar.web.rest.errors.BadRequestAlertException;
import com.stpl.javar.web.rest.util.HeaderUtil;
import com.stpl.javar.web.rest.util.PaginationUtil;
import com.stpl.javar.service.dto.CompanyMasterDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing CompanyMaster.
 */
@RestController
@RequestMapping("/api")
public class CompanyMasterResource {

    private final Logger log = LoggerFactory.getLogger(CompanyMasterResource.class);

    private static final String ENTITY_NAME = "companyMaster";

    private CompanyMasterService companyMasterService;

    public CompanyMasterResource(CompanyMasterService companyMasterService) {
        this.companyMasterService = companyMasterService;
    }

    /**
     * POST  /company-masters : Create a new companyMaster.
     *
     * @param companyMasterDTO the companyMasterDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new companyMasterDTO, or with status 400 (Bad Request) if the companyMaster has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/company-masters")
    @Timed
    public ResponseEntity<CompanyMasterDTO> createCompanyMaster(@Valid @RequestBody CompanyMasterDTO companyMasterDTO) throws URISyntaxException {
        log.debug("REST request to save CompanyMaster : {}", companyMasterDTO);
        if (companyMasterDTO.getId() != null) {
            throw new BadRequestAlertException("A new companyMaster cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CompanyMasterDTO result = companyMasterService.save(companyMasterDTO);
        return ResponseEntity.created(new URI("/api/company-masters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /company-masters : Updates an existing companyMaster.
     *
     * @param companyMasterDTO the companyMasterDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated companyMasterDTO,
     * or with status 400 (Bad Request) if the companyMasterDTO is not valid,
     * or with status 500 (Internal Server Error) if the companyMasterDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/company-masters")
    @Timed
    public ResponseEntity<CompanyMasterDTO> updateCompanyMaster(@Valid @RequestBody CompanyMasterDTO companyMasterDTO) throws URISyntaxException {
        log.debug("REST request to update CompanyMaster : {}", companyMasterDTO);
        if (companyMasterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CompanyMasterDTO result = companyMasterService.save(companyMasterDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, companyMasterDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /company-masters : get all the companyMasters.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of companyMasters in body
     */
    @GetMapping("/company-masters")
    @Timed
    public ResponseEntity<List<CompanyMasterDTO>> getAllCompanyMasters(Pageable pageable) {
        log.debug("REST request to get a page of CompanyMasters");
        Page<CompanyMasterDTO> page = companyMasterService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/company-masters");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /company-masters/:id : get the "id" companyMaster.
     *
     * @param id the id of the companyMasterDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the companyMasterDTO, or with status 404 (Not Found)
     */
    @GetMapping("/company-masters/{id}")
    @Timed
    public ResponseEntity<CompanyMasterDTO> getCompanyMaster(@PathVariable String id) {
        log.debug("REST request to get CompanyMaster : {}", id);
        Optional<CompanyMasterDTO> companyMasterDTO = companyMasterService.findOne(id);
        return ResponseUtil.wrapOrNotFound(companyMasterDTO);
    }

    /**
     * DELETE  /company-masters/:id : delete the "id" companyMaster.
     *
     * @param id the id of the companyMasterDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/company-masters/{id}")
    @Timed
    public ResponseEntity<Void> deleteCompanyMaster(@PathVariable String id) {
        log.debug("REST request to delete CompanyMaster : {}", id);
        companyMasterService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }
}
