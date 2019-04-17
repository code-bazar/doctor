import { Component, OnInit } from '@angular/core';
import { User } from '../User/User';
import { FormGroup, FormBuilder } from '@angular/forms';
import { RequestFormService } from '../request-form/request-form.service';
import { Router } from '@angular/router';
import { RequestForm } from '../request-form/request-form';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  user: User;
  form: FormGroup;
  requestForm: RequestForm = new RequestForm('', '', '', '', '', '', '');

  constructor(private formBuilder: FormBuilder,
    private requestFormService: RequestFormService,
    private router: Router) { }

  onSubmit() {
    this.requestForm.dateFrom = this.form.value.dateFrom;
    this.requestForm.dateTo = this.form.value.dateTo;
    this.requestForm.town = this.form.value.town;
    this.requestForm.specialist = this.form.value.specialist;
    this.requestForm.specialistFirstName = this.form.value.specialistFirstName;
    this.requestForm.specialistLastName = this.form.value.specialistLastName;

    this.requestFormService.addReservation(this.requestForm)
      .pipe()
      .subscribe(data => {
        console.log("Data");
        console.log(data);
        this.router.navigate(['/home']);
      },
        error => {
          console.error("ERROR: ");
          console.error(error);
        });
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
