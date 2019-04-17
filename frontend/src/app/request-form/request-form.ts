export class RequestForm {
    constructor(
        public id,
        public dateFrom: string,
        public dateTo: string,
        public town: string,
        public specialist: string,
        public specialistFirstName: string,
        public specialistLastName: string
    ) { }
}
