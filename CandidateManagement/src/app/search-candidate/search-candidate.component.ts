import { Component, OnInit } from '@angular/core';
import { BackendService } from '../backend.service';
import { Candidate } from '../candidate.model';

@Component({
  selector: 'app-search-candidate',
  templateUrl: './search-candidate.component.html',
  styleUrls: ['./search-candidate.component.scss']
})
export class SearchCandidateComponent implements OnInit {

  p: number = 1;
  candidates:Candidate[]=[];
  criterion:string='location';
  term:string='';
  noresults:boolean=false;

  constructor(private backendService:BackendService) { }

  ngOnInit(): void {
    
  }

  onCriteriaSelection(criterion: string) {
    this.criterion=criterion
  }

  onSearch() {
    this.backendService.search(this.term,this.criterion)
    .subscribe(
      (list)=>{
        list.forEach((candidate)=>{
          candidate.skills=candidate.skills!=null?candidate.skills.trim():candidate.skills
          candidate.skills=candidate.skills!=null?candidate.skills.split(/[ ,]+/).join(', '):candidate.skills;
        })
        this.candidates=list;
        if(!list.length)
          this.noresults=true;
        else
          this.noresults=false;
      }
    )
  }

}
