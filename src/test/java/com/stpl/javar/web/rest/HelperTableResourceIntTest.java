package com.stpl.javar.web.rest;

import com.stpl.javar.RwithJhipsterApp;

import com.stpl.javar.domain.HelperTable;
import com.stpl.javar.repository.HelperTableRepository;
import com.stpl.javar.service.HelperTableService;
import com.stpl.javar.service.dto.HelperTableDTO;
import com.stpl.javar.service.mapper.HelperTableMapper;
import com.stpl.javar.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;


import static com.stpl.javar.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the HelperTableResource REST controller.
 *
 * @see HelperTableResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RwithJhipsterApp.class)
public class HelperTableResourceIntTest {

    private static final Integer DEFAULT_HELPER_TABLE_SID = 1;
    private static final Integer UPDATED_HELPER_TABLE_SID = 2;

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_LIST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_LIST_NAME = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_REF_COUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_REF_COUNT = new BigDecimal(2);

    private static final Integer DEFAULT_CREATED_BY = 1;
    private static final Integer UPDATED_CREATED_BY = 2;

    private static final Instant DEFAULT_CREATED_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Integer DEFAULT_MODIFIED_BY = 1;
    private static final Integer UPDATED_MODIFIED_BY = 2;

    private static final Instant DEFAULT_MODIFIED_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_MODIFIED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_ALIAS_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ALIAS_NAME = "BBBBBBBBBB";

    @Autowired
    private HelperTableRepository helperTableRepository;

    @Autowired
    private HelperTableMapper helperTableMapper;
    
    @Autowired
    private HelperTableService helperTableService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    private MockMvc restHelperTableMockMvc;

    private HelperTable helperTable;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final HelperTableResource helperTableResource = new HelperTableResource(helperTableService);
        this.restHelperTableMockMvc = MockMvcBuilders.standaloneSetup(helperTableResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static HelperTable createEntity() {
        HelperTable helperTable = new HelperTable()
            .helperTableSid(DEFAULT_HELPER_TABLE_SID)
            .description(DEFAULT_DESCRIPTION)
            .listName(DEFAULT_LIST_NAME)
            .refCount(DEFAULT_REF_COUNT)
            .createdBy(DEFAULT_CREATED_BY)
            .createdDate(DEFAULT_CREATED_DATE)
            .modifiedBy(DEFAULT_MODIFIED_BY)
            .modifiedDate(DEFAULT_MODIFIED_DATE)
            .aliasName(DEFAULT_ALIAS_NAME);
        return helperTable;
    }

    @Before
    public void initTest() {
        helperTableRepository.deleteAll();
        helperTable = createEntity();
    }

    @Test
    public void createHelperTable() throws Exception {
        int databaseSizeBeforeCreate = helperTableRepository.findAll().size();

        // Create the HelperTable
        HelperTableDTO helperTableDTO = helperTableMapper.toDto(helperTable);
        restHelperTableMockMvc.perform(post("/api/helper-tables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(helperTableDTO)))
            .andExpect(status().isCreated());

        // Validate the HelperTable in the database
        List<HelperTable> helperTableList = helperTableRepository.findAll();
        assertThat(helperTableList).hasSize(databaseSizeBeforeCreate + 1);
        HelperTable testHelperTable = helperTableList.get(helperTableList.size() - 1);
        assertThat(testHelperTable.getHelperTableSid()).isEqualTo(DEFAULT_HELPER_TABLE_SID);
        assertThat(testHelperTable.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testHelperTable.getListName()).isEqualTo(DEFAULT_LIST_NAME);
        assertThat(testHelperTable.getRefCount()).isEqualTo(DEFAULT_REF_COUNT);
        assertThat(testHelperTable.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testHelperTable.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
        assertThat(testHelperTable.getModifiedBy()).isEqualTo(DEFAULT_MODIFIED_BY);
        assertThat(testHelperTable.getModifiedDate()).isEqualTo(DEFAULT_MODIFIED_DATE);
        assertThat(testHelperTable.getAliasName()).isEqualTo(DEFAULT_ALIAS_NAME);
    }

    @Test
    public void createHelperTableWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = helperTableRepository.findAll().size();

        // Create the HelperTable with an existing ID
        helperTable.setId("existing_id");
        HelperTableDTO helperTableDTO = helperTableMapper.toDto(helperTable);

        // An entity with an existing ID cannot be created, so this API call must fail
        restHelperTableMockMvc.perform(post("/api/helper-tables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(helperTableDTO)))
            .andExpect(status().isBadRequest());

        // Validate the HelperTable in the database
        List<HelperTable> helperTableList = helperTableRepository.findAll();
        assertThat(helperTableList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    public void checkHelperTableSidIsRequired() throws Exception {
        int databaseSizeBeforeTest = helperTableRepository.findAll().size();
        // set the field null
        helperTable.setHelperTableSid(null);

        // Create the HelperTable, which fails.
        HelperTableDTO helperTableDTO = helperTableMapper.toDto(helperTable);

        restHelperTableMockMvc.perform(post("/api/helper-tables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(helperTableDTO)))
            .andExpect(status().isBadRequest());

        List<HelperTable> helperTableList = helperTableRepository.findAll();
        assertThat(helperTableList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkCreatedByIsRequired() throws Exception {
        int databaseSizeBeforeTest = helperTableRepository.findAll().size();
        // set the field null
        helperTable.setCreatedBy(null);

        // Create the HelperTable, which fails.
        HelperTableDTO helperTableDTO = helperTableMapper.toDto(helperTable);

        restHelperTableMockMvc.perform(post("/api/helper-tables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(helperTableDTO)))
            .andExpect(status().isBadRequest());

        List<HelperTable> helperTableList = helperTableRepository.findAll();
        assertThat(helperTableList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkCreatedDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = helperTableRepository.findAll().size();
        // set the field null
        helperTable.setCreatedDate(null);

        // Create the HelperTable, which fails.
        HelperTableDTO helperTableDTO = helperTableMapper.toDto(helperTable);

        restHelperTableMockMvc.perform(post("/api/helper-tables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(helperTableDTO)))
            .andExpect(status().isBadRequest());

        List<HelperTable> helperTableList = helperTableRepository.findAll();
        assertThat(helperTableList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkModifiedByIsRequired() throws Exception {
        int databaseSizeBeforeTest = helperTableRepository.findAll().size();
        // set the field null
        helperTable.setModifiedBy(null);

        // Create the HelperTable, which fails.
        HelperTableDTO helperTableDTO = helperTableMapper.toDto(helperTable);

        restHelperTableMockMvc.perform(post("/api/helper-tables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(helperTableDTO)))
            .andExpect(status().isBadRequest());

        List<HelperTable> helperTableList = helperTableRepository.findAll();
        assertThat(helperTableList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkModifiedDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = helperTableRepository.findAll().size();
        // set the field null
        helperTable.setModifiedDate(null);

        // Create the HelperTable, which fails.
        HelperTableDTO helperTableDTO = helperTableMapper.toDto(helperTable);

        restHelperTableMockMvc.perform(post("/api/helper-tables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(helperTableDTO)))
            .andExpect(status().isBadRequest());

        List<HelperTable> helperTableList = helperTableRepository.findAll();
        assertThat(helperTableList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void getAllHelperTables() throws Exception {
        // Initialize the database
        helperTableRepository.save(helperTable);

        // Get all the helperTableList
        restHelperTableMockMvc.perform(get("/api/helper-tables?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(helperTable.getId())))
            .andExpect(jsonPath("$.[*].helperTableSid").value(hasItem(DEFAULT_HELPER_TABLE_SID)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].listName").value(hasItem(DEFAULT_LIST_NAME.toString())))
            .andExpect(jsonPath("$.[*].refCount").value(hasItem(DEFAULT_REF_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY)))
            .andExpect(jsonPath("$.[*].createdDate").value(hasItem(DEFAULT_CREATED_DATE.toString())))
            .andExpect(jsonPath("$.[*].modifiedBy").value(hasItem(DEFAULT_MODIFIED_BY)))
            .andExpect(jsonPath("$.[*].modifiedDate").value(hasItem(DEFAULT_MODIFIED_DATE.toString())))
            .andExpect(jsonPath("$.[*].aliasName").value(hasItem(DEFAULT_ALIAS_NAME.toString())));
    }
    
    @Test
    public void getHelperTable() throws Exception {
        // Initialize the database
        helperTableRepository.save(helperTable);

        // Get the helperTable
        restHelperTableMockMvc.perform(get("/api/helper-tables/{id}", helperTable.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(helperTable.getId()))
            .andExpect(jsonPath("$.helperTableSid").value(DEFAULT_HELPER_TABLE_SID))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.listName").value(DEFAULT_LIST_NAME.toString()))
            .andExpect(jsonPath("$.refCount").value(DEFAULT_REF_COUNT.intValue()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY))
            .andExpect(jsonPath("$.createdDate").value(DEFAULT_CREATED_DATE.toString()))
            .andExpect(jsonPath("$.modifiedBy").value(DEFAULT_MODIFIED_BY))
            .andExpect(jsonPath("$.modifiedDate").value(DEFAULT_MODIFIED_DATE.toString()))
            .andExpect(jsonPath("$.aliasName").value(DEFAULT_ALIAS_NAME.toString()));
    }

    @Test
    public void getNonExistingHelperTable() throws Exception {
        // Get the helperTable
        restHelperTableMockMvc.perform(get("/api/helper-tables/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateHelperTable() throws Exception {
        // Initialize the database
        helperTableRepository.save(helperTable);

        int databaseSizeBeforeUpdate = helperTableRepository.findAll().size();

        // Update the helperTable
        HelperTable updatedHelperTable = helperTableRepository.findById(helperTable.getId()).get();
        updatedHelperTable
            .helperTableSid(UPDATED_HELPER_TABLE_SID)
            .description(UPDATED_DESCRIPTION)
            .listName(UPDATED_LIST_NAME)
            .refCount(UPDATED_REF_COUNT)
            .createdBy(UPDATED_CREATED_BY)
            .createdDate(UPDATED_CREATED_DATE)
            .modifiedBy(UPDATED_MODIFIED_BY)
            .modifiedDate(UPDATED_MODIFIED_DATE)
            .aliasName(UPDATED_ALIAS_NAME);
        HelperTableDTO helperTableDTO = helperTableMapper.toDto(updatedHelperTable);

        restHelperTableMockMvc.perform(put("/api/helper-tables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(helperTableDTO)))
            .andExpect(status().isOk());

        // Validate the HelperTable in the database
        List<HelperTable> helperTableList = helperTableRepository.findAll();
        assertThat(helperTableList).hasSize(databaseSizeBeforeUpdate);
        HelperTable testHelperTable = helperTableList.get(helperTableList.size() - 1);
        assertThat(testHelperTable.getHelperTableSid()).isEqualTo(UPDATED_HELPER_TABLE_SID);
        assertThat(testHelperTable.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testHelperTable.getListName()).isEqualTo(UPDATED_LIST_NAME);
        assertThat(testHelperTable.getRefCount()).isEqualTo(UPDATED_REF_COUNT);
        assertThat(testHelperTable.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testHelperTable.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
        assertThat(testHelperTable.getModifiedBy()).isEqualTo(UPDATED_MODIFIED_BY);
        assertThat(testHelperTable.getModifiedDate()).isEqualTo(UPDATED_MODIFIED_DATE);
        assertThat(testHelperTable.getAliasName()).isEqualTo(UPDATED_ALIAS_NAME);
    }

    @Test
    public void updateNonExistingHelperTable() throws Exception {
        int databaseSizeBeforeUpdate = helperTableRepository.findAll().size();

        // Create the HelperTable
        HelperTableDTO helperTableDTO = helperTableMapper.toDto(helperTable);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restHelperTableMockMvc.perform(put("/api/helper-tables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(helperTableDTO)))
            .andExpect(status().isBadRequest());

        // Validate the HelperTable in the database
        List<HelperTable> helperTableList = helperTableRepository.findAll();
        assertThat(helperTableList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteHelperTable() throws Exception {
        // Initialize the database
        helperTableRepository.save(helperTable);

        int databaseSizeBeforeDelete = helperTableRepository.findAll().size();

        // Get the helperTable
        restHelperTableMockMvc.perform(delete("/api/helper-tables/{id}", helperTable.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<HelperTable> helperTableList = helperTableRepository.findAll();
        assertThat(helperTableList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(HelperTable.class);
        HelperTable helperTable1 = new HelperTable();
        helperTable1.setId("id1");
        HelperTable helperTable2 = new HelperTable();
        helperTable2.setId(helperTable1.getId());
        assertThat(helperTable1).isEqualTo(helperTable2);
        helperTable2.setId("id2");
        assertThat(helperTable1).isNotEqualTo(helperTable2);
        helperTable1.setId(null);
        assertThat(helperTable1).isNotEqualTo(helperTable2);
    }

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(HelperTableDTO.class);
        HelperTableDTO helperTableDTO1 = new HelperTableDTO();
        helperTableDTO1.setId("id1");
        HelperTableDTO helperTableDTO2 = new HelperTableDTO();
        assertThat(helperTableDTO1).isNotEqualTo(helperTableDTO2);
        helperTableDTO2.setId(helperTableDTO1.getId());
        assertThat(helperTableDTO1).isEqualTo(helperTableDTO2);
        helperTableDTO2.setId("id2");
        assertThat(helperTableDTO1).isNotEqualTo(helperTableDTO2);
        helperTableDTO1.setId(null);
        assertThat(helperTableDTO1).isNotEqualTo(helperTableDTO2);
    }
}
