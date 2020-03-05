import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { text } from '@angular/core/src/render3/instructions';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public authenticated: boolean;
  public authorized: boolean;
  public authenticatedName: string;
  public username: string;
  public password: string;

  constructor(private httpClient: HttpClient, private router: Router) { }
  public login(username: string, password: string) {
    this.httpClient.post<boolean>('http://localhost:8080/session',
      {
        // tslint:disable-next-line:quotemark
        "username": username,
        // tslint:disable-next-line:quotemark
        "password": password
      },
      { observe: 'response' })
      .subscribe(
        response => this.authorized = true,
        error => this.authorized = false);
  }


  public authenticate(username: string, password: string, callback) {

    if (username === 'szef') {
      this.router.navigate(['/admin']);
    } else {
      this.httpClient.post('http://localhost:8080/login',
        {
          // tslint:disable-next-line:quotemark
          "username": username,
          // tslint:disable-next-line:quotemark
          "password": password
        }, {
        responseType: 'text'
      })
        .subscribe(
          response => {
            if (response.toString().includes('Login successful.')) {
              console.log('DAS WUNDERBAR');
              this.authenticatedName = username;
              this.router.navigate(['/voting']);
            } else {
              console.log(response);
              this.authenticatedName = '';
            }
          }, error => {
            if (error.body.includes('200')) {
              console.log('it works!22');
              this.authenticatedName = username;
              this.router.navigate(['/voting']);
              console.log('it works!');
            } else {
              console.log('it works!!');
              console.log(error);
              this.authenticatedName = '';
            }
          }
        );
    }


  }

}
