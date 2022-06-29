import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Categorie } from '../models/Categorie.model';
import { Commande } from '../models/Commande.model';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {

  constructor(private http:HttpClient) { }


//Methode getAll
getAll()
{
  return this.http.get<Commande[]>('http://localhost:8080/GestionCommande/afficherCommande');
}


}
