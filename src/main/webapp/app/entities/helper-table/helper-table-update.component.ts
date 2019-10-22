import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IHelperTable } from 'app/shared/model/helper-table.model';
import { HelperTableService } from './helper-table.service';

@Component({
    selector: 'jhi-helper-table-update',
    templateUrl: './helper-table-update.component.html'
})
export class HelperTableUpdateComponent implements OnInit {
    helperTable: IHelperTable;
    isSaving: boolean;
    createdDate: string;
    modifiedDate: string;

    constructor(private helperTableService: HelperTableService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ helperTable }) => {
            this.helperTable = helperTable;
            this.createdDate = this.helperTable.createdDate != null ? this.helperTable.createdDate.format(DATE_TIME_FORMAT) : null;
            this.modifiedDate = this.helperTable.modifiedDate != null ? this.helperTable.modifiedDate.format(DATE_TIME_FORMAT) : null;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.helperTable.createdDate = this.createdDate != null ? moment(this.createdDate, DATE_TIME_FORMAT) : null;
        this.helperTable.modifiedDate = this.modifiedDate != null ? moment(this.modifiedDate, DATE_TIME_FORMAT) : null;
        if (this.helperTable.id !== undefined) {
            this.subscribeToSaveResponse(this.helperTableService.update(this.helperTable));
        } else {
            this.subscribeToSaveResponse(this.helperTableService.create(this.helperTable));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IHelperTable>>) {
        result.subscribe((res: HttpResponse<IHelperTable>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
}
