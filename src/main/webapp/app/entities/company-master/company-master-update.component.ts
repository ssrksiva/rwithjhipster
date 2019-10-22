import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';

import { ICompanyMaster } from 'app/shared/model/company-master.model';
import { CompanyMasterService } from './company-master.service';
import { IHelperTable } from 'app/shared/model/helper-table.model';
import { HelperTableService } from 'app/entities/helper-table';

@Component({
    selector: 'jhi-company-master-update',
    templateUrl: './company-master-update.component.html'
})
export class CompanyMasterUpdateComponent implements OnInit {
    companyMaster: ICompanyMaster;
    isSaving: boolean;

    helpertables: IHelperTable[];
    companyStartDate: string;
    companyEndDate: string;
    lastUpdatedDate: string;
    createdDate: string;
    modifiedDate: string;

    constructor(
        private jhiAlertService: JhiAlertService,
        private companyMasterService: CompanyMasterService,
        private helperTableService: HelperTableService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ companyMaster }) => {
            this.companyMaster = companyMaster;
            this.companyStartDate =
                this.companyMaster.companyStartDate != null ? this.companyMaster.companyStartDate.format(DATE_TIME_FORMAT) : null;
            this.companyEndDate =
                this.companyMaster.companyEndDate != null ? this.companyMaster.companyEndDate.format(DATE_TIME_FORMAT) : null;
            this.lastUpdatedDate =
                this.companyMaster.lastUpdatedDate != null ? this.companyMaster.lastUpdatedDate.format(DATE_TIME_FORMAT) : null;
            this.createdDate = this.companyMaster.createdDate != null ? this.companyMaster.createdDate.format(DATE_TIME_FORMAT) : null;
            this.modifiedDate = this.companyMaster.modifiedDate != null ? this.companyMaster.modifiedDate.format(DATE_TIME_FORMAT) : null;
        });
        this.helperTableService.query().subscribe(
            (res: HttpResponse<IHelperTable[]>) => {
                this.helpertables = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.companyMaster.companyStartDate = this.companyStartDate != null ? moment(this.companyStartDate, DATE_TIME_FORMAT) : null;
        this.companyMaster.companyEndDate = this.companyEndDate != null ? moment(this.companyEndDate, DATE_TIME_FORMAT) : null;
        this.companyMaster.lastUpdatedDate = this.lastUpdatedDate != null ? moment(this.lastUpdatedDate, DATE_TIME_FORMAT) : null;
        this.companyMaster.createdDate = this.createdDate != null ? moment(this.createdDate, DATE_TIME_FORMAT) : null;
        this.companyMaster.modifiedDate = this.modifiedDate != null ? moment(this.modifiedDate, DATE_TIME_FORMAT) : null;
        if (this.companyMaster.id !== undefined) {
            this.subscribeToSaveResponse(this.companyMasterService.update(this.companyMaster));
        } else {
            this.subscribeToSaveResponse(this.companyMasterService.create(this.companyMaster));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ICompanyMaster>>) {
        result.subscribe((res: HttpResponse<ICompanyMaster>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackHelperTableById(index: number, item: IHelperTable) {
        return item.id;
    }
}
