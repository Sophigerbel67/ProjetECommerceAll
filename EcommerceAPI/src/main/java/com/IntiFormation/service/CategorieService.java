package com.IntiFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IntiFormation.dao.IcategorieDao;
import com.IntiFormation.dao.IproduitDao;
import com.IntiFormation.entity.Categorie;
import com.IntiFormation.entity.Produit;

@Service
public class CategorieService implements ICategorieService{
	
	@Autowired
	IcategorieDao cDao;
	
	
	public void Ajouter(Categorie c)
	{
		cDao.save(c);
	}
	
	public List<Categorie> cherchertt()
	{
		return cDao.findAll();
	}
	
	public Categorie chercherUn(int idCategorie)
	{
		return cDao.findById(idCategorie).get();
	}
	
	public void modifier(Categorie c)
	{
		cDao.save(c);
	}
	
	public void delete(int idCategorie)
	{
		cDao.deleteById(idCategorie);
	}


}


