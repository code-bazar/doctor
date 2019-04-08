import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../user/user.service';
import { Observable } from 'rxjs';
import { User } from '../user/User';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  currentUser: User;
  isLoggedIn = false;
  apiUrl: string = "http://localhost:8090";

  constructor(private userService: UserService, private http: HttpClient) { }

  login(username: string, password: string) {
  return this.http.post<any>(this.apiUrl + `/users/authenticate`, { username, password })
    .pipe(map(user => {
        // login successful if there's a jwt token in the response
        if (user && user.token) {
            // store user details and jwt token in local storage to keep user logged in between page refreshes
            localStorage.setItem('currentUser', JSON.stringify(user));
            // this.currentUserSubject.next(user);
        }

        return user;
    }));
    
  }
}
