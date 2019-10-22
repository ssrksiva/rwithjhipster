import { element, by, ElementFinder } from 'protractor';

export class HelperTableComponentsPage {
    createButton = element(by.id('jh-create-entity'));
    deleteButtons = element.all(by.css('jhi-helper-table div table .btn-danger'));
    title = element.all(by.css('jhi-helper-table div h2#page-heading span')).first();

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

export class HelperTableUpdatePage {
    pageTitle = element(by.id('jhi-helper-table-heading'));
    saveButton = element(by.id('save-entity'));
    cancelButton = element(by.id('cancel-save'));
    helperTableSidInput = element(by.id('field_helperTableSid'));
    descriptionInput = element(by.id('field_description'));
    listNameInput = element(by.id('field_listName'));
    refCountInput = element(by.id('field_refCount'));
    createdByInput = element(by.id('field_createdBy'));
    createdDateInput = element(by.id('field_createdDate'));
    modifiedByInput = element(by.id('field_modifiedBy'));
    modifiedDateInput = element(by.id('field_modifiedDate'));
    aliasNameInput = element(by.id('field_aliasName'));

    async getPageTitle() {
        return this.pageTitle.getText();
    }

    async setHelperTableSidInput(helperTableSid) {
        await this.helperTableSidInput.sendKeys(helperTableSid);
    }

    async getHelperTableSidInput() {
        return this.helperTableSidInput.getAttribute('value');
    }

    async setDescriptionInput(description) {
        await this.descriptionInput.sendKeys(description);
    }

    async getDescriptionInput() {
        return this.descriptionInput.getAttribute('value');
    }

    async setListNameInput(listName) {
        await this.listNameInput.sendKeys(listName);
    }

    async getListNameInput() {
        return this.listNameInput.getAttribute('value');
    }

    async setRefCountInput(refCount) {
        await this.refCountInput.sendKeys(refCount);
    }

    async getRefCountInput() {
        return this.refCountInput.getAttribute('value');
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

    async setAliasNameInput(aliasName) {
        await this.aliasNameInput.sendKeys(aliasName);
    }

    async getAliasNameInput() {
        return this.aliasNameInput.getAttribute('value');
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

export class HelperTableDeleteDialog {
    private dialogTitle = element(by.id('jhi-delete-helperTable-heading'));
    private confirmButton = element(by.id('jhi-confirm-delete-helperTable'));

    async getDialogTitle() {
        return this.dialogTitle.getText();
    }

    async clickOnConfirmButton() {
        await this.confirmButton.click();
    }
}
