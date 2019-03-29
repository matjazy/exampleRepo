import { TestBed } from '@angular/core/testing';
import { HttpTestingController, HttpClientTestingModule } from '@angular/common/http/testing';


import { RegistrationService } from './registration.service';

describe('RegistrationService', () => {
  let httpMock: HttpTestingController;
  let service: RegistrationService;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientTestingModule
      ]
    });
    httpMock = TestBed.get(HttpTestingController);
    service = TestBed.get(RegistrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should assign relevant status in case of success', () => {
    service.registerUser('test', 'test@test.com', 'test');
    httpMock.expectOne('http://localhost:8080/users').flush(null, { status: 200, statusText: 'OK' });
    // tslint:disable-next-line:no-unused-expression
    expect(service.responseStatus === 200).toBeTruthy;
  });
  it('should assign relevant status in case of failure', () => {
    service.registerUser('test', 'test@test.com', 'test');
    httpMock.expectOne('http://localhost:8080/users').flush(null, { status: 400, statusText: 'BAD REQUEST' });
    // tslint:disable-next-line:no-unused-expression
    expect(service.responseStatus === 400).toBeTruthy;
  });


});
