import { Injectable } from '@angular/core';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  user: User = new User('','user','pass','pass');
  users: string[];
  
  constructor() { }
}
