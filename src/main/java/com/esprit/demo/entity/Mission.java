package com.esprit.demo.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_mission")
public abstract class Mission implements Serializable{

	
	 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="name_m")
	private String name;
	
	@Column(name="desc_m")
	private String description;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Departement departement;

	//@ManyToMany(cascade = CascadeType.ALL )
	//private Set<Employe> employes;
	
	@OneToMany(mappedBy="mission")
	private List<TimeSheet>liste_timesheet;
	

	public Mission(Long id, String name, String description, Departement departement) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.departement = departement;
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}


	
	public List<TimeSheet> getListe_timesheet() {
		return liste_timesheet;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departement == null) ? 0 : departement.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((liste_timesheet == null) ? 0 : liste_timesheet.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mission other = (Mission) obj;
		if (departement == null) {
			if (other.departement != null)
				return false;
		} else if (!departement.equals(other.departement))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (liste_timesheet == null) {
			if (other.liste_timesheet != null)
				return false;
		} else if (!liste_timesheet.equals(other.liste_timesheet))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	public void setListe_timesheet(List<TimeSheet> liste_timesheet) {
		this.liste_timesheet = liste_timesheet;
	}


	@Override
	public String toString() {
		return "Mission [id=" + id + ", name=" + name + ", description=" + description + ", departement=" + departement
				+ "]";
	}
	
	

}
