import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { BackendService } from '../backend.service';
import { Router } from '@angular/router';
import { Candidate } from '../candidate.model';

@Component({
  selector: 'app-add-candidate',
  templateUrl: './add-candidate.component.html',
  styleUrls: ['./add-candidate.component.scss']
})
export class AddCandidateComponent implements OnInit {

  candidate:Candidate;
  success:boolean;
  addCandidateForm: FormGroup;
  constructor(private backendService:BackendService, private router:Router) { }

  ngOnInit(): void {

    this.success=false;
    this.candidate=new Candidate();

    this.addCandidateForm = new FormGroup({
      name: new FormControl(null, [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(40),
        Validators.pattern("^[A-Z a-z]+$")
      ]),
      email: new FormControl(null,[
        Validators.required,
        Validators.email,
      ]),
      institute: new FormControl(null, [
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(40),
        Validators.pattern("^[A-Z a-z]+$")
      ]),
      contact: new FormControl(null, [
        Validators.required,
        Validators.pattern("^[0-9]{10}$")
      ]),
      description: new FormControl(null, [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(40),
        Validators.pattern("^[A-Z a-z]+$")
      ]),
      location: new FormControl("Mumbai",Validators.required),
      joiningDate: new FormControl(null, [
        Validators.required,
      ]),
      skills: new FormControl(null)
      
    });
  }


  onSubmit() {

    this.candidate=this.addCandidateForm.value;
    console.log(this.addCandidateForm.value);
    this.backendService.addCandidate(this.candidate)
    .subscribe(()=>{
      this.success=true;
      // this.router.navigateByUrl('/candidate/view');
      this
    });
  }


}
