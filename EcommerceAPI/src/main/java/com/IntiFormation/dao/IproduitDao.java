package com.IntiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.IntiFormation.entity.Categorie;
import com.IntiFormation.entity.Commande;
import com.IntiFormation.entity.Produit;

public interface IproduitDao extends JpaRepository<Produit, Integer>{

	public List<Produit> findByCategorie(Categorie categorie);
	
	public Produit findByLibProduit(String libProduit);
	
	//Methode produitsAss
	@Query("select p from Produit p join p.categorie c where c.idCategorie=:n")
	public List<Produit> produitsAss(@Param("n") int idCate);	
	



}
