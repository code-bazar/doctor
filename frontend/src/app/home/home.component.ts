import { Component, OnInit } from '@angular/core';
import { User } from '../User/User';
import { FormGroup, FormBuilder } from '@angular/forms';
import { UserService } from '../user/user.service';
import { Router } from '@angular/router';
import { RequestForm } from '../request-form/request-form';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  user: User;
  requestForm: RequestForm;
  form: FormGroup;
  
  constructor(private formBuilder: FormBuilder, private userService: UserService, private router: Router) {  }
  
  onSubmit() {
    // TODO: 
    console.log(this.form.value["town"])
    this.router.navigate(['/home']);
  }
  
  ngOnInit(): void {
    this.form = this.formBuilder.group({
      dateFrom: [''],
      dateTo: [''],
      town: [''],
      specialist: [''],
      specialistFirstName: [''],
      specialistLastName: ['']
    });
  }

}
