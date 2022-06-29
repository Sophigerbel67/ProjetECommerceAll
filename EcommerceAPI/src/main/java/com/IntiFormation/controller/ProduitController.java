package com.IntiFormation.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.IntiFormation.dao.IproduitDao;
import com.IntiFormation.entity.Categorie;
import com.IntiFormation.entity.Commande;
import com.IntiFormation.entity.LigneCommande;
import com.IntiFormation.entity.Produit;
import com.IntiFormation.service.ICategorieService;
import com.IntiFormation.service.ICommandeService;
import com.IntiFormation.service.ILigneCommandeService;
import com.IntiFormation.service.IProduitService;

@RestController
@RequestMapping("/GestionProduit")
@CrossOrigin(origins="http://localhost:4200")
public class ProduitController {
	
	
	@Autowired
	IProduitService pService;
	
	@Autowired
	ICategorieService cService;
	
	@Autowired
	ICommandeService comService;
	
	@Autowired
	ILigneCommandeService lcService;
	
	//Methode afficher
	@GetMapping("/afficherP")
	public List<Produit> AfficherProduits(Model model)
	{
		
		List<Produit> liste=pService.cherchertt();
		model.addAttribute("liste", liste);
	
	return liste;

	}
	
	//Methode ajouter
	@PostMapping("/ajouterProduit")  
	public void ajouter( @RequestParam("file") MultipartFile file, HttpSession s,
			@RequestParam("libProduit") String libProduit,
			@RequestParam("quantite") int quantite,
			@RequestParam("idcategorie") int c) 
	{
		String filename= file.getOriginalFilename();
		String path=s.getServletContext().getRealPath("/")+"imageproduit\\"+filename;
		Produit p = new Produit();
		
		p.setImg("\\imageproduit\\"+filename);
		p.setLibProduit(libProduit);
		p.setQuantite(quantite);
		
		p.setCategorie(cService.chercherUn(c));
		pService.Ajouter(p);
		

		try{  
	        byte barr[]=file.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	          
	        }catch(Exception e)
			{
	        	e.printStackTrace();
			}
		

	}

	//Methode supprimer
		@DeleteMapping("/SupprimerCategorie/{idProduit}")
		public void supprimer(@PathVariable("idProduit") int idProduit)
		{
			pService.delete(idProduit);

		}
	
	//Methode modifier
	@PutMapping("ModifierProduit")
	public ResponseEntity<Object> modifier(@RequestParam("file") MultipartFile file, HttpSession s,
			@RequestParam("libProduit") String libProduit,
			@RequestParam("quantite") int quantite,
			@RequestParam("idcategorie") int c,
			@RequestParam("idProduit") int idP)
	{
		String filename= file.getOriginalFilename();
		String path=s.getServletContext().getRealPath("/")+"imageproduit\\"+filename;
		Produit p=pService.chercherUn(idP);
		
		p.setImg("\\imageproduit\\"+filename);
		p.setLibProduit(libProduit);
		p.setQuantite(quantite);
		p.setCategorie(cService.chercherUn(c));
		pService.Ajouter(p);
		

		try{  
	        byte barr[]=file.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close();  
	          
	        }catch(Exception e)
			{
	        	e.printStackTrace();
			}
		

		return new ResponseEntity<Object>("Ajout du produit reussi", 
				HttpStatus.OK);
	}

	//Methode chercherUn
	@GetMapping("/Produit/{idProduit}")
	public Produit chercherUn(@PathVariable("idProduit") int idProduit)
	{
		Produit p = pService.chercherUn(idProduit);
			
		return p;
	}
	
	
	//Methode produitsAss
		@GetMapping("/produitIdCat/{idCate}")
		public List<Produit> produitsAss(@PathVariable("idCate") int id)
		{
			List<Produit> liste = pService.produitsAss(id);
			return liste;
		}
	 
	 
	//Methode findByName
	@GetMapping("/produitName/{libProduit}")
	public Produit findByName(@PathVariable("libProduit") String libProduit)
	{
		Produit p = pService.getByName(libProduit);
				
		return p;
	}
		

	
}
