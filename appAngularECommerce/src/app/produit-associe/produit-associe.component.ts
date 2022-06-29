import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produit } from '../models/Produit.model';
import { CategorieService } from '../service/categorie.service';
import { ProduitService } from '../service/produit.service';

@Component({
  selector: 'app-produit-associe',
  templateUrl: './produit-associe.component.html',
  styleUrls: ['./produit-associe.component.css']
})
export class ProduitAssocieComponent implements OnInit {

  p!:Produit;

  produits!:Produit[];

  constructor(private route:ActivatedRoute,
    private service:CategorieService,
    private serviceP:ProduitService,
    private router:Router) {}

  //Methode ngOnInit
  ngOnInit(): void 
  {
    this.getByCat();
    
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


 //Methode afficherCategories
 afficherCategories()
 {
   this.router.navigateByUrl('afficherCategories');
 }

}
