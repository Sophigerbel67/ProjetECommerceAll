import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Categorie } from '../models/Categorie.model';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  

  constructor(private http:HttpClient) { }

//Methode getAll
getAll()
{
  return this.http.get<Categorie[]>('http://localhost:8080/GestionCategorie/afficher');
}

//Methode supprimer
supprimer(idCategorie:number)
{ 
  return this.http.delete('http://localhost:8080/GestionCategorie/SupprimerCategorie/'+idCategorie);

}

//Methode modifierP
modifierC(categorie:Categorie)
{
  return this.http.put<Categorie>('http://localhost:8080/GestionCategorie/ModifierCategorie',categorie);
}

//Methode getById
getById(idCategorie:number)
{
  return this.http.get<Categorie>('http://localhost:8080/GestionCategorie/Categorie/'+idCategorie);
}

//Methode ajouterC
ajouterC(c:Categorie)
{
  return this.http.post<Categorie>('http://localhost:8080/GestionCategorie/ajouterCategorie',c);
}


}

