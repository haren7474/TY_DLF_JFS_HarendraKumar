import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  todaysDate = Date.now();
  constructor() { }

  submitForm(form: NgForm) {
    console.log(form.value);
    form.reset();
  }
  ngOnInit() {
  }

}
