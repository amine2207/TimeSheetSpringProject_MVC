package com.esprit.demo.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_TimeSheet")
public class TimeSheet implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TimeSheetPK ts_pk;
	
	@ManyToOne
	@JoinColumn(name="id", referencedColumnName="id", insertable=false , updatable=false)
	private Employe employe;
	
	@ManyToOne
	@JoinColumn(name="id", referencedColumnName="id", insertable=false , updatable=false)
	private Mission mission;

	public boolean isValid;

	public TimeSheetPK getTs_pk() {
		return ts_pk;
	}

	public void setTs_pk(TimeSheetPK ts_pk) {
		this.ts_pk = ts_pk;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	@Override
	public String toString() {
		return "TimeSheet [ts_pk=" + ts_pk + ", employe=" + employe + ", mission=" + mission + ", isValid=" + isValid
				+ "]";
	}
	
	
}
