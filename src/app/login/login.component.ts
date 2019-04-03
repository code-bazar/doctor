import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user/user.service';
import { User } from '../User/User';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'login-form',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User;
  form: FormGroup;
  
  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router) {
    this.user = userService.user;
  }
  
  submitted = false;
  
  onSubmit() { 
    this.router.navigateByUrl('/home');
  }
  
  ngOnInit(): void {
    this.form = this.formBuilder.group({
      name: [''],
      password: ['']
    });
  }
}
