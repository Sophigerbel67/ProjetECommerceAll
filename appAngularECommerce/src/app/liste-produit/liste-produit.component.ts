import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Categorie } from '../models/Categorie.model';
import { Produit } from '../models/Produit.model';
import { CategorieService } from '../service/categorie.service';
import { ProduitService } from '../service/produit.service';

@Component({
  selector: 'app-liste-produit',
  templateUrl: './liste-produit.component.html',
  styleUrls: ['./liste-produit.component.css']
})
export class ListeProduitComponent implements OnInit {

  produits!:Produit[];

  categories!:Categorie[];

  constructor(private service:ProduitService,
    private router:Router,
    private serviceC:CategorieService) { }

  //Methode ngOnInit
  ngOnInit(): void 
  {

    this.chargerProduit();
    this.chargerCategorie();
  }

  //Methode chargerCategorie
  chargerProduit()
  {
    this.service.getAll().subscribe(
      response=>{
        this.produits=response;
      }
    )
  }

  //Methode supprimer
    supprimer(idProduit:number)
    {
      this.service.supprimer(idProduit).subscribe(
        response=>{
          this.chargerProduit();
        }
      )
    }

//Methode modifier
modifier(idProduit:number)
{
  this.router.navigateByUrl('modifierP/'+idProduit);
}

 //Methode AjouterProduit
 AjouterProduit()
 {
   this.router.navigateByUrl('AjouterProduit');
 }

 //Methode chargerCategorie()
 chargerCategorie()
 {
   this.serviceC.getAll().subscribe(
     response=>{
       this.categories=response;
     }
   )
 }


}
