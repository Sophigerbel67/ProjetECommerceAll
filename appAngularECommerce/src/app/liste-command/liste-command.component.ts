import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Categorie } from '../models/Categorie.model';
import { Commande } from '../models/Commande.model';
import { Produit } from '../models/Produit.model';
import { CategorieService } from '../service/categorie.service';
import { CommandeService } from '../service/commande.service';
import { ProduitService } from '../service/produit.service';

@Component({
  selector: 'app-liste-command',
  templateUrl: './liste-command.component.html',
  styleUrls: ['./liste-command.component.css']
})
export class ListeCommandComponent implements OnInit {

  commandes!:Commande[];
  categories!:Categorie[];
  produits!:Produit[];


  constructor(private service:CategorieService,
    private router:Router,
    private serviceP:ProduitService,
    private ServiceCom:CommandeService) { }

  //Methode ngOnInit
  ngOnInit(): void 
  {
    this.chargerCommande();
    this.chargerCategorie();
    this.chargerProduit();

  }


//Methode chargerCategorie
chargerCommande()
{
  this.ServiceCom.getAll().subscribe(
    response=>{
      this.commandes=response;
    }
  )
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

    //Methode chargerProduit
    chargerProduit()
    {
      this.serviceP.getAll().subscribe(
        response=>{
          this.produits=response;
        }
      )
    }

 


}
