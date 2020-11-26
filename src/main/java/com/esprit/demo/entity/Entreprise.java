package com.esprit.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_entreprise")
public class Entreprise implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	private Long id ;
	
	@Column(name="name_ent")
	private String name;
	
	@Column(name="raison_social_ent")
	private String raisonSocial;
	
	@OneToMany(fetch= FetchType.EAGER, mappedBy="entreprise")
	private Set<Departement> departements;

	public Entreprise(Long id, String name, String raisonSocial, Set<Departement> departements) {
		super();
		this.id = id;
		this.name = name;
		this.raisonSocial = raisonSocial;
		this.departements = departements;
	}

	public Entreprise() {
		super();
	}

	

	public Entreprise(String name, String raisonSocial) {
		super();
		this.name = name;
		this.raisonSocial = raisonSocial;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRaisonSocial() {
		return raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	public Set<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(Set<Departement> departements) {
		this.departements = departements;
	}

	@Override
	public String toString() {
		return "Entreprise [id=" + id + ", name=" + name + ", raisonSocial=" + raisonSocial + ", departements="
				+ departements + "]";
	}
	
	
}
