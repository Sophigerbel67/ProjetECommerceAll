package com.IntiFormation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.IntiFormation.dao.IligneCommande;
import com.IntiFormation.entity.Categorie;
import com.IntiFormation.entity.Commande;
import com.IntiFormation.entity.LigneCommande;
import com.IntiFormation.entity.Produit;
import com.IntiFormation.service.ICategorieService;
import com.IntiFormation.service.ICommandeService;
import com.IntiFormation.service.ILigneCommandeService;
import com.IntiFormation.service.IProduitService;

@RestController
@RequestMapping("/LigneCommande")
@CrossOrigin(origins="http://localhost:4200")
public class LigneCommandeController {
	

	@Autowired
	ILigneCommandeService lcService;
	
	/*//Methode ajouter
	@PostMapping("/ajouterLC")
	public void ajouter(@RequestBody LigneCommande lc)
	{
		lcService.Ajouter(lc);
	}
	
	//Methode ligneCommandeByIdCommande
	@GetMapping("/lcIdCommande/{id}")
	public List<LigneCommande> ligneCommandeByIdCommande(@PathVariable("id") int id)
	{
		List<LigneCommande> liste = lcService.findLigneCommandeByCommande_idCommande(id);
			
		return liste;
	}*/
	
}	
	
	
	

