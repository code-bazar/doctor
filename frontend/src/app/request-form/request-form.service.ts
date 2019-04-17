import { Injectable } from '@angular/core';
import { RequestForm } from './request-form';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RequestFormService {
  apiUrl: string = "http://localhost:8090"

  constructor(private http: HttpClient) { }

  addReservation (requestForm: RequestForm) {
    return this.http.post(this.apiUrl + `/api/addReservation`, requestForm)
  }

}
