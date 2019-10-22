/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { RwithJhipsterTestModule } from '../../../test.module';
import { CompanyMasterUpdateComponent } from 'app/entities/company-master/company-master-update.component';
import { CompanyMasterService } from 'app/entities/company-master/company-master.service';
import { CompanyMaster } from 'app/shared/model/company-master.model';

describe('Component Tests', () => {
    describe('CompanyMaster Management Update Component', () => {
        let comp: CompanyMasterUpdateComponent;
        let fixture: ComponentFixture<CompanyMasterUpdateComponent>;
        let service: CompanyMasterService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [RwithJhipsterTestModule],
                declarations: [CompanyMasterUpdateComponent]
            })
                .overrideTemplate(CompanyMasterUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(CompanyMasterUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(CompanyMasterService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new CompanyMaster('123');
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.companyMaster = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.update).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );

            it(
                'Should call create service on save for new entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new CompanyMaster();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.companyMaster = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.create).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );
        });
    });
});
