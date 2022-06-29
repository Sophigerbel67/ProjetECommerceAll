import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Categorie } from '../models/Categorie.model';
import { Produit } from '../models/Produit.model';
import { CategorieService } from '../service/categorie.service';
import { ProduitService } from '../service/produit.service';

@Component({
  selector: 'app-liste-categorie',
  templateUrl: './liste-categorie.component.html',
  styleUrls: ['./liste-categorie.component.css']
})
export class ListeCategorieComponent implements OnInit {

categories!:Categorie[];

produits!:Produit[];

  constructor(private service:CategorieService,
    private router:Router,
    private serviceP:ProduitService) { }

  //Methode ngOnInit
  ngOnInit(): void 
  {

    this.chargerCategorie();
    this.recupererP();
  }

  //Methode chargerCategorie
  chargerCategorie()
  {
    this.service.getAll().subscribe(
      response=>{
        this.categories=response;
      }
    )
  }

  //Methode supprimer
  supprimer(idCategorie:number)
  {
    this.service.supprimer(idCategorie).subscribe(
      response=>{
        this.chargerCategorie();
      }
    )
  }

//Methode modifier
modifier(idCategorie:number)
{
  this.router.navigateByUrl('modifierC/'+idCategorie);
}
  
//Methode afficher
afficher(idCate:number): void
{
  this.router.navigateByUrl('afficherProduitsAssocies/'+idCate)
}


//Methode recupererP
recupererP()
{
  this.serviceP.getAll().subscribe(
    response=>this.produits=response
  );
}

 //Methode afficherProduits
 AjouterCategorie()
 {
   this.router.navigateByUrl('AjouterCategorie');
 }

}
