import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCategorieComponent } from './add-categorie/add-categorie.component';
import { AddProduitsComponent } from './add-produits/add-produits.component';
import { AuthComponent } from './auth/auth.component';
import { CommandeValideComponent } from './commande-valide/commande-valide.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ListeCategorieComponent } from './liste-categorie/liste-categorie.component';
import { ListeCommandComponent } from './liste-command/liste-command.component';
import { ListeProduitComponent } from './liste-produit/liste-produit.component';
import { ModifierCComponent } from './modifier-c/modifier-c.component';
import { ModifierPComponent } from './modifier-p/modifier-p.component';
import { PageprincipaleComponent } from './pageprincipale/pageprincipale.component';
import { PanierComponent } from './panier/panier.component';
import { ProduitAssocieComponent } from './produit-associe/produit-associe.component';
import { ProduitsClientComponent } from './produits-client/produits-client.component';
import { RechercherPComponent } from './rechercher-p/rechercher-p.component';


const routes: Routes =[
  {path:'authentification',component:AuthComponent},
  {path:'',component:PageprincipaleComponent},
  {path:'authentification',component:AuthComponent},
  {path:'afficherCategories',component:ListeCategorieComponent},
  {path:'afficherProduits',component:ListeProduitComponent},
  {path:'modifierP/:idProduit',component:ModifierPComponent},
  {path:'modifierC/:idCategorie',component:ModifierCComponent},
  {path:'AjouterCategorie',component:AddCategorieComponent},
  {path:'afficherProduitsAssocies/:idCategorie',component:ProduitAssocieComponent},
  {path:'AjouterProduit',component:AddProduitsComponent},
  {path:'afficherCommandes',component:ListeCommandComponent},
  {path:'produits/:idCategorie',component:ProduitsClientComponent},
  {path:'rechercher/:idProduit',component:RechercherPComponent},
  {path:'inscription', component:InscriptionComponent},
  {path:'panier',component:PanierComponent},
  {path:'commandeValide',component:CommandeValideComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }