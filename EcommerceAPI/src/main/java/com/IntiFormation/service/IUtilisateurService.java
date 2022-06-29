package com.IntiFormation.service;

import java.util.List;

import com.IntiFormation.entity.Utilisateur;

public interface IUtilisateurService {
	
	public Utilisateur chercherParUsername(String username);
	public void Ajouter(Utilisateur u);
	public Utilisateur chercherUn(int id);
	public List<Utilisateur> cherchertt();

}
