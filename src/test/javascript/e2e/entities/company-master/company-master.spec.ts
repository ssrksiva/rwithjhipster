/* tslint:disable no-unused-expression */
import { browser, ExpectedConditions as ec, protractor, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { CompanyMasterComponentsPage, CompanyMasterDeleteDialog, CompanyMasterUpdatePage } from './company-master.page-object';

const expect = chai.expect;

describe('CompanyMaster e2e test', () => {
    let navBarPage: NavBarPage;
    let signInPage: SignInPage;
    let companyMasterUpdatePage: CompanyMasterUpdatePage;
    let companyMasterComponentsPage: CompanyMasterComponentsPage;
    /*let companyMasterDeleteDialog: CompanyMasterDeleteDialog;*/

    before(async () => {
        await browser.get('/');
        navBarPage = new NavBarPage();
        signInPage = await navBarPage.getSignInPage();
        await signInPage.autoSignInUsing('admin', 'admin');
        await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
    });

    it('should load CompanyMasters', async () => {
        await navBarPage.goToEntity('company-master');
        companyMasterComponentsPage = new CompanyMasterComponentsPage();
        expect(await companyMasterComponentsPage.getTitle()).to.eq('Company Masters');
    });

    it('should load create CompanyMaster page', async () => {
        await companyMasterComponentsPage.clickOnCreateButton();
        companyMasterUpdatePage = new CompanyMasterUpdatePage();
        expect(await companyMasterUpdatePage.getPageTitle()).to.eq('Create or edit a Company Master');
        await companyMasterUpdatePage.cancel();
    });

    /* it('should create and save CompanyMasters', async () => {
        const nbButtonsBeforeCreate = await companyMasterComponentsPage.countDeleteButtons();

        await companyMasterComponentsPage.clickOnCreateButton();
        await promise.all([
            companyMasterUpdatePage.setCompanyMasterSidInput('5'),
            companyMasterUpdatePage.setCompanyIdInput('companyId'),
            companyMasterUpdatePage.setCompanyNoInput('companyNo'),
            companyMasterUpdatePage.setCompanyNameInput('companyName'),
            companyMasterUpdatePage.setCompanyStartDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
            companyMasterUpdatePage.setCompanyEndDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
            companyMasterUpdatePage.setLivesInput('5'),
            companyMasterUpdatePage.setFinancialSystemInput('financialSystem'),
            companyMasterUpdatePage.setAddress1Input('address1'),
            companyMasterUpdatePage.setAddress2Input('address2'),
            companyMasterUpdatePage.setCityInput('city'),
            companyMasterUpdatePage.setZipCodeInput('zipCode'),
            companyMasterUpdatePage.setRegionCodeInput('regionCode'),
            companyMasterUpdatePage.setLastUpdatedDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
            companyMasterUpdatePage.setInternalNotesInput('internalNotes'),
            companyMasterUpdatePage.setInboundStatusInput('inboundStatus'),
            companyMasterUpdatePage.setBatchIdInput('batchId'),
            companyMasterUpdatePage.setSourceInput('source'),
            companyMasterUpdatePage.setCreatedByInput('5'),
            companyMasterUpdatePage.setCreatedDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
            companyMasterUpdatePage.setModifiedByInput('5'),
            companyMasterUpdatePage.setModifiedDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
            companyMasterUpdatePage.companyTypeSelectLastOption(),
            companyMasterUpdatePage.companyStatusSelectLastOption(),
            companyMasterUpdatePage.companyCategorySelectLastOption(),
            companyMasterUpdatePage.companyGroupSelectLastOption(),
            companyMasterUpdatePage.organizationKeySelectLastOption(),
            companyMasterUpdatePage.stateSelectLastOption(),
            companyMasterUpdatePage.countrySelectLastOption(),
        ]);
        expect(await companyMasterUpdatePage.getCompanyMasterSidInput()).to.eq('5');
        expect(await companyMasterUpdatePage.getCompanyIdInput()).to.eq('companyId');
        expect(await companyMasterUpdatePage.getCompanyNoInput()).to.eq('companyNo');
        expect(await companyMasterUpdatePage.getCompanyNameInput()).to.eq('companyName');
        expect(await companyMasterUpdatePage.getCompanyStartDateInput()).to.contain('2001-01-01T02:30');
        expect(await companyMasterUpdatePage.getCompanyEndDateInput()).to.contain('2001-01-01T02:30');
        expect(await companyMasterUpdatePage.getLivesInput()).to.eq('5');
        expect(await companyMasterUpdatePage.getFinancialSystemInput()).to.eq('financialSystem');
        expect(await companyMasterUpdatePage.getAddress1Input()).to.eq('address1');
        expect(await companyMasterUpdatePage.getAddress2Input()).to.eq('address2');
        expect(await companyMasterUpdatePage.getCityInput()).to.eq('city');
        expect(await companyMasterUpdatePage.getZipCodeInput()).to.eq('zipCode');
        expect(await companyMasterUpdatePage.getRegionCodeInput()).to.eq('regionCode');
        expect(await companyMasterUpdatePage.getLastUpdatedDateInput()).to.contain('2001-01-01T02:30');
        expect(await companyMasterUpdatePage.getInternalNotesInput()).to.eq('internalNotes');
        expect(await companyMasterUpdatePage.getInboundStatusInput()).to.eq('inboundStatus');
        const selectedRecordLockStatus = companyMasterUpdatePage.getRecordLockStatusInput();
        if (await selectedRecordLockStatus.isSelected()) {
            await companyMasterUpdatePage.getRecordLockStatusInput().click();
            expect(await companyMasterUpdatePage.getRecordLockStatusInput().isSelected()).to.be.false;
        } else {
            await companyMasterUpdatePage.getRecordLockStatusInput().click();
            expect(await companyMasterUpdatePage.getRecordLockStatusInput().isSelected()).to.be.true;
        }
        expect(await companyMasterUpdatePage.getBatchIdInput()).to.eq('batchId');
        expect(await companyMasterUpdatePage.getSourceInput()).to.eq('source');
        expect(await companyMasterUpdatePage.getCreatedByInput()).to.eq('5');
        expect(await companyMasterUpdatePage.getCreatedDateInput()).to.contain('2001-01-01T02:30');
        expect(await companyMasterUpdatePage.getModifiedByInput()).to.eq('5');
        expect(await companyMasterUpdatePage.getModifiedDateInput()).to.contain('2001-01-01T02:30');
        await companyMasterUpdatePage.save();
        expect(await companyMasterUpdatePage.getSaveButton().isPresent()).to.be.false;

        expect(await companyMasterComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1);
    });*/

    /* it('should delete last CompanyMaster', async () => {
        const nbButtonsBeforeDelete = await companyMasterComponentsPage.countDeleteButtons();
        await companyMasterComponentsPage.clickOnLastDeleteButton();

        companyMasterDeleteDialog = new CompanyMasterDeleteDialog();
        expect(await companyMasterDeleteDialog.getDialogTitle())
            .to.eq('Are you sure you want to delete this Company Master?');
        await companyMasterDeleteDialog.clickOnConfirmButton();

        expect(await companyMasterComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
    });*/

    after(async () => {
        await navBarPage.autoSignOut();
    });
});
