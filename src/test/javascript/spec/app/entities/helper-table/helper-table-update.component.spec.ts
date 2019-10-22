/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { RwithJhipsterTestModule } from '../../../test.module';
import { HelperTableUpdateComponent } from 'app/entities/helper-table/helper-table-update.component';
import { HelperTableService } from 'app/entities/helper-table/helper-table.service';
import { HelperTable } from 'app/shared/model/helper-table.model';

describe('Component Tests', () => {
    describe('HelperTable Management Update Component', () => {
        let comp: HelperTableUpdateComponent;
        let fixture: ComponentFixture<HelperTableUpdateComponent>;
        let service: HelperTableService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [RwithJhipsterTestModule],
                declarations: [HelperTableUpdateComponent]
            })
                .overrideTemplate(HelperTableUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(HelperTableUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(HelperTableService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new HelperTable('123');
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.helperTable = entity;
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
                    const entity = new HelperTable();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.helperTable = entity;
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
