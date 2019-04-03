import { Component } from '@angular/core';
import {User} from "./user/User";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  user = new User('', '','','');
  isLoggedIn = false;
  constructor() {

  }

  onSubmit(name: string) {
    console.log("Submit...");

    // this.userService.getSingleUser(this.user.name)
    //   .subscribe( data => {
    //     if (data['name'] === this.user.name) {
    //       this.isLoggedIn = true;
    //     } else {
    //       this.isLoggedIn = false;
    //     }
    //   });
  }

  click() {
    console.log("app component msg changed");
  }



}
