import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { CompanyMaster } from 'app/shared/model/company-master.model';
import { CompanyMasterService } from './company-master.service';
import { CompanyMasterComponent } from './company-master.component';
import { CompanyMasterDetailComponent } from './company-master-detail.component';
import { CompanyMasterUpdateComponent } from './company-master-update.component';
import { CompanyMasterDeletePopupComponent } from './company-master-delete-dialog.component';
import { ICompanyMaster } from 'app/shared/model/company-master.model';

@Injectable({ providedIn: 'root' })
export class CompanyMasterResolve implements Resolve<ICompanyMaster> {
    constructor(private service: CompanyMasterService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((companyMaster: HttpResponse<CompanyMaster>) => companyMaster.body));
        }
        return of(new CompanyMaster());
    }
}

export const companyMasterRoute: Routes = [
    {
        path: 'company-master',
        component: CompanyMasterComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'CompanyMasters'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'company-master/:id/view',
        component: CompanyMasterDetailComponent,
        resolve: {
            companyMaster: CompanyMasterResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'CompanyMasters'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'company-master/new',
        component: CompanyMasterUpdateComponent,
        resolve: {
            companyMaster: CompanyMasterResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'CompanyMasters'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'company-master/:id/edit',
        component: CompanyMasterUpdateComponent,
        resolve: {
            companyMaster: CompanyMasterResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'CompanyMasters'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const companyMasterPopupRoute: Routes = [
    {
        path: 'company-master/:id/delete',
        component: CompanyMasterDeletePopupComponent,
        resolve: {
            companyMaster: CompanyMasterResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'CompanyMasters'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
