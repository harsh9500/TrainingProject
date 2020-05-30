import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { SocialLoginModule, AuthServiceConfig, GoogleLoginProvider } from 'angularx-social-login';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { SearchCandidateComponent } from './search-candidate/search-candidate.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AddCandidateComponent } from './add-candidate/add-candidate.component';
import { TrendsComponent } from './trends/trends.component';
import { ViewCandidateComponent } from './view-candidate/view-candidate.component';



const config = new AuthServiceConfig([
  {
    id: GoogleLoginProvider.PROVIDER_ID,
    provider: new GoogleLoginProvider("180737474485-hhdcjis4ic40ci379ov7v8odtngmcmt6.apps.googleusercontent.com")
  }
]);


export function provideConfig() {
  return config;
}

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    SidebarComponent,
    SearchCandidateComponent,
    NavbarComponent,
    AddCandidateComponent,
    TrendsComponent,
    ViewCandidateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    SocialLoginModule,
  ],
  providers: [{
    provide: AuthServiceConfig,
    useFactory: provideConfig
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
