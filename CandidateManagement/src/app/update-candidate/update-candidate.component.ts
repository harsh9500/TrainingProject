import { Component, OnInit } from '@angular/core';
import { BackendService } from '../backend.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Candidate } from '../candidate.model';

@Component({
  selector: 'app-update-candidate',
  templateUrl: './update-candidate.component.html',
  styleUrls: ['./update-candidate.component.scss']
})
export class UpdateCandidateComponent implements OnInit {

  candidate:Candidate;
  id:number;
  constructor(private backendService:BackendService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {

    this.candidate = new Candidate();
    
    this.id=this.route.snapshot.params['id'];

    this.backendService.getCandidate(this.id).subscribe(
      (candidate)=>{
        this.candidate=candidate;
      }
    )

  }


  onSubmit() {
    this.backendService.updateCandidate(this.id,this.candidate)
    .subscribe(()=>{
      this.candidate=new Candidate();
      this.router.navigateByUrl('/candidate/view');
    });
  }

}



