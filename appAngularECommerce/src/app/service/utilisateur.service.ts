import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LignePanier } from '../models/LignePanier.model';
import { Utilisateur } from '../models/Utilisateur.model';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  constructor(private http:HttpClient) { }

//Methode inscription
inscription(u:Utilisateur)
{
  return this.http.post<Utilisateur>('http://localhost:8080/utilisateurs/2',u);
}


//Methode getByName
getByName(username:string)
{
  return this.http.get<Utilisateur>('http://localhost:8080/utilisateurs/'+username);
}


}
