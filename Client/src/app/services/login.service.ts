import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public authenticated: boolean;
  public authorized: boolean;
  public username: string;
  public password: string;

  constructor(private httpClient: HttpClient) { }
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

    const headers = new HttpHeaders({
      authorization: 'Basic ' + btoa(username + ':' + password),
      'Content-Type': 'application/json'
    });

    const headers1 = new HttpHeaders({
      'ContentType': 'application/json'
    });

    this.httpClient.get('http://localhost:8080/users', { headers: headers }).subscribe(response => {
      if (response['name']) {
        this.authenticated = true;
        console.log(response);
      } else {
        this.authenticated = false;
        console.log(response);
      }
      return callback && callback();
    });

  }
}
