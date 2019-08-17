import { TestBed } from '@angular/core/testing';
import { HttpTestingController, HttpClientTestingModule } from '@angular/common/http/testing';

import { LoginService } from './login.service';
import { equal } from 'assert';

describe('LoginService', () => {
  let httpMock: HttpTestingController;
  let service: LoginService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientTestingModule
      ]
    });
    httpMock = TestBed.get(HttpTestingController);
    service = TestBed.get(LoginService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should assign relevant status in case of success', () => {
    service.login('test', 'test');
    httpMock.expectOne('http://localhost:8080/session').flush(null, { status: 200, statusText: 'OK' });
    expect(service.authorized === true).toBeTruthy();

  });

  it('should assign false in case of error', () => {
    service.login('test', 'test');
    httpMock.expectOne('http://localhost:8080/session').flush(null, { status: 400, statusText: 'BAD REQUEST' });
    expect(service.authorized === false).toBeTruthy();
  });

});
