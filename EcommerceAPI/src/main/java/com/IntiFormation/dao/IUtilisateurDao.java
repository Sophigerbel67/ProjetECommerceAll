package com.IntiFormation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IntiFormation.entity.Utilisateur;

public interface IUtilisateurDao extends JpaRepository<Utilisateur, Integer>{
	
	public Utilisateur findByUsername(String username); //ajout methode chercher utilisateur par username
	
	
	
	
	

}
