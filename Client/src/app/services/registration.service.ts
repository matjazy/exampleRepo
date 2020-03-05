import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';


/**
 * Service allowing registration of user.
 * @author MJazy
 */
@Injectable({
  providedIn: 'root'
})
export class RegistrationService {
  public responseStatus: number;
  private httpErrorResponse: HttpErrorResponse;
  public registerUser(username: string, email: string, password: string, repassword: string) {
    if (!username) {
      alert('username should be filled');
    }
    if (!email) {
      alert('email should be filled');
    }
    if (password !== repassword) {
      alert('password and repassword must match');
    }
    else {
      this.httpClient.post('http://localhost:8080/users',
        {
          // tslint:disable-next-line:quotemark
          "username": username,
          // tslint:disable-next-line:quotemark
          "email": email,
          // tslint:disable-next-line:quotemark
          "password": password
        }, { responseType: 'text', observe: 'response' })
        .subscribe(response => {
          this.responseStatus = response.status;
        }, error => {
          this.httpErrorResponse = error;
          this.responseStatus = this.httpErrorResponse.status;
        });
    }
  }

  constructor(private httpClient: HttpClient) { }
}
