import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from '../models/Categorie.model';
import { Produit } from '../models/Produit.model';
import { CategorieService } from '../service/categorie.service';
import { ProduitService } from '../service/produit.service';

@Component({
  selector: 'app-modifier-p',
  templateUrl: './modifier-p.component.html',
  styleUrls: ['./modifier-p.component.css']
})
export class ModifierPComponent implements OnInit {

  produit!:Produit;

  categories!:Categorie[];

  selectedFile!: File;
  selectedCategorie!:Categorie;


  @Output() newItemEvent=new EventEmitter<number>();

  constructor(private service:ProduitService,
    private route:ActivatedRoute,
    private router:Router,
    private serviceC:CategorieService) { }

  ngOnInit(): void
  {
    this.recupererP();
    this.chargerCategorie();
    this.produit=new Produit();

  } 
  
//Methode recupererP
recupererP()
{
  const idP=+this.route.snapshot.params['idProduit'];
  console.log(idP);
  this.service.getById(idP).subscribe(
    response=>this.produit=response
  )
}

//Methode selectEvent
selectEvent(event:any): void
{
  this.selectedFile=event.target.files[0];
}

  //Methode modifier
  modif()
  {
    let formData= new FormData();
  formData.append("libProduit",this.produit.libProduit);
  formData.append("quantite",this.produit.quantite.toString());
  formData.append("file",this.selectedFile);
  formData.append("idcategorie", this.selectedCategorie.idCategorie.toString());
  formData.append("idProduit",this.produit.idProduit.toString());

    
    this.service.modifierP(formData).subscribe(
      response=>{
        this.newItemEvent.emit(1);
        this.service.getAll();
      }
    );
    this.router.navigateByUrl('afficherProduits');
  }

 //Methode afficherProduits
 afficherProduits()
 {
   this.router.navigateByUrl('afficherProduits');
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
