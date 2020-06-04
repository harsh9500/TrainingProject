import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCandidateComponent } from './update-candidate.component';
import { BackendService } from '../backend.service';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

describe('UpdateCandidateComponent', () => {
  let component: UpdateCandidateComponent;
  let fixture: ComponentFixture<UpdateCandidateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientModule,RouterTestingModule,FormsModule],
      declarations: [ UpdateCandidateComponent ],
      providers:[BackendService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateCandidateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
