package com.esprit.demo.services;

import java.util.List;

import com.esprit.demo.entity.Contrat;
import com.esprit.demo.entity.Employe;

public interface IEmployeService {

	public int ajouterEmploye(Employe employe);
	public void affecterEmployeADepartement(int employeId, int depId);
	public int ajouterContrat(Contrat contrat);
	public void affecterContratAEmploye(int contratId, int employeId);
	public String getEmployePrenomById(int employeId);
	public long getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();
}
