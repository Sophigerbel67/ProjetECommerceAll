import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app.routing.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpInterceptorBasicAuthService } from './service/http-interceptor-basic-auth.service';
import { FormsModule } from '@angular/forms';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

import { AppComponent } from './app.component';
import { AuthComponent } from './auth/auth.component';
import { ListeCategorieComponent } from './liste-categorie/liste-categorie.component';
import { ListeProduitComponent } from './liste-produit/liste-produit.component';
import { ModifierPComponent } from './modifier-p/modifier-p.component';
import { ModifierCComponent } from './modifier-c/modifier-c.component';
import { AddCategorieComponent } from './add-categorie/add-categorie.component';
import { ProduitAssocieComponent } from './produit-associe/produit-associe.component';
import { AddProduitsComponent } from './add-produits/add-produits.component';
import { ListeCommandComponent } from './liste-command/liste-command.component';
import { ProduitsClientComponent } from './produits-client/produits-client.component';
import { RechercherPComponent } from './rechercher-p/rechercher-p.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { PanierComponent } from './panier/panier.component';
import { CommandeValideComponent } from './commande-valide/commande-valide.component';


@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    ListeCategorieComponent,
    ListeProduitComponent,
    ModifierPComponent,
    ModifierCComponent,
    AddCategorieComponent,
    ProduitAssocieComponent,
    AddProduitsComponent,
    ListeCommandComponent,
    ProduitsClientComponent,
    RechercherPComponent,
    InscriptionComponent,
    PanierComponent,
    CommandeValideComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    Ng2SearchPipeModule
  ],
  providers: [
    {provide:HTTP_INTERCEPTORS,useClass:HttpInterceptorBasicAuthService,multi:true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
