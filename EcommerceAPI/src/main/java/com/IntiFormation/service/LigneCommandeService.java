package com.IntiFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IntiFormation.dao.IcategorieDao;
import com.IntiFormation.dao.IligneCommande;
import com.IntiFormation.entity.Categorie;
import com.IntiFormation.entity.Commande;
import com.IntiFormation.entity.LigneCommande;
import com.IntiFormation.entity.Produit;

@Service
public class LigneCommandeService implements ILigneCommandeService{
	
	@Autowired
	IligneCommande lcDao;
	
	public void Ajouter(LigneCommande lc)
	{
		lcDao.save(lc);
	}

	
	public List<LigneCommande> findLigneCommandeByCommande_idCommande(int idCommande)
	{
		return lcDao.findLigneCommandeByCommande_idCommande(idCommande);
		
	}
	
	public Optional<LigneCommande> selectLigneCommandeById(int idLigneCommande)
	{
		return lcDao.findById(idLigneCommande);
	}


	
	
	
}
