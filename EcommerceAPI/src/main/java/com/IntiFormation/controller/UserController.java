package com.IntiFormation.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import com.IntiFormation.dao.IUtilisateurDao;
import com.IntiFormation.entity.Categorie;
import com.IntiFormation.entity.Commande;
import com.IntiFormation.entity.LigneCommande;
import com.IntiFormation.entity.LignePanier;
import com.IntiFormation.entity.Panier;
import com.IntiFormation.entity.Produit;
import com.IntiFormation.entity.Role;
import com.IntiFormation.entity.Utilisateur;
import com.IntiFormation.service.ICategorieService;
import com.IntiFormation.service.ICommandeService;
import com.IntiFormation.service.ILigneCommandeService;
import com.IntiFormation.service.IProduitService;
import com.IntiFormation.service.IUtilisateurService;
import com.IntiFormation.service.IroleService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
//Attribut
	@Autowired
	IUtilisateurService uService;
	
	@Autowired
	IProduitService pService;
	
	@Autowired
	ICategorieService cService;

	@Autowired
	BCryptPasswordEncoder bc;
	
	@Autowired
	IroleService rService;
	
	@Autowired
	ICommandeService comService;
	
	@Autowired
	ILigneCommandeService lcService;
	
	
	//Methode inscription
	@PostMapping("/utilisateurs/{idRole}")
	public void inscription(@PathVariable("idRole") int idRole,
			@RequestBody Utilisateur u) 
	{
		//Role
		Role r=rService.chercherUn(idRole);
		u.setRole(r);
		
		//Password
		u.setPassword(bc.encode(u.getPassword()));
		uService.Ajouter(u);
	}
	
	
	//Methode findByName
	@GetMapping("/utilisateurs/{username}")
	public Utilisateur findByName(@PathVariable("username") String username)
	{
		Utilisateur u = uService.chercherParUsername(username);
				
		return u;
	}
	
	
	//Methode all
	@GetMapping("/afficherU")
	public List<Utilisateur> all(Model model)
	{
		
		List<Utilisateur> liste=uService.cherchertt();
		model.addAttribute("liste", liste);
	
	return liste;

	}
	
	

}