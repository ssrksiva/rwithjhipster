import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IHelperTable } from 'app/shared/model/helper-table.model';

@Component({
    selector: 'jhi-helper-table-detail',
    templateUrl: './helper-table-detail.component.html'
})
export class HelperTableDetailComponent implements OnInit {
    helperTable: IHelperTable;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ helperTable }) => {
            this.helperTable = helperTable;
        });
    }

    previousState() {
        window.history.back();
    }
}
