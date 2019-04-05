import { Injectable } from '@angular/core';
import { User } from './User';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  //user: User = new User('', '', 'barti@bw.com', '123');
  users: string[];
  apiUrl: string = "http://localhost:8090"

  constructor(private http: HttpClient) { }

  getAll() {
    return this.http.get<User[]>(this.apiUrl + `/api/all`);
  }

  getByName(name: string) {
    return this.http.get<User>(this.apiUrl + `/api/get?name=` + name);
  }

  register(user: User) {
    return this.http.post(this.apiUrl + `/api/addJSON`, user);
  }

  update(user: User) {
    return this.http.post(this.apiUrl + `/api/update`, user);
  }

  delete(user: User) {
    return this.http.post(this.apiUrl + `/api/delete`, user);
  }

}
