import { Component, OnInit } from '@angular/core';
import { BackendService } from '../backend.service';

@Component({
  selector: 'app-trends',
  templateUrl: './trends.component.html',
  styleUrls: ['./trends.component.scss']
})
export class TrendsComponent implements OnInit {

  locationData: any;
  descriptionData: any;
  instituteData: any;

  view: any[] = [600, 400];
  viewCenter: any[] = [1200, 400];

  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabel = 'Cities';
  yAxisLabel = 'Number of Candidates';
  showYAxisLabel = true;
  showLabels = true;
  rotateXAxisticks = false;
  isDoughnut = true;

  ;

  colorScheme = {
    domain: ['#9370DB', '#87CEFA', '#FA8072', '#FF7F50', '#90EE90', '#9370DB']
  };

  constructor(private backendService:BackendService) { }

  ngOnInit(): void {
    this.backendService.getLocationTrends().subscribe(
      (locationData)=>{
        this.locationData=locationData;
      }
    )

    this.backendService.getDescriptionTrends().subscribe(
      (descriptionData)=>{
        this.descriptionData=descriptionData;
      }
    )

    this.backendService.getInstituteTrends().subscribe(
      (instituteData)=>{
        this.instituteData=instituteData;
      }
    )
  }

}
