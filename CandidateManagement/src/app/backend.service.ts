import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BackendService {

  private baseUrl:string="http://localhost:8082/candidates";
  constructor(private http:HttpClient) {}

  addCandidate(candidate:Object): Observable<any> {
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

  updateCandidate(id: number, candidate: any): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, candidate);
  }
}
