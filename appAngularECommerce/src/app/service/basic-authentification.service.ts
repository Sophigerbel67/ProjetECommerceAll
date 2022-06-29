import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthOk } from '../models/AuthOk.model';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthentificationService {

  constructor(private http:HttpClient) { }


//Methode authentification
authentification(username:string,password:string)
{

  
  return this.http.post<any>('http://localhost:8080/authenticate',
  {username,
  password});

}

}
