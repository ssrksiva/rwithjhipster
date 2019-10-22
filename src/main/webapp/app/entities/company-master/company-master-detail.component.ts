import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICompanyMaster } from 'app/shared/model/company-master.model';

@Component({
    selector: 'jhi-company-master-detail',
    templateUrl: './company-master-detail.component.html'
})
export class CompanyMasterDetailComponent implements OnInit {
    companyMaster: ICompanyMaster;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ companyMaster }) => {
            this.companyMaster = companyMaster;
        });
    }

    previousState() {
        window.history.back();
    }
}
