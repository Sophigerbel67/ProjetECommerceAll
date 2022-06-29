package com.IntiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categorie {
	
//Attributs
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idCategorie;		
		private String nomCategorie;		
		private String description;
		
		
		@OneToMany(mappedBy="categorie")
		private List<Produit> produits;

//Getters et setters
		public int getIdCategorie() 
		{
			return idCategorie;
		}

		public void setIdCategorie(int idCategorie) 
		{
			this.idCategorie = idCategorie;
		}

		public String getNomCategorie() 
		{
			return nomCategorie;
		}

		public void setNomCategorie(String nomCategorie) 
		{
			this.nomCategorie = nomCategorie;
		}

		public String getDescription() 
		{
			return description;
		}

		public void setDescription(String description) 
		{
			this.description = description;
		}
			
		public List<Produit> getProduits() 
		{
			return produits;
		}

		public void setProduits(List<Produit> produits) 
		{
			this.produits = produits;
		}

//Constructeurs
		public Categorie() 
		{
			super();			
		}
				
		


		public Categorie(String nomCategorie, String description, List<Produit> produits) 
		{
			super();
			this.nomCategorie = nomCategorie;
			this.description = description;
			this.produits = produits;
		}

//Methode toString
@Override
		public String toString() 
		{
			return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", description="
					+ description + "]";
		}


		

}



