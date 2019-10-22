import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IHelperTable } from 'app/shared/model/helper-table.model';

type EntityResponseType = HttpResponse<IHelperTable>;
type EntityArrayResponseType = HttpResponse<IHelperTable[]>;

@Injectable({ providedIn: 'root' })
export class HelperTableService {
    public resourceUrl = SERVER_API_URL + 'api/helper-tables';

    constructor(private http: HttpClient) {}

    create(helperTable: IHelperTable): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(helperTable);
        return this.http
            .post<IHelperTable>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(helperTable: IHelperTable): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(helperTable);
        return this.http
            .put<IHelperTable>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: string): Observable<EntityResponseType> {
        return this.http
            .get<IHelperTable>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<IHelperTable[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: string): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    private convertDateFromClient(helperTable: IHelperTable): IHelperTable {
        const copy: IHelperTable = Object.assign({}, helperTable, {
            createdDate: helperTable.createdDate != null && helperTable.createdDate.isValid() ? helperTable.createdDate.toJSON() : null,
            modifiedDate: helperTable.modifiedDate != null && helperTable.modifiedDate.isValid() ? helperTable.modifiedDate.toJSON() : null
        });
        return copy;
    }

    private convertDateFromServer(res: EntityResponseType): EntityResponseType {
        res.body.createdDate = res.body.createdDate != null ? moment(res.body.createdDate) : null;
        res.body.modifiedDate = res.body.modifiedDate != null ? moment(res.body.modifiedDate) : null;
        return res;
    }

    private convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        res.body.forEach((helperTable: IHelperTable) => {
            helperTable.createdDate = helperTable.createdDate != null ? moment(helperTable.createdDate) : null;
            helperTable.modifiedDate = helperTable.modifiedDate != null ? moment(helperTable.modifiedDate) : null;
        });
        return res;
    }
}
