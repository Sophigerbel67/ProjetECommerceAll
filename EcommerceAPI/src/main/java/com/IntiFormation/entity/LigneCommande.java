package com.IntiFormation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LigneCommande {
	
//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLigneCommande;
	
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commande commande;
	
	@ManyToOne
	@JoinColumn(name="idProduit")
	private Produit produit;
	
	private int quantite;
	
//Getters et setters
	public int getIdLigneCommande() 
	{
		return idLigneCommande;
	}
	
	public void setIdLigneCommande(int idLigneCommande) 
	{
		this.idLigneCommande = idLigneCommande;
	}
	
	public Commande getCommande() 
	{
		return commande;
	}
	
	public void setCommande(Commande commande) 
	{
		this.commande = commande;
	}
	
	public Produit getProduit() 
	{
		return produit;
	}
	
	public void setProduit(Produit produit) 
	{
		this.produit = produit;
	}
	
	public int getQuantite() 
	{
		return quantite;
	}
	
	public void setQuantite(int quantite) 
	{
		this.quantite = quantite;
	}

	public LigneCommande(Commande commande, Produit produit, int quantite) 
	{
		super();
		this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
	}

	public LigneCommande()
	{
		
	}
	
	

}
