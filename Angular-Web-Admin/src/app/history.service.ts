import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';

export interface History{
  timestamp: string;
  username: string;
  city: string;
}

@Injectable({
  providedIn: 'root'
})
export class HistoryService {
  private historyUrl : string = "http://localhost:8080/api/history";
  constructor(private http : HttpClient) {}

  getHistory(): Observable<any>{
      return this.http.get(this.historyUrl)
  }
}
