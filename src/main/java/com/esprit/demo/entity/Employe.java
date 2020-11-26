package com.esprit.demo.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_EMPLOYE")
public class Employe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column(name="T_PRENOM")
	private String prenom;
	@Column(name="T_NOM")
	private String nom;
	@Column(name="T_EMAIL")
	private String email;
	@Column(name="T_IS_ACTIF")
	private int isActif;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToOne(mappedBy="employe")
	private Contrat contrat;
	
	
	@ManyToMany(mappedBy="employe", cascade = CascadeType.ALL )
	private Set<Departement> departements;

	//@ManyToMany(cascade = CascadeType.ALL, mappedBy="employes" )
	//private Set<Mission> missions;
	
	@OneToMany(mappedBy="employe")
	private List<TimeSheet>liste_timesheet;
	

	
	public Employe(String prenom, String nom, String email, int isActif, Role role) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.isActif = isActif;
		this.role = role;
	}

	public Employe(Long id, String prenom, String nom, String email, int isActif, Role role, Contrat contrat) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.isActif = isActif;
		this.role = role;
		this.contrat = contrat;

		//this.departements = departements;
	}

	public Employe() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsActif() {
		return isActif;
	}

	public void setIsActif(int isActif) {
		this.isActif = isActif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	
	public List<TimeSheet> getListe_timesheet() {
		return liste_timesheet;
	}

	public void setListe_timesheet(List<TimeSheet> liste_timesheet) {
		this.liste_timesheet = liste_timesheet;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", isActif=" + isActif
				+ ", role=" + role + ", contrat=" + contrat + "]";
	}



	/*public Set<Departement> getDepartements() {
		return departements;
	}
*/
/*	public void setDepartements(Set<Departement> departements) {
		this.departements = departements;
	}*/

   
	
	
}
