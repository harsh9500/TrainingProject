import { Component, OnInit, Output } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService, GoogleLoginProvider, SocialUser } from 'angularx-social-login';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  
  constructor(private authService: AuthService, private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
    
  }

  signInWithGoogle() {
    console.log("Hitting Google API");
    this.authService.signIn(GoogleLoginProvider.PROVIDER_ID)
    .then(
      (response)=>{
        this.http.get("https://oauth2.googleapis.com/tokeninfo?id_token=" + response.idToken)
        .subscribe((oAuthResponse)=>{
          if(oAuthResponse['hd'] && oAuthResponse['hd']==="accoliteindia.com")
          {
            console.log("Successful Sign In");
            localStorage.setItem('token', response.idToken); 
            this.router.navigateByUrl('/dashboard');
          }
          else
          {
            console.log("Not an Accolite email");
            alert("Please select an Accolite India email ID");
          }
        });
        
      },
      (reason:any)=>alert(reason)
    );
    
  }

  

}
