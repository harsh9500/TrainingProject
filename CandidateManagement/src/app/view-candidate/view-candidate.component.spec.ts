import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCandidateComponent } from './view-candidate.component';
import { BackendService } from '../backend.service';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';

describe('ViewCandidateComponent', () => {
  let component: ViewCandidateComponent;
  let fixture: ComponentFixture<ViewCandidateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientModule,RouterTestingModule],
      declarations: [ ViewCandidateComponent ],
      providers:[BackendService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCandidateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
