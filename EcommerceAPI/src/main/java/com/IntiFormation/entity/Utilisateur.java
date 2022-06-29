package com.IntiFormation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utilisateur {
	
//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String username;
	private String password;
	private String mail;
	
	@ManyToOne
	@JoinColumn(name="idRole")
	private Role role;
	
	//@OneToMany(mappedBy="user")
	//@JsonIgnore
	//private List<Commande> commandes;
	
//Getters et setters	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getNom() 
	{
		return nom;
	}
	
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	public String getPrenom() 
	{
		return prenom;
	}
	
	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public Role getRole() 
	{
		return role;
	}

	public void setRole(Role role) 
	{
		this.role = role;
	}
	
	
public String getMail() 
{
		return mail;
	}

	public void setMail(String mail) 
	{
		this.mail = mail;
	}

	//Constructeurs
	public Utilisateur() 
	{
		super();		
	}
	
	public Utilisateur(String nom, String prenom, String username, String password, String mail) 
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
		this.mail=mail;
	}


	public Utilisateur(String nom2, String prenom2,String username2, String password2, Role role2)
	{
		super();
		this.nom = nom2;
		this.prenom = prenom2;
		this.username = username2;
		this.password = password2;
		this.role = role2;
	}



}
