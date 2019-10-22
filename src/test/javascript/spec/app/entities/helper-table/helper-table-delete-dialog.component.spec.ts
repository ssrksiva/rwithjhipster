/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { RwithJhipsterTestModule } from '../../../test.module';
import { HelperTableDeleteDialogComponent } from 'app/entities/helper-table/helper-table-delete-dialog.component';
import { HelperTableService } from 'app/entities/helper-table/helper-table.service';

describe('Component Tests', () => {
    describe('HelperTable Management Delete Component', () => {
        let comp: HelperTableDeleteDialogComponent;
        let fixture: ComponentFixture<HelperTableDeleteDialogComponent>;
        let service: HelperTableService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [RwithJhipsterTestModule],
                declarations: [HelperTableDeleteDialogComponent]
            })
                .overrideTemplate(HelperTableDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(HelperTableDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(HelperTableService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete('123');
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith('123');
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});
