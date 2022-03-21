import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmployeeDataService {

  constructor(private http:HttpClient) { }
    
    public getEmployees() {
      this.http.get("http://localhost:8080/employee/getAll");
    }

}
