import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { RwithJhipsterSharedModule } from 'app/shared';
import {
    CompanyMasterComponent,
    CompanyMasterDetailComponent,
    CompanyMasterUpdateComponent,
    CompanyMasterDeletePopupComponent,
    CompanyMasterDeleteDialogComponent,
    companyMasterRoute,
    companyMasterPopupRoute
} from './';

const ENTITY_STATES = [...companyMasterRoute, ...companyMasterPopupRoute];

@NgModule({
    imports: [RwithJhipsterSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        CompanyMasterComponent,
        CompanyMasterDetailComponent,
        CompanyMasterUpdateComponent,
        CompanyMasterDeleteDialogComponent,
        CompanyMasterDeletePopupComponent
    ],
    entryComponents: [
        CompanyMasterComponent,
        CompanyMasterUpdateComponent,
        CompanyMasterDeleteDialogComponent,
        CompanyMasterDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class RwithJhipsterCompanyMasterModule {}
