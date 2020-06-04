import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCandidateComponent } from './add-candidate.component';
import { RouterTestingModule } from '@angular/router/testing';
import { BackendService } from '../backend.service';
import { HttpClientModule } from '@angular/common/http';

describe('AddCandidateComponent', () => {
  let component: AddCandidateComponent;
  let fixture: ComponentFixture<AddCandidateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports:[RouterTestingModule, HttpClientModule],
      declarations: [ AddCandidateComponent ],
      providers:[BackendService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCandidateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
