import { Moment } from 'moment';

export interface ICompanyMaster {
    id?: string;
    companyMasterSid?: number;
    companyId?: string;
    companyNo?: string;
    companyName?: string;
    companyStartDate?: Moment;
    companyEndDate?: Moment;
    lives?: number;
    financialSystem?: string;
    address1?: string;
    address2?: string;
    city?: string;
    zipCode?: string;
    regionCode?: string;
    lastUpdatedDate?: Moment;
    internalNotes?: string;
    inboundStatus?: string;
    recordLockStatus?: boolean;
    batchId?: string;
    source?: string;
    createdBy?: number;
    createdDate?: Moment;
    modifiedBy?: number;
    modifiedDate?: Moment;
    companyTypeId?: string;
    companyStatusId?: string;
    companyCategoryId?: string;
    companyGroupId?: string;
    organizationKeyId?: string;
    stateId?: string;
    countryId?: string;
}

export class CompanyMaster implements ICompanyMaster {
    constructor(
        public id?: string,
        public companyMasterSid?: number,
        public companyId?: string,
        public companyNo?: string,
        public companyName?: string,
        public companyStartDate?: Moment,
        public companyEndDate?: Moment,
        public lives?: number,
        public financialSystem?: string,
        public address1?: string,
        public address2?: string,
        public city?: string,
        public zipCode?: string,
        public regionCode?: string,
        public lastUpdatedDate?: Moment,
        public internalNotes?: string,
        public inboundStatus?: string,
        public recordLockStatus?: boolean,
        public batchId?: string,
        public source?: string,
        public createdBy?: number,
        public createdDate?: Moment,
        public modifiedBy?: number,
        public modifiedDate?: Moment,
        public companyTypeId?: string,
        public companyStatusId?: string,
        public companyCategoryId?: string,
        public companyGroupId?: string,
        public organizationKeyId?: string,
        public stateId?: string,
        public countryId?: string
    ) {
        this.recordLockStatus = this.recordLockStatus || false;
    }
}
