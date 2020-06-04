import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrendsComponent } from './trends.component';
import { BackendService } from '../backend.service';
import { HttpClientModule } from '@angular/common/http';

describe('TrendsComponent', () => {
  let component: TrendsComponent;
  let fixture: ComponentFixture<TrendsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientModule],
      declarations: [ TrendsComponent ],
      providers:[BackendService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrendsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
