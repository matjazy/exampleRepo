import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultsFormComponent } from './results-form.component';

describe('ResultsFormComponent', () => {
  let component: ResultsFormComponent;
  let fixture: ComponentFixture<ResultsFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResultsFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResultsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
