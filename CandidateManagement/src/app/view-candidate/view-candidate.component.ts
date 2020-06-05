import { Component, OnInit } from '@angular/core';
import { BackendService } from '../backend.service';
import { Router } from '@angular/router';
import { Candidate } from '../candidate.model';

@Component({
  selector: 'app-view-candidate',
  templateUrl: './view-candidate.component.html',
  styleUrls: ['./view-candidate.component.scss']
})
export class ViewCandidateComponent implements OnInit {

  p: number = 1;
  candidates:Candidate[]=[];
  constructor(private backendService:BackendService, private router:Router) { }

  ngOnInit(): void {
    this.getData();
  }

  getData() {
    this.backendService.getCandidateList()
    .subscribe((list)=>{
      list.forEach((candidate)=>{
        candidate.skills=candidate.skills!=null?candidate.skills.trim():candidate.skills
        candidate.skills=candidate.skills!=null?candidate.skills.split(/[ ,]+/).join(', '):candidate.skills;
      })
      this.candidates=list;
    });
  }

  deleteCandidate(id:number) {
    this.backendService.deleteCandidate(id).subscribe(()=>this.getData());
  }

  viewDetailsCandidate(id:number) {
    this.router.navigate(['candidate/details',id])
  }

}
