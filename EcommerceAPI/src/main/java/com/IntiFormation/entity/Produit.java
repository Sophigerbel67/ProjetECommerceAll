package com.IntiFormation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produit {
	
//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduit;	
	private String libProduit;
	private String img;
	private int quantite;
	
	@ManyToOne
	@JoinColumn(name="idCate")
	@JsonIgnore
	private Categorie categorie;
	
	//@OneToMany(mapppedBy="produit")
	//private List<LigneCommande> lignecommande;
	
	//@OneToOne
	//private LignePanier lignepanier;
	

//Getters et setters		
	public int getIdProduit() 
	{
		return idProduit;
	}

	public void setIdProduit(int idProduit) 
	{
		this.idProduit = idProduit;
	}

	public String getLibProduit() 
	{
		return libProduit;
	}

	public void setLibProduit(String libProduit) 
	{
		this.libProduit = libProduit;
	}

	public String getImg() 
	{
		return img;
	}

	public void setImg(String img) 
	{
		this.img = img;
	}

	public int getQuantite() 
	{
		return quantite;
	}

	public void setQuantite(int quantite) 
	{
		this.quantite = quantite;
	}

	public Categorie getCategorie() 
	{
		return categorie;
	}

	public void setCategorie(Categorie categorie) 
	{
		this.categorie = categorie;
	}

//Constructeurs
	public Produit() 
	{
		super();
	}

	public Produit(String libProduit, String img, int quantite, Categorie categorie) 
	{
		super();
		this.libProduit = libProduit;
		this.img = img;
		this.quantite = quantite;
		this.categorie = categorie;
	}

//Methode toString
	@Override
	public String toString() 
	{
		return "Produit [idProduit=" + idProduit + ", libProduit=" + libProduit + ", img=" + img + ", quantite="
				+ quantite + ", categorie=" + categorie + "]";
	}
	

	
	
	
	
	
	

}
