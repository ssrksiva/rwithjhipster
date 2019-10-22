package com.stpl.javar.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.stpl.javar.service.HelperTableService;
import com.stpl.javar.web.rest.errors.BadRequestAlertException;
import com.stpl.javar.web.rest.util.HeaderUtil;
import com.stpl.javar.web.rest.util.PaginationUtil;
import com.stpl.javar.service.dto.HelperTableDTO;
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
 * REST controller for managing HelperTable.
 */
@RestController
@RequestMapping("/api")
public class HelperTableResource {

    private final Logger log = LoggerFactory.getLogger(HelperTableResource.class);

    private static final String ENTITY_NAME = "helperTable";

    private HelperTableService helperTableService;

    public HelperTableResource(HelperTableService helperTableService) {
        this.helperTableService = helperTableService;
    }

    /**
     * POST  /helper-tables : Create a new helperTable.
     *
     * @param helperTableDTO the helperTableDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new helperTableDTO, or with status 400 (Bad Request) if the helperTable has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/helper-tables")
    @Timed
    public ResponseEntity<HelperTableDTO> createHelperTable(@Valid @RequestBody HelperTableDTO helperTableDTO) throws URISyntaxException {
        log.debug("REST request to save HelperTable : {}", helperTableDTO);
        if (helperTableDTO.getId() != null) {
            throw new BadRequestAlertException("A new helperTable cannot already have an ID", ENTITY_NAME, "idexists");
        }
        HelperTableDTO result = helperTableService.save(helperTableDTO);
        return ResponseEntity.created(new URI("/api/helper-tables/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /helper-tables : Updates an existing helperTable.
     *
     * @param helperTableDTO the helperTableDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated helperTableDTO,
     * or with status 400 (Bad Request) if the helperTableDTO is not valid,
     * or with status 500 (Internal Server Error) if the helperTableDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/helper-tables")
    @Timed
    public ResponseEntity<HelperTableDTO> updateHelperTable(@Valid @RequestBody HelperTableDTO helperTableDTO) throws URISyntaxException {
        log.debug("REST request to update HelperTable : {}", helperTableDTO);
        if (helperTableDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        HelperTableDTO result = helperTableService.save(helperTableDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, helperTableDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /helper-tables : get all the helperTables.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of helperTables in body
     */
    @GetMapping("/helper-tables")
    @Timed
    public ResponseEntity<List<HelperTableDTO>> getAllHelperTables(Pageable pageable) {
        log.debug("REST request to get a page of HelperTables");
        Page<HelperTableDTO> page = helperTableService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/helper-tables");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /helper-tables/:id : get the "id" helperTable.
     *
     * @param id the id of the helperTableDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the helperTableDTO, or with status 404 (Not Found)
     */
    @GetMapping("/helper-tables/{id}")
    @Timed
    public ResponseEntity<HelperTableDTO> getHelperTable(@PathVariable String id) {
        log.debug("REST request to get HelperTable : {}", id);
        Optional<HelperTableDTO> helperTableDTO = helperTableService.findOne(id);
        return ResponseUtil.wrapOrNotFound(helperTableDTO);
    }

    /**
     * DELETE  /helper-tables/:id : delete the "id" helperTable.
     *
     * @param id the id of the helperTableDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/helper-tables/{id}")
    @Timed
    public ResponseEntity<Void> deleteHelperTable(@PathVariable String id) {
        log.debug("REST request to delete HelperTable : {}", id);
        helperTableService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }
}
