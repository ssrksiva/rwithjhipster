package com.stpl.javar.web.rest;

import com.stpl.javar.RwithJhipsterApp;

import com.stpl.javar.domain.CompanyMaster;
import com.stpl.javar.domain.HelperTable;
import com.stpl.javar.domain.HelperTable;
import com.stpl.javar.repository.CompanyMasterRepository;
import com.stpl.javar.service.CompanyMasterService;
import com.stpl.javar.service.dto.CompanyMasterDTO;
import com.stpl.javar.service.mapper.CompanyMasterMapper;
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

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;


import static com.stpl.javar.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the CompanyMasterResource REST controller.
 *
 * @see CompanyMasterResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RwithJhipsterApp.class)
public class CompanyMasterResourceIntTest {

    private static final Integer DEFAULT_COMPANY_MASTER_SID = 1;
    private static final Integer UPDATED_COMPANY_MASTER_SID = 2;

    private static final String DEFAULT_COMPANY_ID = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_ID = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY_NO = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_NO = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_NAME = "BBBBBBBBBB";

    private static final Instant DEFAULT_COMPANY_START_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_COMPANY_START_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_COMPANY_END_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_COMPANY_END_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Integer DEFAULT_LIVES = 1;
    private static final Integer UPDATED_LIVES = 2;

    private static final String DEFAULT_FINANCIAL_SYSTEM = "AAAAAAAAAA";
    private static final String UPDATED_FINANCIAL_SYSTEM = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS_1 = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS_2 = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS_2 = "BBBBBBBBBB";

    private static final String DEFAULT_CITY = "AAAAAAAAAA";
    private static final String UPDATED_CITY = "BBBBBBBBBB";

    private static final String DEFAULT_ZIP_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ZIP_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_REGION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_REGION_CODE = "BBBBBBBBBB";

    private static final Instant DEFAULT_LAST_UPDATED_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_LAST_UPDATED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_INTERNAL_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_INTERNAL_NOTES = "BBBBBBBBBB";

    private static final String DEFAULT_INBOUND_STATUS = "A";
    private static final String UPDATED_INBOUND_STATUS = "B";

    private static final Boolean DEFAULT_RECORD_LOCK_STATUS = false;
    private static final Boolean UPDATED_RECORD_LOCK_STATUS = true;

    private static final String DEFAULT_BATCH_ID = "AAAAAAAAAA";
    private static final String UPDATED_BATCH_ID = "BBBBBBBBBB";

    private static final String DEFAULT_SOURCE = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE = "BBBBBBBBBB";

    private static final Integer DEFAULT_CREATED_BY = 1;
    private static final Integer UPDATED_CREATED_BY = 2;

    private static final Instant DEFAULT_CREATED_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Integer DEFAULT_MODIFIED_BY = 1;
    private static final Integer UPDATED_MODIFIED_BY = 2;

    private static final Instant DEFAULT_MODIFIED_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_MODIFIED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private CompanyMasterRepository companyMasterRepository;

    @Autowired
    private CompanyMasterMapper companyMasterMapper;
    
    @Autowired
    private CompanyMasterService companyMasterService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    private MockMvc restCompanyMasterMockMvc;

    private CompanyMaster companyMaster;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CompanyMasterResource companyMasterResource = new CompanyMasterResource(companyMasterService);
        this.restCompanyMasterMockMvc = MockMvcBuilders.standaloneSetup(companyMasterResource)
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
    public static CompanyMaster createEntity() {
        CompanyMaster companyMaster = new CompanyMaster()
            .companyMasterSid(DEFAULT_COMPANY_MASTER_SID)
            .companyId(DEFAULT_COMPANY_ID)
            .companyNo(DEFAULT_COMPANY_NO)
            .companyName(DEFAULT_COMPANY_NAME)
            .companyStartDate(DEFAULT_COMPANY_START_DATE)
            .companyEndDate(DEFAULT_COMPANY_END_DATE)
            .lives(DEFAULT_LIVES)
            .financialSystem(DEFAULT_FINANCIAL_SYSTEM)
            .address1(DEFAULT_ADDRESS_1)
            .address2(DEFAULT_ADDRESS_2)
            .city(DEFAULT_CITY)
            .zipCode(DEFAULT_ZIP_CODE)
            .regionCode(DEFAULT_REGION_CODE)
            .lastUpdatedDate(DEFAULT_LAST_UPDATED_DATE)
            .internalNotes(DEFAULT_INTERNAL_NOTES)
            .inboundStatus(DEFAULT_INBOUND_STATUS)
            .recordLockStatus(DEFAULT_RECORD_LOCK_STATUS)
            .batchId(DEFAULT_BATCH_ID)
            .source(DEFAULT_SOURCE)
            .createdBy(DEFAULT_CREATED_BY)
            .createdDate(DEFAULT_CREATED_DATE)
            .modifiedBy(DEFAULT_MODIFIED_BY)
            .modifiedDate(DEFAULT_MODIFIED_DATE);
        // Add required entity
        HelperTable helperTable = HelperTableResourceIntTest.createEntity();
        helperTable.setId("fixed-id-for-tests");
        companyMaster.setCompanyType(helperTable);
        // Add required entity
        companyMaster.setCompanyStatus(helperTable);
        return companyMaster;
    }

    @Before
    public void initTest() {
        companyMasterRepository.deleteAll();
        companyMaster = createEntity();
    }

    @Test
    public void createCompanyMaster() throws Exception {
        int databaseSizeBeforeCreate = companyMasterRepository.findAll().size();

        // Create the CompanyMaster
        CompanyMasterDTO companyMasterDTO = companyMasterMapper.toDto(companyMaster);
        restCompanyMasterMockMvc.perform(post("/api/company-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(companyMasterDTO)))
            .andExpect(status().isCreated());

        // Validate the CompanyMaster in the database
        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeCreate + 1);
        CompanyMaster testCompanyMaster = companyMasterList.get(companyMasterList.size() - 1);
        assertThat(testCompanyMaster.getCompanyMasterSid()).isEqualTo(DEFAULT_COMPANY_MASTER_SID);
        assertThat(testCompanyMaster.getCompanyId()).isEqualTo(DEFAULT_COMPANY_ID);
        assertThat(testCompanyMaster.getCompanyNo()).isEqualTo(DEFAULT_COMPANY_NO);
        assertThat(testCompanyMaster.getCompanyName()).isEqualTo(DEFAULT_COMPANY_NAME);
        assertThat(testCompanyMaster.getCompanyStartDate()).isEqualTo(DEFAULT_COMPANY_START_DATE);
        assertThat(testCompanyMaster.getCompanyEndDate()).isEqualTo(DEFAULT_COMPANY_END_DATE);
        assertThat(testCompanyMaster.getLives()).isEqualTo(DEFAULT_LIVES);
        assertThat(testCompanyMaster.getFinancialSystem()).isEqualTo(DEFAULT_FINANCIAL_SYSTEM);
        assertThat(testCompanyMaster.getAddress1()).isEqualTo(DEFAULT_ADDRESS_1);
        assertThat(testCompanyMaster.getAddress2()).isEqualTo(DEFAULT_ADDRESS_2);
        assertThat(testCompanyMaster.getCity()).isEqualTo(DEFAULT_CITY);
        assertThat(testCompanyMaster.getZipCode()).isEqualTo(DEFAULT_ZIP_CODE);
        assertThat(testCompanyMaster.getRegionCode()).isEqualTo(DEFAULT_REGION_CODE);
        assertThat(testCompanyMaster.getLastUpdatedDate()).isEqualTo(DEFAULT_LAST_UPDATED_DATE);
        assertThat(testCompanyMaster.getInternalNotes()).isEqualTo(DEFAULT_INTERNAL_NOTES);
        assertThat(testCompanyMaster.getInboundStatus()).isEqualTo(DEFAULT_INBOUND_STATUS);
        assertThat(testCompanyMaster.isRecordLockStatus()).isEqualTo(DEFAULT_RECORD_LOCK_STATUS);
        assertThat(testCompanyMaster.getBatchId()).isEqualTo(DEFAULT_BATCH_ID);
        assertThat(testCompanyMaster.getSource()).isEqualTo(DEFAULT_SOURCE);
        assertThat(testCompanyMaster.getCreatedBy()).isEqualTo(DEFAULT_CREATED_BY);
        assertThat(testCompanyMaster.getCreatedDate()).isEqualTo(DEFAULT_CREATED_DATE);
        assertThat(testCompanyMaster.getModifiedBy()).isEqualTo(DEFAULT_MODIFIED_BY);
        assertThat(testCompanyMaster.getModifiedDate()).isEqualTo(DEFAULT_MODIFIED_DATE);
    }

    @Test
    public void createCompanyMasterWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = companyMasterRepository.findAll().size();

        // Create the CompanyMaster with an existing ID
        companyMaster.setId("existing_id");
        CompanyMasterDTO companyMasterDTO = companyMasterMapper.toDto(companyMaster);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCompanyMasterMockMvc.perform(post("/api/company-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(companyMasterDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CompanyMaster in the database
        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    public void checkCompanyMasterSidIsRequired() throws Exception {
        int databaseSizeBeforeTest = companyMasterRepository.findAll().size();
        // set the field null
        companyMaster.setCompanyMasterSid(null);

        // Create the CompanyMaster, which fails.
        CompanyMasterDTO companyMasterDTO = companyMasterMapper.toDto(companyMaster);

        restCompanyMasterMockMvc.perform(post("/api/company-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(companyMasterDTO)))
            .andExpect(status().isBadRequest());

        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkCompanyIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = companyMasterRepository.findAll().size();
        // set the field null
        companyMaster.setCompanyId(null);

        // Create the CompanyMaster, which fails.
        CompanyMasterDTO companyMasterDTO = companyMasterMapper.toDto(companyMaster);

        restCompanyMasterMockMvc.perform(post("/api/company-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(companyMasterDTO)))
            .andExpect(status().isBadRequest());

        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkCompanyNoIsRequired() throws Exception {
        int databaseSizeBeforeTest = companyMasterRepository.findAll().size();
        // set the field null
        companyMaster.setCompanyNo(null);

        // Create the CompanyMaster, which fails.
        CompanyMasterDTO companyMasterDTO = companyMasterMapper.toDto(companyMaster);

        restCompanyMasterMockMvc.perform(post("/api/company-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(companyMasterDTO)))
            .andExpect(status().isBadRequest());

        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkCompanyNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = companyMasterRepository.findAll().size();
        // set the field null
        companyMaster.setCompanyName(null);

        // Create the CompanyMaster, which fails.
        CompanyMasterDTO companyMasterDTO = companyMasterMapper.toDto(companyMaster);

        restCompanyMasterMockMvc.perform(post("/api/company-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(companyMasterDTO)))
            .andExpect(status().isBadRequest());

        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkCompanyStartDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = companyMasterRepository.findAll().size();
        // set the field null
        companyMaster.setCompanyStartDate(null);

        // Create the CompanyMaster, which fails.
        CompanyMasterDTO companyMasterDTO = companyMasterMapper.toDto(companyMaster);

        restCompanyMasterMockMvc.perform(post("/api/company-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(companyMasterDTO)))
            .andExpect(status().isBadRequest());

        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkInboundStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = companyMasterRepository.findAll().size();
        // set the field null
        companyMaster.setInboundStatus(null);

        // Create the CompanyMaster, which fails.
        CompanyMasterDTO companyMasterDTO = companyMasterMapper.toDto(companyMaster);

        restCompanyMasterMockMvc.perform(post("/api/company-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(companyMasterDTO)))
            .andExpect(status().isBadRequest());

        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkRecordLockStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = companyMasterRepository.findAll().size();
        // set the field null
        companyMaster.setRecordLockStatus(null);

        // Create the CompanyMaster, which fails.
        CompanyMasterDTO companyMasterDTO = companyMasterMapper.toDto(companyMaster);

        restCompanyMasterMockMvc.perform(post("/api/company-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(companyMasterDTO)))
            .andExpect(status().isBadRequest());

        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkCreatedByIsRequired() throws Exception {
        int databaseSizeBeforeTest = companyMasterRepository.findAll().size();
        // set the field null
        companyMaster.setCreatedBy(null);

        // Create the CompanyMaster, which fails.
        CompanyMasterDTO companyMasterDTO = companyMasterMapper.toDto(companyMaster);

        restCompanyMasterMockMvc.perform(post("/api/company-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(companyMasterDTO)))
            .andExpect(status().isBadRequest());

        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkCreatedDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = companyMasterRepository.findAll().size();
        // set the field null
        companyMaster.setCreatedDate(null);

        // Create the CompanyMaster, which fails.
        CompanyMasterDTO companyMasterDTO = companyMasterMapper.toDto(companyMaster);

        restCompanyMasterMockMvc.perform(post("/api/company-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(companyMasterDTO)))
            .andExpect(status().isBadRequest());

        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkModifiedByIsRequired() throws Exception {
        int databaseSizeBeforeTest = companyMasterRepository.findAll().size();
        // set the field null
        companyMaster.setModifiedBy(null);

        // Create the CompanyMaster, which fails.
        CompanyMasterDTO companyMasterDTO = companyMasterMapper.toDto(companyMaster);

        restCompanyMasterMockMvc.perform(post("/api/company-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(companyMasterDTO)))
            .andExpect(status().isBadRequest());

        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void checkModifiedDateIsRequired() throws Exception {
        int databaseSizeBeforeTest = companyMasterRepository.findAll().size();
        // set the field null
        companyMaster.setModifiedDate(null);

        // Create the CompanyMaster, which fails.
        CompanyMasterDTO companyMasterDTO = companyMasterMapper.toDto(companyMaster);

        restCompanyMasterMockMvc.perform(post("/api/company-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(companyMasterDTO)))
            .andExpect(status().isBadRequest());

        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    public void getAllCompanyMasters() throws Exception {
        // Initialize the database
        companyMasterRepository.save(companyMaster);

        // Get all the companyMasterList
        restCompanyMasterMockMvc.perform(get("/api/company-masters?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(companyMaster.getId())))
            .andExpect(jsonPath("$.[*].companyMasterSid").value(hasItem(DEFAULT_COMPANY_MASTER_SID)))
            .andExpect(jsonPath("$.[*].companyId").value(hasItem(DEFAULT_COMPANY_ID.toString())))
            .andExpect(jsonPath("$.[*].companyNo").value(hasItem(DEFAULT_COMPANY_NO.toString())))
            .andExpect(jsonPath("$.[*].companyName").value(hasItem(DEFAULT_COMPANY_NAME.toString())))
            .andExpect(jsonPath("$.[*].companyStartDate").value(hasItem(DEFAULT_COMPANY_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].companyEndDate").value(hasItem(DEFAULT_COMPANY_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].lives").value(hasItem(DEFAULT_LIVES)))
            .andExpect(jsonPath("$.[*].financialSystem").value(hasItem(DEFAULT_FINANCIAL_SYSTEM.toString())))
            .andExpect(jsonPath("$.[*].address1").value(hasItem(DEFAULT_ADDRESS_1.toString())))
            .andExpect(jsonPath("$.[*].address2").value(hasItem(DEFAULT_ADDRESS_2.toString())))
            .andExpect(jsonPath("$.[*].city").value(hasItem(DEFAULT_CITY.toString())))
            .andExpect(jsonPath("$.[*].zipCode").value(hasItem(DEFAULT_ZIP_CODE.toString())))
            .andExpect(jsonPath("$.[*].regionCode").value(hasItem(DEFAULT_REGION_CODE.toString())))
            .andExpect(jsonPath("$.[*].lastUpdatedDate").value(hasItem(DEFAULT_LAST_UPDATED_DATE.toString())))
            .andExpect(jsonPath("$.[*].internalNotes").value(hasItem(DEFAULT_INTERNAL_NOTES.toString())))
            .andExpect(jsonPath("$.[*].inboundStatus").value(hasItem(DEFAULT_INBOUND_STATUS.toString())))
            .andExpect(jsonPath("$.[*].recordLockStatus").value(hasItem(DEFAULT_RECORD_LOCK_STATUS.booleanValue())))
            .andExpect(jsonPath("$.[*].batchId").value(hasItem(DEFAULT_BATCH_ID.toString())))
            .andExpect(jsonPath("$.[*].source").value(hasItem(DEFAULT_SOURCE.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY)))
            .andExpect(jsonPath("$.[*].createdDate").value(hasItem(DEFAULT_CREATED_DATE.toString())))
            .andExpect(jsonPath("$.[*].modifiedBy").value(hasItem(DEFAULT_MODIFIED_BY)))
            .andExpect(jsonPath("$.[*].modifiedDate").value(hasItem(DEFAULT_MODIFIED_DATE.toString())));
    }
    
    @Test
    public void getCompanyMaster() throws Exception {
        // Initialize the database
        companyMasterRepository.save(companyMaster);

        // Get the companyMaster
        restCompanyMasterMockMvc.perform(get("/api/company-masters/{id}", companyMaster.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(companyMaster.getId()))
            .andExpect(jsonPath("$.companyMasterSid").value(DEFAULT_COMPANY_MASTER_SID))
            .andExpect(jsonPath("$.companyId").value(DEFAULT_COMPANY_ID.toString()))
            .andExpect(jsonPath("$.companyNo").value(DEFAULT_COMPANY_NO.toString()))
            .andExpect(jsonPath("$.companyName").value(DEFAULT_COMPANY_NAME.toString()))
            .andExpect(jsonPath("$.companyStartDate").value(DEFAULT_COMPANY_START_DATE.toString()))
            .andExpect(jsonPath("$.companyEndDate").value(DEFAULT_COMPANY_END_DATE.toString()))
            .andExpect(jsonPath("$.lives").value(DEFAULT_LIVES))
            .andExpect(jsonPath("$.financialSystem").value(DEFAULT_FINANCIAL_SYSTEM.toString()))
            .andExpect(jsonPath("$.address1").value(DEFAULT_ADDRESS_1.toString()))
            .andExpect(jsonPath("$.address2").value(DEFAULT_ADDRESS_2.toString()))
            .andExpect(jsonPath("$.city").value(DEFAULT_CITY.toString()))
            .andExpect(jsonPath("$.zipCode").value(DEFAULT_ZIP_CODE.toString()))
            .andExpect(jsonPath("$.regionCode").value(DEFAULT_REGION_CODE.toString()))
            .andExpect(jsonPath("$.lastUpdatedDate").value(DEFAULT_LAST_UPDATED_DATE.toString()))
            .andExpect(jsonPath("$.internalNotes").value(DEFAULT_INTERNAL_NOTES.toString()))
            .andExpect(jsonPath("$.inboundStatus").value(DEFAULT_INBOUND_STATUS.toString()))
            .andExpect(jsonPath("$.recordLockStatus").value(DEFAULT_RECORD_LOCK_STATUS.booleanValue()))
            .andExpect(jsonPath("$.batchId").value(DEFAULT_BATCH_ID.toString()))
            .andExpect(jsonPath("$.source").value(DEFAULT_SOURCE.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY))
            .andExpect(jsonPath("$.createdDate").value(DEFAULT_CREATED_DATE.toString()))
            .andExpect(jsonPath("$.modifiedBy").value(DEFAULT_MODIFIED_BY))
            .andExpect(jsonPath("$.modifiedDate").value(DEFAULT_MODIFIED_DATE.toString()));
    }

    @Test
    public void getNonExistingCompanyMaster() throws Exception {
        // Get the companyMaster
        restCompanyMasterMockMvc.perform(get("/api/company-masters/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateCompanyMaster() throws Exception {
        // Initialize the database
        companyMasterRepository.save(companyMaster);

        int databaseSizeBeforeUpdate = companyMasterRepository.findAll().size();

        // Update the companyMaster
        CompanyMaster updatedCompanyMaster = companyMasterRepository.findById(companyMaster.getId()).get();
        updatedCompanyMaster
            .companyMasterSid(UPDATED_COMPANY_MASTER_SID)
            .companyId(UPDATED_COMPANY_ID)
            .companyNo(UPDATED_COMPANY_NO)
            .companyName(UPDATED_COMPANY_NAME)
            .companyStartDate(UPDATED_COMPANY_START_DATE)
            .companyEndDate(UPDATED_COMPANY_END_DATE)
            .lives(UPDATED_LIVES)
            .financialSystem(UPDATED_FINANCIAL_SYSTEM)
            .address1(UPDATED_ADDRESS_1)
            .address2(UPDATED_ADDRESS_2)
            .city(UPDATED_CITY)
            .zipCode(UPDATED_ZIP_CODE)
            .regionCode(UPDATED_REGION_CODE)
            .lastUpdatedDate(UPDATED_LAST_UPDATED_DATE)
            .internalNotes(UPDATED_INTERNAL_NOTES)
            .inboundStatus(UPDATED_INBOUND_STATUS)
            .recordLockStatus(UPDATED_RECORD_LOCK_STATUS)
            .batchId(UPDATED_BATCH_ID)
            .source(UPDATED_SOURCE)
            .createdBy(UPDATED_CREATED_BY)
            .createdDate(UPDATED_CREATED_DATE)
            .modifiedBy(UPDATED_MODIFIED_BY)
            .modifiedDate(UPDATED_MODIFIED_DATE);
        CompanyMasterDTO companyMasterDTO = companyMasterMapper.toDto(updatedCompanyMaster);

        restCompanyMasterMockMvc.perform(put("/api/company-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(companyMasterDTO)))
            .andExpect(status().isOk());

        // Validate the CompanyMaster in the database
        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeUpdate);
        CompanyMaster testCompanyMaster = companyMasterList.get(companyMasterList.size() - 1);
        assertThat(testCompanyMaster.getCompanyMasterSid()).isEqualTo(UPDATED_COMPANY_MASTER_SID);
        assertThat(testCompanyMaster.getCompanyId()).isEqualTo(UPDATED_COMPANY_ID);
        assertThat(testCompanyMaster.getCompanyNo()).isEqualTo(UPDATED_COMPANY_NO);
        assertThat(testCompanyMaster.getCompanyName()).isEqualTo(UPDATED_COMPANY_NAME);
        assertThat(testCompanyMaster.getCompanyStartDate()).isEqualTo(UPDATED_COMPANY_START_DATE);
        assertThat(testCompanyMaster.getCompanyEndDate()).isEqualTo(UPDATED_COMPANY_END_DATE);
        assertThat(testCompanyMaster.getLives()).isEqualTo(UPDATED_LIVES);
        assertThat(testCompanyMaster.getFinancialSystem()).isEqualTo(UPDATED_FINANCIAL_SYSTEM);
        assertThat(testCompanyMaster.getAddress1()).isEqualTo(UPDATED_ADDRESS_1);
        assertThat(testCompanyMaster.getAddress2()).isEqualTo(UPDATED_ADDRESS_2);
        assertThat(testCompanyMaster.getCity()).isEqualTo(UPDATED_CITY);
        assertThat(testCompanyMaster.getZipCode()).isEqualTo(UPDATED_ZIP_CODE);
        assertThat(testCompanyMaster.getRegionCode()).isEqualTo(UPDATED_REGION_CODE);
        assertThat(testCompanyMaster.getLastUpdatedDate()).isEqualTo(UPDATED_LAST_UPDATED_DATE);
        assertThat(testCompanyMaster.getInternalNotes()).isEqualTo(UPDATED_INTERNAL_NOTES);
        assertThat(testCompanyMaster.getInboundStatus()).isEqualTo(UPDATED_INBOUND_STATUS);
        assertThat(testCompanyMaster.isRecordLockStatus()).isEqualTo(UPDATED_RECORD_LOCK_STATUS);
        assertThat(testCompanyMaster.getBatchId()).isEqualTo(UPDATED_BATCH_ID);
        assertThat(testCompanyMaster.getSource()).isEqualTo(UPDATED_SOURCE);
        assertThat(testCompanyMaster.getCreatedBy()).isEqualTo(UPDATED_CREATED_BY);
        assertThat(testCompanyMaster.getCreatedDate()).isEqualTo(UPDATED_CREATED_DATE);
        assertThat(testCompanyMaster.getModifiedBy()).isEqualTo(UPDATED_MODIFIED_BY);
        assertThat(testCompanyMaster.getModifiedDate()).isEqualTo(UPDATED_MODIFIED_DATE);
    }

    @Test
    public void updateNonExistingCompanyMaster() throws Exception {
        int databaseSizeBeforeUpdate = companyMasterRepository.findAll().size();

        // Create the CompanyMaster
        CompanyMasterDTO companyMasterDTO = companyMasterMapper.toDto(companyMaster);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCompanyMasterMockMvc.perform(put("/api/company-masters")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(companyMasterDTO)))
            .andExpect(status().isBadRequest());

        // Validate the CompanyMaster in the database
        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteCompanyMaster() throws Exception {
        // Initialize the database
        companyMasterRepository.save(companyMaster);

        int databaseSizeBeforeDelete = companyMasterRepository.findAll().size();

        // Get the companyMaster
        restCompanyMasterMockMvc.perform(delete("/api/company-masters/{id}", companyMaster.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<CompanyMaster> companyMasterList = companyMasterRepository.findAll();
        assertThat(companyMasterList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(CompanyMaster.class);
        CompanyMaster companyMaster1 = new CompanyMaster();
        companyMaster1.setId("id1");
        CompanyMaster companyMaster2 = new CompanyMaster();
        companyMaster2.setId(companyMaster1.getId());
        assertThat(companyMaster1).isEqualTo(companyMaster2);
        companyMaster2.setId("id2");
        assertThat(companyMaster1).isNotEqualTo(companyMaster2);
        companyMaster1.setId(null);
        assertThat(companyMaster1).isNotEqualTo(companyMaster2);
    }

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(CompanyMasterDTO.class);
        CompanyMasterDTO companyMasterDTO1 = new CompanyMasterDTO();
        companyMasterDTO1.setId("id1");
        CompanyMasterDTO companyMasterDTO2 = new CompanyMasterDTO();
        assertThat(companyMasterDTO1).isNotEqualTo(companyMasterDTO2);
        companyMasterDTO2.setId(companyMasterDTO1.getId());
        assertThat(companyMasterDTO1).isEqualTo(companyMasterDTO2);
        companyMasterDTO2.setId("id2");
        assertThat(companyMasterDTO1).isNotEqualTo(companyMasterDTO2);
        companyMasterDTO1.setId(null);
        assertThat(companyMasterDTO1).isNotEqualTo(companyMasterDTO2);
    }
}
