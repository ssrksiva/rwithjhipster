import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICompanyMaster } from 'app/shared/model/company-master.model';
import { CompanyMasterService } from './company-master.service';

@Component({
    selector: 'jhi-company-master-delete-dialog',
    templateUrl: './company-master-delete-dialog.component.html'
})
export class CompanyMasterDeleteDialogComponent {
    companyMaster: ICompanyMaster;

    constructor(
        private companyMasterService: CompanyMasterService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: string) {
        this.companyMasterService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'companyMasterListModification',
                content: 'Deleted an companyMaster'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-company-master-delete-popup',
    template: ''
})
export class CompanyMasterDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ companyMaster }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(CompanyMasterDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.companyMaster = companyMaster;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
