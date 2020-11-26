package com.esprit.demo.services;

import java.util.List;

import com.esprit.demo.entity.Departement;
import com.esprit.demo.entity.Entreprise;

public interface IEntrepriseService {
	
	 int ajouterEntreprise(Entreprise entreprise);
	 int ajouterDepartement(Departement dep);
	 void affecterDepartementAEntreprise(int depId, int entrepriseId);
	 List<String>getAllDepartementsNamesByEntreprise(int entrepriseId);

}
