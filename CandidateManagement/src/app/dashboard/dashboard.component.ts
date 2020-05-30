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

  constructor(private authService:AuthService, private router:Router) { }

  ngOnInit(): void {
    this.authService.authState.subscribe((user) => {
      this.user = user;
    });
  }

}