package com.IntiFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.IntiFormation.dao.IcategorieDao;
import com.IntiFormation.dao.IproduitDao;
import com.IntiFormation.entity.Categorie;
import com.IntiFormation.entity.Produit;
import com.IntiFormation.jwtConfig.AuthentificationRequest;
import com.IntiFormation.jwtConfig.AuthentificationResponse;
import com.IntiFormation.jwtConfig.jwtUtil;
import com.IntiFormation.service.CustemUserDetailService;
import com.IntiFormation.service.ICategorieService;
import com.IntiFormation.service.IProduitService;

@RestController
@RequestMapping("/GestionCategorie")
@CrossOrigin(origins="http://localhost:4200")
public class CategorieController {
	
	
	@Autowired
	ICategorieService cService;
	
	@Autowired
	IProduitService pService;

	//Methode afficher
	@GetMapping("/afficher")
	public List<Categorie> AfficherCategories(Model model)
	{
		
	List<Categorie> liste=cService.cherchertt();
	model.addAttribute("liste", liste);

	
	List<Produit> listeP=pService.cherchertt();
	model.addAttribute("listeP", listeP);
	
	return liste;
	
	
	}
	
	//Methode ajouter
	@PostMapping("/ajouterCategorie")
	public void ajouter(@RequestBody Categorie c)
	{
		cService.Ajouter(c);

	}

	//Methode supprimer
	@DeleteMapping("/SupprimerCategorie/{idCategorie}")
	public void supprimer(@PathVariable("idCategorie") int idCategorie)
	{
		cService.delete(idCategorie);

	}

	//Methode modifier
	@PutMapping("ModifierCategorie")
	public void modifier(@RequestBody Categorie c)
	{
		cService.Ajouter(c);
	}
	
	//Methode chercherUn
	@GetMapping("/Categorie/{idCategorie}")
	public Categorie chercherUn(@PathVariable("idCategorie") int idCategorie)
	{
		Categorie c = cService.chercherUn(idCategorie);
			
		return c;
	}

			 
	
}
