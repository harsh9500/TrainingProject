import { Component, OnInit } from '@angular/core';
import { BackendService } from '../backend.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-view-candidate',
  templateUrl: './view-candidate.component.html',
  styleUrls: ['./view-candidate.component.scss']
})
export class ViewCandidateComponent implements OnInit {

  candidates:Object[];
  constructor(private backendService:BackendService) { }

  ngOnInit(): void {
    this.getData();
  }

  getData() {
    this.backendService.getCandidateList()
    .subscribe((list)=>{
      this.candidates=list;
    });
  }

  deleteCandidate(id:number) {
    this.backendService.deleteCandidate(id)
    .subscribe(data=>{
      console.log(data);
      this.getData();
    }
    )
  }
}
