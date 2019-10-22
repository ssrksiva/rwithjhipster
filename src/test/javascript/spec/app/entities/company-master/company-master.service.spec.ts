/* tslint:disable max-line-length */
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { of } from 'rxjs';
import { take, map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { CompanyMasterService } from 'app/entities/company-master/company-master.service';
import { ICompanyMaster, CompanyMaster } from 'app/shared/model/company-master.model';

describe('Service Tests', () => {
    describe('CompanyMaster Service', () => {
        let injector: TestBed;
        let service: CompanyMasterService;
        let httpMock: HttpTestingController;
        let elemDefault: ICompanyMaster;
        let currentDate: moment.Moment;
        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HttpClientTestingModule]
            });
            injector = getTestBed();
            service = injector.get(CompanyMasterService);
            httpMock = injector.get(HttpTestingController);
            currentDate = moment();

            elemDefault = new CompanyMaster(
                'ID',
                0,
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                currentDate,
                currentDate,
                0,
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                currentDate,
                'AAAAAAA',
                'AAAAAAA',
                false,
                'AAAAAAA',
                'AAAAAAA',
                0,
                currentDate,
                0,
                currentDate
            );
        });

        describe('Service methods', async () => {
            it('should find an element', async () => {
                const returnedFromService = Object.assign(
                    {
                        companyStartDate: currentDate.format(DATE_TIME_FORMAT),
                        companyEndDate: currentDate.format(DATE_TIME_FORMAT),
                        lastUpdatedDate: currentDate.format(DATE_TIME_FORMAT),
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

            it('should create a CompanyMaster', async () => {
                const returnedFromService = Object.assign(
                    {
                        id: 'ID',
                        companyStartDate: currentDate.format(DATE_TIME_FORMAT),
                        companyEndDate: currentDate.format(DATE_TIME_FORMAT),
                        lastUpdatedDate: currentDate.format(DATE_TIME_FORMAT),
                        createdDate: currentDate.format(DATE_TIME_FORMAT),
                        modifiedDate: currentDate.format(DATE_TIME_FORMAT)
                    },
                    elemDefault
                );
                const expected = Object.assign(
                    {
                        companyStartDate: currentDate,
                        companyEndDate: currentDate,
                        lastUpdatedDate: currentDate,
                        createdDate: currentDate,
                        modifiedDate: currentDate
                    },
                    returnedFromService
                );
                service
                    .create(new CompanyMaster(null))
                    .pipe(take(1))
                    .subscribe(resp => expect(resp).toMatchObject({ body: expected }));
                const req = httpMock.expectOne({ method: 'POST' });
                req.flush(JSON.stringify(returnedFromService));
            });

            it('should update a CompanyMaster', async () => {
                const returnedFromService = Object.assign(
                    {
                        companyMasterSid: 1,
                        companyId: 'BBBBBB',
                        companyNo: 'BBBBBB',
                        companyName: 'BBBBBB',
                        companyStartDate: currentDate.format(DATE_TIME_FORMAT),
                        companyEndDate: currentDate.format(DATE_TIME_FORMAT),
                        lives: 1,
                        financialSystem: 'BBBBBB',
                        address1: 'BBBBBB',
                        address2: 'BBBBBB',
                        city: 'BBBBBB',
                        zipCode: 'BBBBBB',
                        regionCode: 'BBBBBB',
                        lastUpdatedDate: currentDate.format(DATE_TIME_FORMAT),
                        internalNotes: 'BBBBBB',
                        inboundStatus: 'BBBBBB',
                        recordLockStatus: true,
                        batchId: 'BBBBBB',
                        source: 'BBBBBB',
                        createdBy: 1,
                        createdDate: currentDate.format(DATE_TIME_FORMAT),
                        modifiedBy: 1,
                        modifiedDate: currentDate.format(DATE_TIME_FORMAT)
                    },
                    elemDefault
                );

                const expected = Object.assign(
                    {
                        companyStartDate: currentDate,
                        companyEndDate: currentDate,
                        lastUpdatedDate: currentDate,
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

            it('should return a list of CompanyMaster', async () => {
                const returnedFromService = Object.assign(
                    {
                        companyMasterSid: 1,
                        companyId: 'BBBBBB',
                        companyNo: 'BBBBBB',
                        companyName: 'BBBBBB',
                        companyStartDate: currentDate.format(DATE_TIME_FORMAT),
                        companyEndDate: currentDate.format(DATE_TIME_FORMAT),
                        lives: 1,
                        financialSystem: 'BBBBBB',
                        address1: 'BBBBBB',
                        address2: 'BBBBBB',
                        city: 'BBBBBB',
                        zipCode: 'BBBBBB',
                        regionCode: 'BBBBBB',
                        lastUpdatedDate: currentDate.format(DATE_TIME_FORMAT),
                        internalNotes: 'BBBBBB',
                        inboundStatus: 'BBBBBB',
                        recordLockStatus: true,
                        batchId: 'BBBBBB',
                        source: 'BBBBBB',
                        createdBy: 1,
                        createdDate: currentDate.format(DATE_TIME_FORMAT),
                        modifiedBy: 1,
                        modifiedDate: currentDate.format(DATE_TIME_FORMAT)
                    },
                    elemDefault
                );
                const expected = Object.assign(
                    {
                        companyStartDate: currentDate,
                        companyEndDate: currentDate,
                        lastUpdatedDate: currentDate,
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

            it('should delete a CompanyMaster', async () => {
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
