import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchCandidateComponent } from './search-candidate.component';
import { BackendService } from '../backend.service';
import { HttpClientModule } from '@angular/common/http';

describe('SearchCandidateComponent', () => {
  let component: SearchCandidateComponent;
  let fixture: ComponentFixture<SearchCandidateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientModule],
      declarations: [ SearchCandidateComponent ],
      providers:[BackendService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchCandidateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
