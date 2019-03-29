import { Component, OnInit } from '@angular/core';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-registration-div',
  templateUrl: './registration-div.component.html',
  styleUrls: ['./registration-div.component.css']
})
export class RegistrationDivComponent implements OnInit {

  private username: string;
  private password: string;
  private email: string;

  constructor(private registrationService: RegistrationService) { }

  ngOnInit() {
  }

}
