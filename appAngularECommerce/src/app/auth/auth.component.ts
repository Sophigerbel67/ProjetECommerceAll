
import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router } from '@angular/router';
import { Categorie } from '../models/Categorie.model';
import { Produit } from '../models/Produit.model';
import { Utilisateur } from '../models/Utilisateur.model';
import { BasicAuthentificationService } from '../service/basic-authentification.service';
import { CategorieService } from '../service/categorie.service';
import { ProduitService } from '../service/produit.service';
import { UtilisateurService } from '../service/utilisateur.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {

filterTerm: string='';

username!:string;
password!:string;
errorMessage="Error login and/or password";
invalidLogin=false;


categories!:Categorie[];
produits!:Produit[];
produit!: Produit;

selectedP!: string;

utilisateur!:Utilisateur;

constructor(private router:Router,
  private bc:BasicAuthentificationService,
  private service:CategorieService,
  private serviceP:ProduitService,
  private route:ActivatedRoute,
  private serviceU:UtilisateurService) 
  { }

ngOnInit():void
{
  this.chargerCategorie();
  this.getByCat();
  this.recupererP();


  this.produit=new Produit;
  this.utilisateur=new Utilisateur;

}


//Methode authentification
authentification()

{
  this.bc.authentification(this.username,this.password)
  .subscribe(
    data => {
      sessionStorage.setItem('token', 'Bearer ' +data.jwt)
      this.router.navigateByUrl('');
      this.invalidLogin=false;

      //recuperation de l'utilisateur par username
      this.serviceU.getByName(this.username).subscribe(
        response => 
        {
          this.utilisateur=response;
          sessionStorage.setItem('utilisateur',JSON.stringify(this.utilisateur));
        }
      )

    },
    error=>
    {
      console.log("error login and/or password");
      this.invalidLogin=true
    }
  )
  
}

//Methode createBasicHttpHeader()
createBasicHttpHeader()
{
  console.log(this.username);
  let basicchaine='Basic '+window.btoa(this.username+':'+this.password);
  return basicchaine;
}

  //Methode chargerCategorie
  chargerCategorie()
  {
    console.log(this.categories);
    this.service.getAll().subscribe(
      response=>{
        this.categories=response;
      }
    )
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

//Methode afficher
afficher(idCate:number): void
{
  this.router.navigateByUrl('produits/'+idCate);
}


//Methode recupererP
recupererP()
{
  this.serviceP.getAll().subscribe(
    response=>this.produits=response
  );
}


//Methode afficher2
afficher2()
{
  console.log(this.selectedP);
  this.serviceP.getByName(this.selectedP).subscribe(
    response =>
    {
      this.produit=response;
      console.log(this.produit.libProduit);
      this.router.navigateByUrl('rechercher/'+this.produit.idProduit);
    }
  )
}


//Methode inscription
inscription(): void
{
  this.router.navigateByUrl('inscription');
}

//Methode panier
panier(): void
{
  this.router.navigateByUrl('panier');
}

}


