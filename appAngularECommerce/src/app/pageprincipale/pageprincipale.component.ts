import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pageprincipale',
  templateUrl: './pageprincipale.component.html',
  styleUrls: ['./pageprincipale.component.css']
})
export class PageprincipaleComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

 //Methode afficherCategories
 afficherCategories()
 {
   this.router.navigateByUrl('afficherCategories');
 }


 //Methode afficherProduits
 afficherProduits()
 {
   this.router.navigateByUrl('afficherProduits');
 }


  //Methode afficherCommandes
  afficherCommandes()
  {
    this.router.navigateByUrl('afficherCommandes');
  }
 
 

//Methode deconnexion
deconnexion()
{
  sessionStorage.removeItem("token");
  this.router.navigateByUrl("authentification");
  console.log("ko");
}



}
