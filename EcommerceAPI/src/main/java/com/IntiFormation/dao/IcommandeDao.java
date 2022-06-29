package com.IntiFormation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IntiFormation.entity.Commande;
import com.IntiFormation.entity.Produit;


public interface IcommandeDao extends JpaRepository<Commande, Integer> {


}
