package com.IntiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IntiFormation.entity.Categorie;
import com.IntiFormation.entity.Commande;
import com.IntiFormation.entity.Produit;
import com.IntiFormation.service.ICategorieService;
import com.IntiFormation.service.ICommandeService;
import com.IntiFormation.service.IProduitService;

@RestController
@RequestMapping("/GestionCommande")
@CrossOrigin(origins="http://localhost:4200")
public class CommandeController {
	
	@Autowired
	ICommandeService comService;
	
	@Autowired
	ICategorieService cService;
	
	@Autowired
	IProduitService pService;
	
	//Methode afficher
	@GetMapping("/afficherCommande")
	public List<Commande> AfficherCommande(Model model)
	{		
		List<Categorie> listeC=cService.cherchertt();
		model.addAttribute("listeC", listeC);
		
		List<Produit> listeP=pService.cherchertt();
		model.addAttribute("listeP", listeP);
		
		List<Commande> liste=comService.cherchertt();
		model.addAttribute("liste", liste);
		
		return liste;
	
	}

	//Methode chercherUn
	@GetMapping("/Commande/{idCommande}")
	public Commande chercherUn(@PathVariable("idCommande") int idCommande)
	{
		Commande c = comService.chercherUn(idCommande);
			
		return c;
	}

	
}
