import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { RwithJhipsterCompanyMasterModule } from './company-master/company-master.module';
import { RwithJhipsterHelperTableModule } from './helper-table/helper-table.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        RwithJhipsterCompanyMasterModule,
        RwithJhipsterHelperTableModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class RwithJhipsterEntityModule {}
