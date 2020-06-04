import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SidebarComponent } from './sidebar.component';
import { AuthServiceConfig, GoogleLoginProvider, AuthService } from 'angularx-social-login';
import { RouterTestingModule } from '@angular/router/testing';

const config = new AuthServiceConfig([
  {
    id: GoogleLoginProvider.PROVIDER_ID,
    provider: new GoogleLoginProvider("180737474485-hhdcjis4ic40ci379ov7v8odtngmcmt6.apps.googleusercontent.com")
  }
]);


export function provideConfig() {
  return config;
}

describe('SidebarComponent', () => {
  let component: SidebarComponent;
  let fixture: ComponentFixture<SidebarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports:[RouterTestingModule],
      declarations: [ SidebarComponent ],
      providers: [{
        provide: AuthServiceConfig,
        useFactory: provideConfig
      },
      AuthService
    ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SidebarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
