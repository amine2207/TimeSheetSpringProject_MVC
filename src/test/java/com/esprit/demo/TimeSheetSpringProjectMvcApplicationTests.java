package com.esprit.demo;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.demo.entity.Contrat;
import com.esprit.demo.entity.Departement;
import com.esprit.demo.entity.Employe;
import com.esprit.demo.entity.Entreprise;
import com.esprit.demo.entity.Role;
import com.esprit.demo.services.IEmployeService;
import com.esprit.demo.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeSheetSpringProjectMvcApplicationTests {

	@Autowired
	IEntrepriseService ies;
	
	@Autowired
	IEmployeService iems;
	
	@Test
	public void contextLoads() {
		
		Entreprise entreprise = new Entreprise("chez SSI ","Ghazela");
	   
		ies.ajouterEntreprise(entreprise);
		
		Departement departement = new Departement("Telecom",entreprise);
		
		Departement departement1= new Departement("RH",entreprise);
		
		ies.ajouterDepartement(departement);
		
		ies.ajouterDepartement(departement1);
		
		ies.affecterDepartementAEntreprise(departement.getId().intValue(), entreprise.getId().intValue());
		
		ies.affecterDepartementAEntreprise(departement1.getId().intValue(), entreprise.getId().intValue());
				
		ies.getAllDepartementsNamesByEntreprise(entreprise.getId().intValue());
		
		Employe employe = new Employe("Yosra","Arbi","Yosra.arbi@ssiiconsulting.tn",1,Role.chefDartement);
	
		iems.ajouterEmploye(employe);
				
		Contrat contrat = new Contrat(new Date(), "CDI", 2600,
						  	new Employe("Yosra","Arbi","Yosra.arbi@ssiiconsulting.tn",1,Role.chefDartement));
		iems.ajouterContrat(contrat);
		
		iems.affecterContratAEmploye((int) contrat.getReference(), employe.getId().intValue());
		
		
		iems.affecterEmployeADepartement(employe.getId().intValue(), departement.getId().intValue());
		
	    iems.getEmployePrenomById(employe.getId().intValue());  
		
		iems.getAllEmployeNamesJPQL();
		
		iems.getNombreEmployeJPQL();
		
	}
	
	

}
