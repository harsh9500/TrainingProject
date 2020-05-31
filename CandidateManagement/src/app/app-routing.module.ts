import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component'
import { DashboardComponent } from './dashboard/dashboard.component';
import { SearchCandidateComponent } from './search-candidate/search-candidate.component';
import { AddCandidateComponent } from './add-candidate/add-candidate.component';
import { TrendsComponent } from './trends/trends.component';
import { ViewCandidateComponent } from './view-candidate/view-candidate.component';
import { UpdateCandidateComponent } from './update-candidate/update-candidate.component';

const routes: Routes = [{
  path:'login',
  component:LoginComponent
},{
  path:'dashboard',
  component:DashboardComponent
},
{
  path:'candidate/search',
  component: SearchCandidateComponent
},
{
  path:'candidate/add',
  component: AddCandidateComponent
},
{
  path:'candidate/view',
  component: ViewCandidateComponent
},
{
  path:'candidate/trends',
  component: TrendsComponent
},
{
  path:'candidate/details/:id',
  component: UpdateCandidateComponent
},
{
  path:'',
  redirectTo:'login',
  pathMatch:'full'
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
