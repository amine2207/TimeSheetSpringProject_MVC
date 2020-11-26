package com.esprit.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.demo.control.EntrepriseControl;
import com.esprit.demo.entity.Contrat;
import com.esprit.demo.entity.Departement;
import com.esprit.demo.entity.Employe;
import com.esprit.demo.repository.ContratRepository;
import com.esprit.demo.repository.DepartementRepository;
import com.esprit.demo.repository.EmployeDepartementRepository;
import com.esprit.demo.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	private static final Logger l =  LogManager.getLogger(EntrepriseControl.class);

	@Autowired
	EmployeRepository er;
	
	@Autowired
	ContratRepository cr;
	
	@Autowired
	DepartementRepository dr;
	
	@Autowired
	EmployeDepartementRepository edr;
	
	@Override
	public int ajouterEmploye(Employe employe) {
		
		er.save(employe);
		int id = employe.getId().intValue();
		return id;
	}

	@Override
	public void affecterEmployeADepartement(int employeId, int depId) {
		
		Employe e = er.findById((long)employeId).get();
		Departement d = dr.findById((long)depId).get();
		if(d.getEmploye()==null){
		List<Employe>employes= new ArrayList<>();
		employes.add(e);
		d.setEmploye((Set<Employe>) employes);
		}else{
			d.getEmploye().add(e);
		}
		edr.save(d);
	}

	@Override
	public int ajouterContrat(Contrat contrat) {
		cr.save(contrat);
		int id = (int) contrat.getReference();
		return id;
	}

	@Override
	public void affecterContratAEmploye(int contratId, int employeId) {
		
		Contrat c = cr.findById((long)contratId).get();
		Employe e = er.findById((long)employeId).get();
		
		e.setContrat(c);
		
	}

	@Override
	public String getEmployePrenomById(int employeId) {
		// TODO Auto-generated method stub
		 Employe e1 = er.findById((long) employeId).get();
		 l.info("Prenom bY id : "+e1.getPrenom());
		 return e1.getPrenom();	
	}

	@Override
	public long getNombreEmployeJPQL() {
		
		l.info("EMPLOYES NUMBER:"+er.getCount());
		return er.getCount();
	}

	@Override
	public List<String> getAllEmployeNamesJPQL() {
		List<Employe>list_employes = (List<Employe>) er.getByPrenomJPQL();
		List<String>string_employes= new ArrayList<>();
		for(Employe e : list_employes)
		{
			string_employes.add(e.getNom());
		}
		l.info("Employes Names : "+string_employes);
		return string_employes;
	}

}
