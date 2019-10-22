import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IHelperTable } from 'app/shared/model/helper-table.model';
import { HelperTableService } from './helper-table.service';

@Component({
    selector: 'jhi-helper-table-delete-dialog',
    templateUrl: './helper-table-delete-dialog.component.html'
})
export class HelperTableDeleteDialogComponent {
    helperTable: IHelperTable;

    constructor(
        private helperTableService: HelperTableService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: string) {
        this.helperTableService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'helperTableListModification',
                content: 'Deleted an helperTable'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-helper-table-delete-popup',
    template: ''
})
export class HelperTableDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ helperTable }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(HelperTableDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.helperTable = helperTable;
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
