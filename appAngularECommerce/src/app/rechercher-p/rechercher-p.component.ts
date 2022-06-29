import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produit } from '../models/Produit.model';
import { CategorieService } from '../service/categorie.service';
import { ProduitService } from '../service/produit.service';

@Component({
  selector: 'app-rechercher-p',
  templateUrl: './rechercher-p.component.html',
  styleUrls: ['./rechercher-p.component.css']
})
export class RechercherPComponent implements OnInit {

  produit!:Produit;

  constructor(private route:ActivatedRoute,
    private service:CategorieService,
    private serviceP:ProduitService,
    private router:Router) { }

  //Methode ngOnInit
  ngOnInit(): void 
  {
    this.produit=new Produit;
    this.getById();
  }

//Methode getByName
getById()
 {
   const idProduit=+this.route.snapshot.params['idProduit'];
   this.serviceP.getById(idProduit).subscribe(
   response =>
     {
       this.produit = response
     }
       
   )
 }



}
