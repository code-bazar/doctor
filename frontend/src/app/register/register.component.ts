import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from '../user/user.service';
import { User } from '../User/User';
import { first } from 'rxjs/operators';

@Component({
  selector: 'register-form',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: User = new User('', '', '', '');;
  form: FormGroup;
  isRegistered: boolean;

  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router) {
    this.isRegistered = false;
  }

  onSubmit() {
    this.user.email = this.form.value.email;
    this.user.name = this.form.value.name;
    this.user.password = this.form.value.password;
    
    
    this.userService.register(this.form.value)
      .pipe(first())
      .subscribe(
        data => {
          console.log(data);
          this.isRegistered = true
          setInterval( () => {}, 2000);
          this.router.navigate(['/login']);
        },
        error => {
          console.log(error);
          if (error.status == 200) {
            this.router.navigate(['/login']);
          }
          
        }
      );
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      email: [''],
      name: [''],
      password: ['']
    });
  }
}
