package com.IntiFormation.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Commande {
	
//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCommande;
	private LocalDate dateCommande;
	
	@ManyToOne
	@JoinColumn(name="idUtilisateur")
	private Utilisateur user;
	
	@OneToMany(mappedBy="commande")
	@JsonIgnore
	private List<LigneCommande> ligneCommandes;
	
//Getters et setters
	public int getIdCommande() 
	{
		return idCommande;
	}
	
	public void setIdCommande(int idCommande) 
	{
		this.idCommande = idCommande;
	}
	
	public LocalDate getDateCommande() 
	{
		return dateCommande;
	}
	
	public void setDateCommande(LocalDate dateCommande) 
	{
		this.dateCommande = dateCommande;
	}
	
	/*public Utilisateur getUser() 
	{
		return user;
	}
	
	public void setUser(Utilisateur user) 
	{
		this.user = user;
	}*/

	public List<LigneCommande> getLigneCommandes() 
	{
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) 
	{
		this.ligneCommandes = ligneCommandes;
	}

	public Commande() 
	{
		super();		
	}

	public Commande(LocalDate dateCommande) 
	{
		super();
		this.dateCommande = dateCommande;
	}


	
	
	
	
	

}

