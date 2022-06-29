package com.IntiFormation.service;

import java.util.List;

import com.IntiFormation.entity.Commande;
import com.IntiFormation.entity.Produit;

public interface ICommandeService {

	public List<Commande> cherchertt();
	public void Ajouter(Commande c);
	public Commande chercherUn(int idCommande);
	
	
}
