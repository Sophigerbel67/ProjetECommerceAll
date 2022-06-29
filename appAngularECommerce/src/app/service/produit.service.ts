import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Form } from '@angular/forms';
import { Observable } from 'rxjs';
import { Produit } from '../models/Produit.model';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  produits!:Produit[];

  constructor(private http:HttpClient) { }


//Methode getAll
getAll()
{
  return this.http.get<Produit[]>('http://localhost:8080/GestionProduit/afficherP');
}


//Methode supprimer
supprimer(idProduit:number)
{ 
  return this.http.delete('http://localhost:8080/GestionProduit/SupprimerCategorie/'+idProduit);

}

//Methode modifierP
modifierP(data:FormData)
{
  return this.http.put<Produit>('http://localhost:8080/GestionProduit/ModifierProduit',data);
}

//Methode getById
getById(idProduit:number)
{
  return this.http.get<Produit>('http://localhost:8080/GestionProduit/Produit/'+idProduit);
}

//Methode ajouterP
ajouterP(data:FormData)
{
  return this.http.post<Produit>('http://localhost:8080/GestionProduit/ajouterProduit',data);
}

//Methode produitsAss
getByCat(idCate:number)
{
  return this.http.get<Produit[]>('http://localhost:8080/GestionProduit/produitIdCat/'+idCate);
}

//Methode getByName
getByName(libProduit:string)
{
  return this.http.get<Produit>('http://localhost:8080/GestionProduit/produitName/'+libProduit);
}

}