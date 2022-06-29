import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Categorie } from '../models/Categorie.model';
import { Produit } from '../models/Produit.model';
import { CategorieService } from '../service/categorie.service';
import { ProduitService } from '../service/produit.service';

@Component({
  selector: 'app-add-produits',
  templateUrl: './add-produits.component.html',
  styleUrls: ['./add-produits.component.css']
})
export class AddProduitsComponent implements OnInit {

  produit!:Produit;
  categories!:Categorie[];
  selectedFile!: File;

  idC!:number;

  constructor(private router:Router,
              private service:ProduitService,
              private serviceC:CategorieService) 
    { }

  //Methode ngOnInit
  ngOnInit(): void 
  {
    this.produit=new Produit();
    //this.produit=new Produit;
    this.chargerCategorie();
    this.idC=0;
  }

  
//Methode selectEvent
selectEvent(event:any): void
{
  this.selectedFile=event.target.files[0];
}

//Methode AjouterProduit()w
AjouterProduit()
{
  let value=(<HTMLSelectElement>document.getElementById('idC')).value;
  this.idC=+value;

  //console.log(this.idC);
  //console.log(this.produit.libProduit);
  //console.log(this.produit.quantite);
  //console.log(this.selectedFile.name);
  let formData= new FormData();
  formData.append("libProduit",this.produit.libProduit);
  formData.append("quantite",this.produit.quantite.toString());
  formData.append("file",this.selectedFile);
  formData.append("idcategorie", this.idC.toString());

  this.service.ajouterP(formData).subscribe(
    response => 
    {
      this.router.navigateByUrl('afficherProduits');
      console.log("upload was a success");
    }
  );
  
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

 //Methode afficherProduits
 afficherProduits()
 {
   this.router.navigateByUrl('afficherProduits');
 }


}
