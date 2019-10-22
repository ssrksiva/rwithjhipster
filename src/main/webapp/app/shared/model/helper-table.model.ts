import { Moment } from 'moment';
import { ICompanyMaster } from 'app/shared/model//company-master.model';

export interface IHelperTable {
    id?: string;
    helperTableSid?: number;
    description?: string;
    listName?: string;
    refCount?: number;
    createdBy?: number;
    createdDate?: Moment;
    modifiedBy?: number;
    modifiedDate?: Moment;
    aliasName?: string;
    companyMasters?: ICompanyMaster[];
}

export class HelperTable implements IHelperTable {
    constructor(
        public id?: string,
        public helperTableSid?: number,
        public description?: string,
        public listName?: string,
        public refCount?: number,
        public createdBy?: number,
        public createdDate?: Moment,
        public modifiedBy?: number,
        public modifiedDate?: Moment,
        public aliasName?: string,
        public companyMasters?: ICompanyMaster[]
    ) {}
}
