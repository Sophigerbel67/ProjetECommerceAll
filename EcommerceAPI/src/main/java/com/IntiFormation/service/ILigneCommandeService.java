package com.IntiFormation.service;

import java.util.List;
import java.util.Optional;

import com.IntiFormation.entity.Commande;
import com.IntiFormation.entity.LigneCommande;

public interface ILigneCommandeService {
	
	public void Ajouter(LigneCommande lc);
	public List<LigneCommande> findLigneCommandeByCommande_idCommande(int idCommande);
	public Optional<LigneCommande> selectLigneCommandeById(int idLigneCommande);

}
