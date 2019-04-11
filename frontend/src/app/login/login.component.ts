import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { UserService } from '../user/user.service';
import { User } from '../User/User';
import { AuthenticationService } from '../authentication/authentication.service';

@Component({
  selector: 'login-form',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  currentUser: User;
  form: FormGroup;
  isWrongCredentials = true;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private authenticationService: AuthenticationService) { }

  onSubmit() {
    // console.log(this.authenticationService.login(this.form.value.name, this.form.value.password));
    this.authenticationService.login(this.form.value.name, this.form.value.password)
      .pipe(first())
      .subscribe(
        data => {
          this.isWrongCredentials = true;
          this.router.navigate(['/home']);
        },
        error => {
          this.isWrongCredentials = false;
          console.log("Wrong user or password");
        });
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      name: [''],
      password: ['']
    });
  }
}
