/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { RwithJhipsterTestModule } from '../../../test.module';
import { HelperTableDetailComponent } from 'app/entities/helper-table/helper-table-detail.component';
import { HelperTable } from 'app/shared/model/helper-table.model';

describe('Component Tests', () => {
    describe('HelperTable Management Detail Component', () => {
        let comp: HelperTableDetailComponent;
        let fixture: ComponentFixture<HelperTableDetailComponent>;
        const route = ({ data: of({ helperTable: new HelperTable('123') }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [RwithJhipsterTestModule],
                declarations: [HelperTableDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(HelperTableDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(HelperTableDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.helperTable).toEqual(jasmine.objectContaining({ id: '123' }));
            });
        });
    });
});
