package com.esprit.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.demo.entity.Contrat;
import com.esprit.demo.entity.Employe;
import com.esprit.demo.services.IEmployeService;

@RestController
public class EmployeControl {

	@Autowired
	IEmployeService ies;
	
	
	@PostMapping("/ajouter_employe")
	@ResponseBody
	public int addEmployeControl(@RequestBody Employe employe)
	{
		return ies.ajouterEmploye(employe);
	}
	
	@PostMapping("/ajouter_contrat")
	@ResponseBody
	public int addContratControl(@RequestBody Contrat contrat)
	{
		return ies.ajouterContrat(contrat);
	}
	
	@PostMapping("/affecter_contrat_employe/{t_reference}/{id}")
	@ResponseBody
	public void affecterContratEmploye(@PathVariable("t_reference")int contratId , @PathVariable("id")int employeId)
	{
		ies.affecterContratAEmploye(contratId, employeId);
	}
	
	@PostMapping("/affecter_employe_departement/{id}/{id}")
	@ResponseBody
	public void affecterEmployeDepartementControl(@PathVariable("id")int employeId , @PathVariable("id")int depId)
	{
		ies.affecterEmployeADepartement(employeId, depId);
	}
	
}
