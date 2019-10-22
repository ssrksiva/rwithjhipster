/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { RwithJhipsterTestModule } from '../../../test.module';
import { CompanyMasterDeleteDialogComponent } from 'app/entities/company-master/company-master-delete-dialog.component';
import { CompanyMasterService } from 'app/entities/company-master/company-master.service';

describe('Component Tests', () => {
    describe('CompanyMaster Management Delete Component', () => {
        let comp: CompanyMasterDeleteDialogComponent;
        let fixture: ComponentFixture<CompanyMasterDeleteDialogComponent>;
        let service: CompanyMasterService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [RwithJhipsterTestModule],
                declarations: [CompanyMasterDeleteDialogComponent]
            })
                .overrideTemplate(CompanyMasterDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(CompanyMasterDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(CompanyMasterService);
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
