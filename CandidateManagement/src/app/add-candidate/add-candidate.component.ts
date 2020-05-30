import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { BackendService } from '../backend.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-candidate',
  templateUrl: './add-candidate.component.html',
  styleUrls: ['./add-candidate.component.scss']
})
export class AddCandidateComponent implements OnInit {

  addCandidateForm: FormGroup;
  message: String;
  constructor(private backendService:BackendService, private router:Router) { }

  ngOnInit(): void {
    this.addCandidateForm = new FormGroup({
      name: new FormControl(null, [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(40),
      ]),
      email: new FormControl(null,
        [Validators.required,
          Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")
      ])
      
    });
  }

  onSubmit() {
    console.log(this.addCandidateForm.value);
    this.backendService.addCandidate(this.addCandidateForm.value)
    .subscribe(()=>{
      this.router.navigateByUrl('/candidate/view');
      this
    });
  }

  onChange() {
    this.message=""
  }

}
