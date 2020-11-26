package com.esprit.demo.services;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.demo.control.EntrepriseControl;
import com.esprit.demo.entity.Departement;
import com.esprit.demo.entity.Entreprise;
import com.esprit.demo.repository.DepartementRepository;
import com.esprit.demo.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService{

	private static final Logger l =  LogManager.getLogger(EntrepriseControl.class);

	
	@Autowired
	EntrepriseRepository er;

	@Autowired
	DepartementRepository dr;
	
	@Override
	public int ajouterEntreprise(Entreprise entreprise) {
		er.save(entreprise);
		int id = entreprise.getId().intValue();
		return id;
	}

	@Override
	public int ajouterDepartement(Departement dep) {
		dr.save(dep);
		int id = dep.getId().intValue();
		return id;
	}

	@Override
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		
		Entreprise e = er.findById((long)entrepriseId).get();
		Departement d = dr.findById((long) depId).get();

		d.setEntreprise(e);
	      	
	}

	@Override
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
	
	    Entreprise e = er.findById((long) entrepriseId).get();
		List<String>deps= new ArrayList<String>();
		
		for(Departement d: e.getDepartements())
		{
			deps.add(d.getName());		
		}
		l.info("Dep NAMES : "+deps);
		return deps;
	}
	
	

}
