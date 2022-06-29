import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Utilisateur } from '../models/Utilisateur.model';
import { UtilisateurService } from '../service/utilisateur.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})
export class InscriptionComponent implements OnInit {

  utilisateur!: Utilisateur;

  constructor(private router:Router,
              private service:UtilisateurService) 
              { }

  //Methode ngOnInit
  ngOnInit(): void 
  {
    this.utilisateur=new Utilisateur;
  }

//Methode inscription
inscription()
{
  this.service.inscription(this.utilisateur).subscribe(
    response=>{
      this.utilisateur=response
     
    }
  )
  this.router.navigateByUrl('/authentification');
}


}
