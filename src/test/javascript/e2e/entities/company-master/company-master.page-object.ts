import { element, by, ElementFinder } from 'protractor';

export class CompanyMasterComponentsPage {
    createButton = element(by.id('jh-create-entity'));
    deleteButtons = element.all(by.css('jhi-company-master div table .btn-danger'));
    title = element.all(by.css('jhi-company-master div h2#page-heading span')).first();

    async clickOnCreateButton() {
        await this.createButton.click();
    }

    async clickOnLastDeleteButton() {
        await this.deleteButtons.last().click();
    }

    async countDeleteButtons() {
        return this.deleteButtons.count();
    }

    async getTitle() {
        return this.title.getText();
    }
}

export class CompanyMasterUpdatePage {
    pageTitle = element(by.id('jhi-company-master-heading'));
    saveButton = element(by.id('save-entity'));
    cancelButton = element(by.id('cancel-save'));
    companyMasterSidInput = element(by.id('field_companyMasterSid'));
    companyIdInput = element(by.id('field_companyId'));
    companyNoInput = element(by.id('field_companyNo'));
    companyNameInput = element(by.id('field_companyName'));
    companyStartDateInput = element(by.id('field_companyStartDate'));
    companyEndDateInput = element(by.id('field_companyEndDate'));
    livesInput = element(by.id('field_lives'));
    financialSystemInput = element(by.id('field_financialSystem'));
    address1Input = element(by.id('field_address1'));
    address2Input = element(by.id('field_address2'));
    cityInput = element(by.id('field_city'));
    zipCodeInput = element(by.id('field_zipCode'));
    regionCodeInput = element(by.id('field_regionCode'));
    lastUpdatedDateInput = element(by.id('field_lastUpdatedDate'));
    internalNotesInput = element(by.id('field_internalNotes'));
    inboundStatusInput = element(by.id('field_inboundStatus'));
    recordLockStatusInput = element(by.id('field_recordLockStatus'));
    batchIdInput = element(by.id('field_batchId'));
    sourceInput = element(by.id('field_source'));
    createdByInput = element(by.id('field_createdBy'));
    createdDateInput = element(by.id('field_createdDate'));
    modifiedByInput = element(by.id('field_modifiedBy'));
    modifiedDateInput = element(by.id('field_modifiedDate'));
    companyTypeSelect = element(by.id('field_companyType'));
    companyStatusSelect = element(by.id('field_companyStatus'));
    companyCategorySelect = element(by.id('field_companyCategory'));
    companyGroupSelect = element(by.id('field_companyGroup'));
    organizationKeySelect = element(by.id('field_organizationKey'));
    stateSelect = element(by.id('field_state'));
    countrySelect = element(by.id('field_country'));

    async getPageTitle() {
        return this.pageTitle.getText();
    }

    async setCompanyMasterSidInput(companyMasterSid) {
        await this.companyMasterSidInput.sendKeys(companyMasterSid);
    }

    async getCompanyMasterSidInput() {
        return this.companyMasterSidInput.getAttribute('value');
    }

    async setCompanyIdInput(companyId) {
        await this.companyIdInput.sendKeys(companyId);
    }

    async getCompanyIdInput() {
        return this.companyIdInput.getAttribute('value');
    }

    async setCompanyNoInput(companyNo) {
        await this.companyNoInput.sendKeys(companyNo);
    }

    async getCompanyNoInput() {
        return this.companyNoInput.getAttribute('value');
    }

    async setCompanyNameInput(companyName) {
        await this.companyNameInput.sendKeys(companyName);
    }

    async getCompanyNameInput() {
        return this.companyNameInput.getAttribute('value');
    }

    async setCompanyStartDateInput(companyStartDate) {
        await this.companyStartDateInput.sendKeys(companyStartDate);
    }

    async getCompanyStartDateInput() {
        return this.companyStartDateInput.getAttribute('value');
    }

    async setCompanyEndDateInput(companyEndDate) {
        await this.companyEndDateInput.sendKeys(companyEndDate);
    }

    async getCompanyEndDateInput() {
        return this.companyEndDateInput.getAttribute('value');
    }

    async setLivesInput(lives) {
        await this.livesInput.sendKeys(lives);
    }

    async getLivesInput() {
        return this.livesInput.getAttribute('value');
    }

    async setFinancialSystemInput(financialSystem) {
        await this.financialSystemInput.sendKeys(financialSystem);
    }

    async getFinancialSystemInput() {
        return this.financialSystemInput.getAttribute('value');
    }

    async setAddress1Input(address1) {
        await this.address1Input.sendKeys(address1);
    }

    async getAddress1Input() {
        return this.address1Input.getAttribute('value');
    }

    async setAddress2Input(address2) {
        await this.address2Input.sendKeys(address2);
    }

    async getAddress2Input() {
        return this.address2Input.getAttribute('value');
    }

    async setCityInput(city) {
        await this.cityInput.sendKeys(city);
    }

    async getCityInput() {
        return this.cityInput.getAttribute('value');
    }

    async setZipCodeInput(zipCode) {
        await this.zipCodeInput.sendKeys(zipCode);
    }

    async getZipCodeInput() {
        return this.zipCodeInput.getAttribute('value');
    }

    async setRegionCodeInput(regionCode) {
        await this.regionCodeInput.sendKeys(regionCode);
    }

    async getRegionCodeInput() {
        return this.regionCodeInput.getAttribute('value');
    }

    async setLastUpdatedDateInput(lastUpdatedDate) {
        await this.lastUpdatedDateInput.sendKeys(lastUpdatedDate);
    }

    async getLastUpdatedDateInput() {
        return this.lastUpdatedDateInput.getAttribute('value');
    }

    async setInternalNotesInput(internalNotes) {
        await this.internalNotesInput.sendKeys(internalNotes);
    }

    async getInternalNotesInput() {
        return this.internalNotesInput.getAttribute('value');
    }

    async setInboundStatusInput(inboundStatus) {
        await this.inboundStatusInput.sendKeys(inboundStatus);
    }

    async getInboundStatusInput() {
        return this.inboundStatusInput.getAttribute('value');
    }

    getRecordLockStatusInput() {
        return this.recordLockStatusInput;
    }
    async setBatchIdInput(batchId) {
        await this.batchIdInput.sendKeys(batchId);
    }

    async getBatchIdInput() {
        return this.batchIdInput.getAttribute('value');
    }

    async setSourceInput(source) {
        await this.sourceInput.sendKeys(source);
    }

    async getSourceInput() {
        return this.sourceInput.getAttribute('value');
    }

    async setCreatedByInput(createdBy) {
        await this.createdByInput.sendKeys(createdBy);
    }

    async getCreatedByInput() {
        return this.createdByInput.getAttribute('value');
    }

    async setCreatedDateInput(createdDate) {
        await this.createdDateInput.sendKeys(createdDate);
    }

    async getCreatedDateInput() {
        return this.createdDateInput.getAttribute('value');
    }

    async setModifiedByInput(modifiedBy) {
        await this.modifiedByInput.sendKeys(modifiedBy);
    }

    async getModifiedByInput() {
        return this.modifiedByInput.getAttribute('value');
    }

    async setModifiedDateInput(modifiedDate) {
        await this.modifiedDateInput.sendKeys(modifiedDate);
    }

    async getModifiedDateInput() {
        return this.modifiedDateInput.getAttribute('value');
    }

    async companyTypeSelectLastOption() {
        await this.companyTypeSelect
            .all(by.tagName('option'))
            .last()
            .click();
    }

    async companyTypeSelectOption(option) {
        await this.companyTypeSelect.sendKeys(option);
    }

    getCompanyTypeSelect(): ElementFinder {
        return this.companyTypeSelect;
    }

    async getCompanyTypeSelectedOption() {
        return this.companyTypeSelect.element(by.css('option:checked')).getText();
    }

    async companyStatusSelectLastOption() {
        await this.companyStatusSelect
            .all(by.tagName('option'))
            .last()
            .click();
    }

    async companyStatusSelectOption(option) {
        await this.companyStatusSelect.sendKeys(option);
    }

    getCompanyStatusSelect(): ElementFinder {
        return this.companyStatusSelect;
    }

    async getCompanyStatusSelectedOption() {
        return this.companyStatusSelect.element(by.css('option:checked')).getText();
    }

    async companyCategorySelectLastOption() {
        await this.companyCategorySelect
            .all(by.tagName('option'))
            .last()
            .click();
    }

    async companyCategorySelectOption(option) {
        await this.companyCategorySelect.sendKeys(option);
    }

    getCompanyCategorySelect(): ElementFinder {
        return this.companyCategorySelect;
    }

    async getCompanyCategorySelectedOption() {
        return this.companyCategorySelect.element(by.css('option:checked')).getText();
    }

    async companyGroupSelectLastOption() {
        await this.companyGroupSelect
            .all(by.tagName('option'))
            .last()
            .click();
    }

    async companyGroupSelectOption(option) {
        await this.companyGroupSelect.sendKeys(option);
    }

    getCompanyGroupSelect(): ElementFinder {
        return this.companyGroupSelect;
    }

    async getCompanyGroupSelectedOption() {
        return this.companyGroupSelect.element(by.css('option:checked')).getText();
    }

    async organizationKeySelectLastOption() {
        await this.organizationKeySelect
            .all(by.tagName('option'))
            .last()
            .click();
    }

    async organizationKeySelectOption(option) {
        await this.organizationKeySelect.sendKeys(option);
    }

    getOrganizationKeySelect(): ElementFinder {
        return this.organizationKeySelect;
    }

    async getOrganizationKeySelectedOption() {
        return this.organizationKeySelect.element(by.css('option:checked')).getText();
    }

    async stateSelectLastOption() {
        await this.stateSelect
            .all(by.tagName('option'))
            .last()
            .click();
    }

    async stateSelectOption(option) {
        await this.stateSelect.sendKeys(option);
    }

    getStateSelect(): ElementFinder {
        return this.stateSelect;
    }

    async getStateSelectedOption() {
        return this.stateSelect.element(by.css('option:checked')).getText();
    }

    async countrySelectLastOption() {
        await this.countrySelect
            .all(by.tagName('option'))
            .last()
            .click();
    }

    async countrySelectOption(option) {
        await this.countrySelect.sendKeys(option);
    }

    getCountrySelect(): ElementFinder {
        return this.countrySelect;
    }

    async getCountrySelectedOption() {
        return this.countrySelect.element(by.css('option:checked')).getText();
    }

    async save() {
        await this.saveButton.click();
    }

    async cancel() {
        await this.cancelButton.click();
    }

    getSaveButton(): ElementFinder {
        return this.saveButton;
    }
}

export class CompanyMasterDeleteDialog {
    private dialogTitle = element(by.id('jhi-delete-companyMaster-heading'));
    private confirmButton = element(by.id('jhi-confirm-delete-companyMaster'));

    async getDialogTitle() {
        return this.dialogTitle.getText();
    }

    async clickOnConfirmButton() {
        await this.confirmButton.click();
    }
}
