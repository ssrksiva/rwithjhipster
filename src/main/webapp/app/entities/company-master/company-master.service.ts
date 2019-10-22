import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ICompanyMaster } from 'app/shared/model/company-master.model';

type EntityResponseType = HttpResponse<ICompanyMaster>;
type EntityArrayResponseType = HttpResponse<ICompanyMaster[]>;

@Injectable({ providedIn: 'root' })
export class CompanyMasterService {
    public resourceUrl = SERVER_API_URL + 'api/company-masters';

    constructor(private http: HttpClient) {}

    create(companyMaster: ICompanyMaster): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(companyMaster);
        return this.http
            .post<ICompanyMaster>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(companyMaster: ICompanyMaster): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(companyMaster);
        return this.http
            .put<ICompanyMaster>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: string): Observable<EntityResponseType> {
        return this.http
            .get<ICompanyMaster>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<ICompanyMaster[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: string): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(companyMaster: ICompanyMaster): ICompanyMaster {
        const copy: ICompanyMaster = Object.assign({}, companyMaster, {
            companyStartDate:
                companyMaster.companyStartDate != null && companyMaster.companyStartDate.isValid()
                    ? companyMaster.companyStartDate.toJSON()
                    : null,
            companyEndDate:
                companyMaster.companyEndDate != null && companyMaster.companyEndDate.isValid()
                    ? companyMaster.companyEndDate.toJSON()
                    : null,
            lastUpdatedDate:
                companyMaster.lastUpdatedDate != null && companyMaster.lastUpdatedDate.isValid()
                    ? companyMaster.lastUpdatedDate.toJSON()
                    : null,
            createdDate:
                companyMaster.createdDate != null && companyMaster.createdDate.isValid() ? companyMaster.createdDate.toJSON() : null,
            modifiedDate:
                companyMaster.modifiedDate != null && companyMaster.modifiedDate.isValid() ? companyMaster.modifiedDate.toJSON() : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.companyStartDate = res.body.companyStartDate != null ? moment(res.body.companyStartDate) : null;
        res.body.companyEndDate = res.body.companyEndDate != null ? moment(res.body.companyEndDate) : null;
        res.body.lastUpdatedDate = res.body.lastUpdatedDate != null ? moment(res.body.lastUpdatedDate) : null;
        res.body.createdDate = res.body.createdDate != null ? moment(res.body.createdDate) : null;
        res.body.modifiedDate = res.body.modifiedDate != null ? moment(res.body.modifiedDate) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((companyMaster: ICompanyMaster) => {
            companyMaster.companyStartDate = companyMaster.companyStartDate != null ? moment(companyMaster.companyStartDate) : null;
            companyMaster.companyEndDate = companyMaster.companyEndDate != null ? moment(companyMaster.companyEndDate) : null;
            companyMaster.lastUpdatedDate = companyMaster.lastUpdatedDate != null ? moment(companyMaster.lastUpdatedDate) : null;
            companyMaster.createdDate = companyMaster.createdDate != null ? moment(companyMaster.createdDate) : null;
            companyMaster.modifiedDate = companyMaster.modifiedDate != null ? moment(companyMaster.modifiedDate) : null;
        });
        return res;
    }
}
