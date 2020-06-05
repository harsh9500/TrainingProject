import { Component, OnInit } from '@angular/core';
import { AuthService, SocialUser } from 'angularx-social-login';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  user:SocialUser

  constructor(private authService:AuthService, private router:Router) { }

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

  openNav() {
    document.getElementById("mySidenav").style.width = "250px";
  }

  closeNav() {
    document.getElementById("mySidenav").style.width = "0px";
   
  }

  signOut(){
    this.authService.signOut().then(
      ()=>{
        localStorage.removeItem('token'); 
        this.router.navigateByUrl('/login');
    },
      (reason:any)=>alert(reason)
    );
  }

}
