import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { GridsterModule } from 'angular-gridster2';
import { RwithJhipsterSharedModule } from 'app/shared';
import { HOME_ROUTE, HomeComponent } from './';
import { SafePipe } from './home.component';



@NgModule({
    imports: [RwithJhipsterSharedModule, GridsterModule,RouterModule.forChild([HOME_ROUTE])],
    declarations: [HomeComponent,SafePipe],
    schemas: [CUSTOM_ELEMENTS_SCHEMA],
	exports: [SafePipe]
})
export class RwithJhipsterHomeModule {}
