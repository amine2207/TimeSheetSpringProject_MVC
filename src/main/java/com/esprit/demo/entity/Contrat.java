package com.esprit.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_CONTRAT")
public class Contrat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="T_REFERENCE")
	private long reference;

	@Temporal(TemporalType.DATE)
	@Column(name="T_DATE_DEBUT")
	private Date dateDebut;
	
	@Column(name="T_TYPE_CONTRAT")
	private String typeContrat;
	
	@Column(name="T_SALAIRE")
	private double salaire;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="FK_EMPLOYE")
	private Employe employe;
	
	public Contrat(Date dateDebut, String typeContrat, double salaire) {
		super();
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
	}
	
	

	
	public Contrat(Date dateDebut, String typeContrat, double salaire, Employe employe) {
		super();
		this.dateDebut = dateDebut;
		this.typeContrat = typeContrat;
		this.salaire = salaire;
		this.employe = employe;
	}




	public Contrat() {
		super();
	}


	public long getReference() {
		return reference;
	}

	public void setReference(long reference) {
		this.reference = reference;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Contrat [reference=" + reference + ", dateDebut=" + dateDebut + ", typeContrat=" + typeContrat
				+ ", salaire=" + salaire + "]";
	}
	
	
}
