export class RequestForm {
    constructor(
        public id,
        dateFrom: string,
        dateTo: string,
        town: string,
        specialist: string,
        specialistFirstName: string,
        specialistLastName: string
    ) { }
}
