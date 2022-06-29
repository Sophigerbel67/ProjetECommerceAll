import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categorie } from '../models/Categorie.model';
import { CategorieService } from '../service/categorie.service';

@Component({
  selector: 'app-modifier-c',
  templateUrl: './modifier-c.component.html',
  styleUrls: ['./modifier-c.component.css']
})
export class ModifierCComponent implements OnInit {

  categorie!:Categorie;

  @Output() newItemEvent=new EventEmitter<number>();

  constructor(private service:CategorieService,
    private route:ActivatedRoute,
    private router:Router) { }

  //Methode ngOnInit
  ngOnInit(): void 
  {
    this.recupererC();
  }

//Methode recupererC
recupererC()
{
  const idC=+this.route.snapshot.params['idCategorie'];
  console.log(idC);
  this.service.getById(idC).subscribe(
    response=>this.categorie=response
  )
}


  //Methode modifier
  modif(c:Categorie)
  {
    this.service.modifierC(c).subscribe(
      response=>{
        this.newItemEvent.emit(1);
        this.service.getAll();
      }
    );
    this.router.navigateByUrl('afficherCategories');
  }

   //Methode afficherCategories
  afficherCategories()
  {
    this.router.navigateByUrl('afficherCategories');
  }


}
