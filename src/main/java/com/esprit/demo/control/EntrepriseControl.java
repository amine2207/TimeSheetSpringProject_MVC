package com.esprit.demo.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.demo.entity.Departement;
import com.esprit.demo.entity.Entreprise;
import com.esprit.demo.services.IEntrepriseService;

@RestController
public class EntrepriseControl {

	@Autowired
	IEntrepriseService Ies;
	
	@PostMapping("/ajouter_entreprise")
	@ResponseBody
	public int addEntreprise(@RequestBody Entreprise entreprise)
	{
		return Ies.ajouterEntreprise(entreprise);
	}
	
	@PostMapping("/ajouter_departement")
	@ResponseBody
	public int addDepartement(@RequestBody Departement departement)
	{
		return Ies.ajouterDepartement(departement);
	}
	
	@PostMapping("/affecter_departement_entreprise/{depId}/{entrepriseId}")
	@ResponseBody
	public void affecterDepartementAEntreprise(@PathVariable("depId")int depId, @PathVariable("entrepriseId")int entrepriseId)
	{
		Ies.affecterDepartementAEntreprise(depId, entrepriseId);
	}
	
	@GetMapping("/departementsByname/{entreprise_id}")
	@ResponseBody
	public List<String> getByName(@PathVariable("entreprise_id")int entrepriseId)
	{
		List<String> list = Ies.getAllDepartementsNamesByEntreprise(entrepriseId);
		return list;
	}
	
	
}
