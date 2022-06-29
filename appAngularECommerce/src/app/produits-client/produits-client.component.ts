import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LignePanier } from '../models/LignePanier.model';
import { Panier } from '../models/Panier.model';
import { Produit } from '../models/Produit.model';
import { Utilisateur } from '../models/Utilisateur.model';
import { CategorieService } from '../service/categorie.service';
import { ProduitService } from '../service/produit.service';

@Component({
  selector: 'app-produits-client',
  templateUrl: './produits-client.component.html',
  styleUrls: ['./produits-client.component.css']
})
export class ProduitsClientComponent implements OnInit {

  produits!:Produit[];
  utilisateur!:Utilisateur;

  produit!: Produit;
  lignePanier!: LignePanier;
  panier!: Panier;
  quantite!: number;

  objet!:Panier;

  compteur=0;

  constructor(private route:ActivatedRoute,
    private service:CategorieService,
    private serviceP:ProduitService,
    private router:Router) { }

  //Methode ngOnInit
  ngOnInit(): void 
  {

    this.getByCat();

    this.produit=new Produit;
    this.lignePanier=new LignePanier();
    this.panier=new Panier;
    this.panier.idPanier=2;

    this.objet=JSON.parse(sessionStorage['panier']);

    this.panier=this.objet
    if (this.panier==null)
    {
      this.panier=new Panier;
      sessionStorage.setItem('panier',JSON.stringify(this.panier));
    }
    
    this.getById();
    
  }

//Methode produitsAssocie
getByCat()
{
  const idCategorie=+this.route.snapshot.params['idCategorie'];
  this.serviceP.getByCat(idCategorie).subscribe(
  response =>
    {
      this.produits = response
    }
      
  )
}

 //Methode getById
 getById()
 {
   const idProduit=+this.route.snapshot.params['idProduit'];
   this.serviceP.getById(idProduit).subscribe(
     response=>this.produit=response
   );
 }

//Methode addPanier
addPanier(idProduit:number)
{

  this.lignePanier.idLignePanier=this.compteur;
  sessionStorage.setItem('compteur',JSON.stringify(this.compteur+1));

  console.log(idProduit);
  
    this.serviceP.getById(idProduit).subscribe(
      response =>
      {
        this.produit=response;
      this.lignePanier.produit=this.produit;
      this.lignePanier.quantite=this.quantite;
      this.panier.lignePanier.push(this.lignePanier);

      sessionStorage.setItem('panier',JSON.stringify(this.panier));

      this.router.navigateByUrl('/panier');

      }
    );
  
}
}
