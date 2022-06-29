package com.IntiFormation.service;

import java.util.List;

import com.IntiFormation.entity.Categorie;
import com.IntiFormation.entity.Produit;

public interface ICategorieService {
	
	public void Ajouter(Categorie c);
	public List<Categorie> cherchertt();
	public Categorie chercherUn(int idCategorie);
	public void modifier(Categorie c);
	public void delete(int idCategorie);

	

}
