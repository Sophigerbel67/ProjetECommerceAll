package com.IntiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IntiFormation.entity.Categorie;
import com.IntiFormation.entity.Commande;
import com.IntiFormation.entity.LigneCommande;
import com.IntiFormation.entity.Produit;


public interface IligneCommande extends JpaRepository<LigneCommande, Integer>{
	
	public List<LigneCommande> findLigneCommandeByCommande_idCommande(int idCommande);
	
	

}
