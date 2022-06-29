package com.IntiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IntiFormation.dao.IUtilisateurDao;
import com.IntiFormation.entity.Categorie;
import com.IntiFormation.entity.Produit;
import com.IntiFormation.entity.Utilisateur;

@Service
public class UtilisateurService implements IUtilisateurService{
	
	@Autowired
	IUtilisateurDao utilisateurDao;
	
	public Utilisateur chercherParUsername(String username)
	{
		return utilisateurDao.findByUsername(username);
	}

	
	public void Ajouter(Utilisateur u)
	{
		utilisateurDao.save(u);
	}
	
	public Utilisateur chercherUn(int id)
	{
		return utilisateurDao.findById(id).get();
	}
	
	
	public List<Utilisateur> cherchertt()
	{
		return utilisateurDao.findAll();
	}
	
	
}
