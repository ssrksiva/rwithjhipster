import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { RwithJhipsterSharedModule } from 'app/shared';
import {
    HelperTableComponent,
    HelperTableDetailComponent,
    HelperTableUpdateComponent,
    HelperTableDeletePopupComponent,
    HelperTableDeleteDialogComponent,
    helperTableRoute,
    helperTablePopupRoute
} from './';

const ENTITY_STATES = [...helperTableRoute, ...helperTablePopupRoute];

@NgModule({
    imports: [RwithJhipsterSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        HelperTableComponent,
        HelperTableDetailComponent,
        HelperTableUpdateComponent,
        HelperTableDeleteDialogComponent,
        HelperTableDeletePopupComponent
    ],
    entryComponents: [HelperTableComponent, HelperTableUpdateComponent, HelperTableDeleteDialogComponent, HelperTableDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class RwithJhipsterHelperTableModule {}
