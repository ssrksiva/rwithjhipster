/* tslint:disable max-line-length */
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { of } from 'rxjs';
import { take, map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { HelperTableService } from 'app/entities/helper-table/helper-table.service';
import { IHelperTable, HelperTable } from 'app/shared/model/helper-table.model';

describe('Service Tests', () => {
    describe('HelperTable Service', () => {
        let injector: TestBed;
        let service: HelperTableService;
        let httpMock: HttpTestingController;
        let elemDefault: IHelperTable;
        let currentDate: moment.Moment;
        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HttpClientTestingModule]
            });
            injector = getTestBed();
            service = injector.get(HelperTableService);
            httpMock = injector.get(HttpTestingController);
            currentDate = moment();

            elemDefault = new HelperTable('ID', 0, 'AAAAAAA', 'AAAAAAA', 0, 0, currentDate, 0, currentDate, 'AAAAAAA');
        });

        describe('Service methods', async () => {
            it('should find an element', async () => {
                const returnedFromService = Object.assign(
                    {
                        createdDate: currentDate.format(DATE_TIME_FORMAT),
                        modifiedDate: currentDate.format(DATE_TIME_FORMAT)
                    },
                    elemDefault
                );
                service
                    .find('123')
                    .pipe(take(1))
                    .subscribe(resp => expect(resp).toMatchObject({ body: elemDefault }));

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush(JSON.stringify(returnedFromService));
            });

            it('should create a HelperTable', async () => {
                const returnedFromService = Object.assign(
                    {
                        id: 'ID',
                        createdDate: currentDate.format(DATE_TIME_FORMAT),
                        modifiedDate: currentDate.format(DATE_TIME_FORMAT)
                    },
                    elemDefault
                );
                const expected = Object.assign(
                    {
                        createdDate: currentDate,
                        modifiedDate: currentDate
                    },
                    returnedFromService
                );
                service
                    .create(new HelperTable(null))
                    .pipe(take(1))
                    .subscribe(resp => expect(resp).toMatchObject({ body: expected }));
                const req = httpMock.expectOne({ method: 'POST' });
                req.flush(JSON.stringify(returnedFromService));
            });

            it('should update a HelperTable', async () => {
                const returnedFromService = Object.assign(
                    {
                        helperTableSid: 1,
                        description: 'BBBBBB',
                        listName: 'BBBBBB',
                        refCount: 1,
                        createdBy: 1,
                        createdDate: currentDate.format(DATE_TIME_FORMAT),
                        modifiedBy: 1,
                        modifiedDate: currentDate.format(DATE_TIME_FORMAT),
                        aliasName: 'BBBBBB'
                    },
                    elemDefault
                );

                const expected = Object.assign(
                    {
                        createdDate: currentDate,
                        modifiedDate: currentDate
                    },
                    returnedFromService
                );
                service
                    .update(expected)
                    .pipe(take(1))
                    .subscribe(resp => expect(resp).toMatchObject({ body: expected }));
                const req = httpMock.expectOne({ method: 'PUT' });
                req.flush(JSON.stringify(returnedFromService));
            });

            it('should return a list of HelperTable', async () => {
                const returnedFromService = Object.assign(
                    {
                        helperTableSid: 1,
                        description: 'BBBBBB',
                        listName: 'BBBBBB',
                        refCount: 1,
                        createdBy: 1,
                        createdDate: currentDate.format(DATE_TIME_FORMAT),
                        modifiedBy: 1,
                        modifiedDate: currentDate.format(DATE_TIME_FORMAT),
                        aliasName: 'BBBBBB'
                    },
                    elemDefault
                );
                const expected = Object.assign(
                    {
                        createdDate: currentDate,
                        modifiedDate: currentDate
                    },
                    returnedFromService
                );
                service
                    .query(expected)
                    .pipe(
                        take(1),
                        map(resp => resp.body)
                    )
                    .subscribe(body => expect(body).toContainEqual(expected));
                const req = httpMock.expectOne({ method: 'GET' });
                req.flush(JSON.stringify([returnedFromService]));
                httpMock.verify();
            });

            it('should delete a HelperTable', async () => {
                const rxPromise = service.delete('123').subscribe(resp => expect(resp.ok));

                const req = httpMock.expectOne({ method: 'DELETE' });
                req.flush({ status: 200 });
            });
        });

        afterEach(() => {
            httpMock.verify();
        });
    });
});
