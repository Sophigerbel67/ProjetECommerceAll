import { Panier } from "./Panier.model";
import { Produit } from "./Produit.model";

export class LignePanier
{

  idLignePanier!: number;

  produit!:Produit;
  quantite!: number;
  panier!: Panier;
}
