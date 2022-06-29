package com.IntiFormation.service;

import java.util.List;

import com.IntiFormation.entity.Categorie;
import com.IntiFormation.entity.Commande;
import com.IntiFormation.entity.Produit;

public interface IProduitService {
	
	public void Ajouter(Produit p);
	public List<Produit> cherchertt();
	public Produit chercherUn(int idProduit);
	public void modifier(Produit p);
	public void delete(int idProduit);
	public List<Produit> getByCategorie(Categorie categorie);
	public Produit getByName (String libProduit);
	public List<Produit> produitsAss(int idCate);


	
	
}
