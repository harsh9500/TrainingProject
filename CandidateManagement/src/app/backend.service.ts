import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Candidate } from './candidate.model';

@Injectable({
  providedIn: 'root'
})
export class BackendService {
  

  private baseUrl:string="http://localhost:8082/candidates";
  private searchUrl:string="http://localhost:8082/search";
  private trendsUrl:string="http://localhost:8082/trends";
  constructor(private http:HttpClient) {}

  addCandidate(candidate:Candidate): Observable<any> {
    return this.http.post(this.baseUrl,candidate);
  }

  getCandidateList(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getCandidate(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  deleteCandidate(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  updateCandidate(id: number, candidate: Candidate): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, candidate);
  }

  search(term: string, criterion: String): Observable<any> {
    return this.http.get(`${this.searchUrl}/${criterion}/${term}`);
  }

  getLocationTrends(): Observable<any> {
    return this.http.get(`${this.trendsUrl}/location`);
  }

  getInstituteTrends(): Observable<any> {
    return this.http.get(`${this.trendsUrl}/institute`);
  }

  getDescriptionTrends(): Observable<any> {
    return this.http.get(`${this.trendsUrl}/description`);
  }

}
