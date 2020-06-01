import { Component, OnInit } from '@angular/core';
import { BackendService } from '../backend.service';
import { Candidate } from '../candidate.model';

@Component({
  selector: 'app-search-candidate',
  templateUrl: './search-candidate.component.html',
  styleUrls: ['./search-candidate.component.scss']
})
export class SearchCandidateComponent implements OnInit {

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
    console.log(this.term);
    this.backendService.search(this.term,this.criterion)
    .subscribe(
      (list)=>{
        this.candidates=list
        if(!list.length)
          this.noresults=true;
        else
          this.noresults=false;
      }
    )
  }

}
