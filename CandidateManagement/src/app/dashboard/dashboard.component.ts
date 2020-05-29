import { Component, OnInit, Input } from '@angular/core';
import { AuthService, SocialUser } from 'angularx-social-login';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  user:SocialUser;
  opened: boolean;

  constructor(private authService:AuthService, private router:Router, private http:HttpClient) { }

  ngOnInit(): void {
    
    this.authService.authState.subscribe((user) => {
      this.user = user;
    });
    let token = localStorage.getItem('token');
    if(!token)
    {
      alert("Please sign in!");
      this.router.navigateByUrl('/login');
    }
  }

  signOut(){
    this.authService.signOut().then(
      ()=>{
        console.log("Successful Sign out");
        localStorage.removeItem('token'); 
        this.router.navigateByUrl('/login');
    },
      (reason:any)=>alert(reason)
    );
  }

  openNav() {
    console.log(document.getElementById("mySidenav").style.zIndex);
    document.getElementById("mySidenav").style.zIndex = "40";
    document.getElementById("dashboard-content").style.zIndex = "-1";
    console.log(document.getElementById("mySidenav").style.zIndex);
    console.log(document.getElementById("dashboard-content").style.zIndex);
  }

  closeNav() {
    document.getElementById("mySidenav").style.zIndex = "-1";
    document.getElementById("dashboard-content").style.zIndex = "40";
    // document.getElementById("dashboard-content").style.marginLeft= "0";
   
  }

}
