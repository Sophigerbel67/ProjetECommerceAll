package com.IntiFormation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


public class Panier {
	
	//Attributs

	private int idPanier;
	
	private List<LignePanier> lignePaniers= new ArrayList<>();
	

	//Getters et setters
	public int getIdPanier() 
	{
		return idPanier;
	}

	public void setIdPanier(int idPanier) 
	{
		this.idPanier = idPanier;
	}

	public List<LignePanier> getLignePaniers() 
	{
		return lignePaniers;
	}

	public void setLignePaniers(List<LignePanier> lignePaniers) 
	{
		this.lignePaniers = lignePaniers;
	}

	
	public Panier(int idPanier) 
	{
			
	}
	
	
	

}
