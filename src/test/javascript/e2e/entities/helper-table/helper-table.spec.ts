/* tslint:disable no-unused-expression */
import { browser, ExpectedConditions as ec, protractor, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { HelperTableComponentsPage, HelperTableDeleteDialog, HelperTableUpdatePage } from './helper-table.page-object';

const expect = chai.expect;

describe('HelperTable e2e test', () => {
    let navBarPage: NavBarPage;
    let signInPage: SignInPage;
    let helperTableUpdatePage: HelperTableUpdatePage;
    let helperTableComponentsPage: HelperTableComponentsPage;
    let helperTableDeleteDialog: HelperTableDeleteDialog;

    before(async () => {
        await browser.get('/');
        navBarPage = new NavBarPage();
        signInPage = await navBarPage.getSignInPage();
        await signInPage.autoSignInUsing('admin', 'admin');
        await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
    });

    it('should load HelperTables', async () => {
        await navBarPage.goToEntity('helper-table');
        helperTableComponentsPage = new HelperTableComponentsPage();
        expect(await helperTableComponentsPage.getTitle()).to.eq('Helper Tables');
    });

    it('should load create HelperTable page', async () => {
        await helperTableComponentsPage.clickOnCreateButton();
        helperTableUpdatePage = new HelperTableUpdatePage();
        expect(await helperTableUpdatePage.getPageTitle()).to.eq('Create or edit a Helper Table');
        await helperTableUpdatePage.cancel();
    });

    it('should create and save HelperTables', async () => {
        const nbButtonsBeforeCreate = await helperTableComponentsPage.countDeleteButtons();

        await helperTableComponentsPage.clickOnCreateButton();
        await promise.all([
            helperTableUpdatePage.setHelperTableSidInput('5'),
            helperTableUpdatePage.setDescriptionInput('description'),
            helperTableUpdatePage.setListNameInput('listName'),
            helperTableUpdatePage.setRefCountInput('5'),
            helperTableUpdatePage.setCreatedByInput('5'),
            helperTableUpdatePage.setCreatedDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
            helperTableUpdatePage.setModifiedByInput('5'),
            helperTableUpdatePage.setModifiedDateInput('01/01/2001' + protractor.Key.TAB + '02:30AM'),
            helperTableUpdatePage.setAliasNameInput('aliasName')
        ]);
        expect(await helperTableUpdatePage.getHelperTableSidInput()).to.eq('5');
        expect(await helperTableUpdatePage.getDescriptionInput()).to.eq('description');
        expect(await helperTableUpdatePage.getListNameInput()).to.eq('listName');
        expect(await helperTableUpdatePage.getRefCountInput()).to.eq('5');
        expect(await helperTableUpdatePage.getCreatedByInput()).to.eq('5');
        expect(await helperTableUpdatePage.getCreatedDateInput()).to.contain('2001-01-01T02:30');
        expect(await helperTableUpdatePage.getModifiedByInput()).to.eq('5');
        expect(await helperTableUpdatePage.getModifiedDateInput()).to.contain('2001-01-01T02:30');
        expect(await helperTableUpdatePage.getAliasNameInput()).to.eq('aliasName');
        await helperTableUpdatePage.save();
        expect(await helperTableUpdatePage.getSaveButton().isPresent()).to.be.false;

        expect(await helperTableComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1);
    });

    it('should delete last HelperTable', async () => {
        const nbButtonsBeforeDelete = await helperTableComponentsPage.countDeleteButtons();
        await helperTableComponentsPage.clickOnLastDeleteButton();

        helperTableDeleteDialog = new HelperTableDeleteDialog();
        expect(await helperTableDeleteDialog.getDialogTitle()).to.eq('Are you sure you want to delete this Helper Table?');
        await helperTableDeleteDialog.clickOnConfirmButton();

        expect(await helperTableComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
    });

    after(async () => {
        await navBarPage.autoSignOut();
    });
});
