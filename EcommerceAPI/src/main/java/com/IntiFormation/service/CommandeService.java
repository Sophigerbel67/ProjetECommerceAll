package com.IntiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IntiFormation.dao.IcommandeDao;
import com.IntiFormation.entity.Categorie;
import com.IntiFormation.entity.Commande;
import com.IntiFormation.entity.Produit;

@Service
public class CommandeService implements ICommandeService{
	
	@Autowired
	IcommandeDao comDao;
	
	public List<Commande> cherchertt()
	{
		return comDao.findAll();
	}
	
	public void Ajouter(Commande c)
	{
		comDao.save(c);
	}
	
	
	public Commande chercherUn(int idCommande)
	{
		return comDao.findById(idCommande).get();
	}
}
