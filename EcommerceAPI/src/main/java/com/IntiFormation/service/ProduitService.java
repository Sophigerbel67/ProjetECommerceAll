package com.IntiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IntiFormation.dao.IcategorieDao;
import com.IntiFormation.dao.IcommandeDao;
import com.IntiFormation.dao.IproduitDao;
import com.IntiFormation.entity.Categorie;
import com.IntiFormation.entity.Commande;
import com.IntiFormation.entity.Produit;

@Service
public class ProduitService implements IProduitService{
	
	@Autowired
	IproduitDao pDao;
	
	@Autowired
	IcategorieDao cDao;
	
	@Autowired
	IcommandeDao comDao;
	
	
	public void Ajouter(Produit p)
	{
		pDao.save(p);
	}
	
	public List<Produit> cherchertt()
	{
		return pDao.findAll();
	}
	
	public Produit chercherUn(int idProduit)
	{
		return pDao.findById(idProduit).get();
	}
	
	public void modifier(Produit p)
	{
		pDao.save(p);
	}
	
	public void delete(int idProduit)
	{
		pDao.deleteById(idProduit);
	}
	
	public List<Produit> getByCategorie (Categorie categorie)
	{
		List<Produit> liste= pDao.findByCategorie(categorie);
		return liste;
			
	}

	public Produit getByName (String libProduit)
	{
		Produit p= pDao.findByLibProduit(libProduit);
		return p;
			
	}
	
	public List<Produit> produitsAss(int idCate)
	{
		return pDao.produitsAss(idCate);
	}
	



}


