import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LignePanier } from '../models/LignePanier.model';
import { Panier } from '../models/Panier.model';
import { Produit } from '../models/Produit.model';
import { ProduitService } from '../service/produit.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {

  panier!: Panier;
  lignePanier!: LignePanier[];

  produits!:Produit[];

  constructor(private serviceP:ProduitService,
    private router:Router) { }

  //Methode ngOnInit
  ngOnInit(): void 
  {
    this.panier=JSON.parse(sessionStorage['panier']);
    this.lignePanier=this.panier.lignePanier;

    this.recupererP;
  }

  //Methode recupererP
  recupererP()
  {
    this.serviceP.getAll().subscribe(
     response=>this.produits=response
    );
  }

//Methode supprimer
supprimer(idLignePanier:number)
{
  this.panier=JSON.parse(sessionStorage['panier']);
  for(let i=0;i<this.panier.lignePanier.length;i++)
  {
    if(this.panier.lignePanier[i].idLignePanier==idLignePanier)
    {
      delete this.panier.lignePanier[i]
    }
  }

  sessionStorage.setItem('panier', JSON.stringify(this.panier));
  this.router.navigateByUrl('/panier');
}


 //Methode commandeValide
 commandeValide()
 {
   this.router.navigateByUrl('commandeValide');
 }

//Methode retour
retour()
{
  this.router.navigateByUrl('authentification');
}




}
