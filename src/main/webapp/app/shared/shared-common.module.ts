import { NgModule } from '@angular/core';

import { RwithJhipsterSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [RwithJhipsterSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [RwithJhipsterSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class RwithJhipsterSharedCommonModule {}
