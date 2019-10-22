/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { RwithJhipsterTestModule } from '../../../test.module';
import { CompanyMasterDetailComponent } from 'app/entities/company-master/company-master-detail.component';
import { CompanyMaster } from 'app/shared/model/company-master.model';

describe('Component Tests', () => {
    describe('CompanyMaster Management Detail Component', () => {
        let comp: CompanyMasterDetailComponent;
        let fixture: ComponentFixture<CompanyMasterDetailComponent>;
        const route = ({ data: of({ companyMaster: new CompanyMaster('123') }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [RwithJhipsterTestModule],
                declarations: [CompanyMasterDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(CompanyMasterDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(CompanyMasterDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.companyMaster).toEqual(jasmine.objectContaining({ id: '123' }));
            });
        });
    });
});
