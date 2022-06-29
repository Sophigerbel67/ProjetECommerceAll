package com.IntiFormation.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class LignePanier {
	
//Attributs

	private int idLignePanier;
	
	private static int idTemporaire=0;
	
	
	private Panier panier;
	private Produit produit;
	private int quantite;
	
//Getters et setters
	public int getIdLignePanier() 
	{
		return idLignePanier;
	}
	
	public void setIdLignePanier(int idLignePanier) 
	{
		this.idLignePanier = idLignePanier;
	}
	
	public Panier getPanier() 
	{
		return panier;
	}
	
	public void setPanier(Panier panier) 
	{
		this.panier = panier;
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

	@Override
	public String toString() 
	{
		return "LignePanier [idLignePanier=" + idLignePanier + ", panier=" + panier + ", produit=" + produit
				+ ", quantite=" + quantite + "]";
	}

	public LignePanier(Panier panier, Produit produit, int quantite) 
	{
		super();
		this.panier = panier;
		this.produit = produit;
		this.quantite = quantite;
		idTemporaire++;
		this.idLignePanier=idTemporaire;
	}

	public LignePanier() 
	{
		super();
		idTemporaire++;
		this.idLignePanier=idTemporaire;
		
	}



}

