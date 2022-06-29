import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Categorie } from '../models/Categorie.model';
import { CategorieService } from '../service/categorie.service';

@Component({
  selector: 'app-add-categorie',
  templateUrl: './add-categorie.component.html',
  styleUrls: ['./add-categorie.component.css']
})
export class AddCategorieComponent implements OnInit {

  categorie!:Categorie;

  constructor(private router:Router,
              private service:CategorieService) 
    { }

  //Methode ngOnInit
  ngOnInit(): void 
  {
    this.categorie=new Categorie;
  }

//AjouterCategorie
AjouterCategorie()
  {
    this.service.ajouterC(this.categorie).subscribe(
      response=>{
        this.router.navigateByUrl('afficherCategories');
      }
    )
  }

  
 //Methode afficherCategories
 afficherCategories()
 {
   this.router.navigateByUrl('afficherCategories');
 }

}
