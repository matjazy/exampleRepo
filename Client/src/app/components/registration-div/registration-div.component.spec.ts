import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrationDivComponent } from './registration-div.component';

describe('RegistrationDivComponent', () => {
  let component: RegistrationDivComponent;
  let fixture: ComponentFixture<RegistrationDivComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegistrationDivComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistrationDivComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
