import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { HelperTable } from 'app/shared/model/helper-table.model';
import { HelperTableService } from './helper-table.service';
import { HelperTableComponent } from './helper-table.component';
import { HelperTableDetailComponent } from './helper-table-detail.component';
import { HelperTableUpdateComponent } from './helper-table-update.component';
import { HelperTableDeletePopupComponent } from './helper-table-delete-dialog.component';
import { IHelperTable } from 'app/shared/model/helper-table.model';

@Injectable({ providedIn: 'root' })
export class HelperTableResolve implements Resolve<IHelperTable> {
    constructor(private service: HelperTableService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((helperTable: HttpResponse<HelperTable>) => helperTable.body));
        }
        return of(new HelperTable());
    }
}

export const helperTableRoute: Routes = [
    {
        path: 'helper-table',
        component: HelperTableComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'HelperTables'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'helper-table/:id/view',
        component: HelperTableDetailComponent,
        resolve: {
            helperTable: HelperTableResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'HelperTables'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'helper-table/new',
        component: HelperTableUpdateComponent,
        resolve: {
            helperTable: HelperTableResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'HelperTables'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'helper-table/:id/edit',
        component: HelperTableUpdateComponent,
        resolve: {
            helperTable: HelperTableResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'HelperTables'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const helperTablePopupRoute: Routes = [
    {
        path: 'helper-table/:id/delete',
        component: HelperTableDeletePopupComponent,
        resolve: {
            helperTable: HelperTableResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'HelperTables'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
