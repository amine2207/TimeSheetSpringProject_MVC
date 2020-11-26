package com.esprit.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class TimeSheetPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id_mission ;
	
	private long id_employe;
	
	@Temporal(TemporalType.DATE)
	private Date date_debut;
	
	@Temporal(TemporalType.DATE)
	private Date date_fin;

	public TimeSheetPK() {
		super();
	}

	public TimeSheetPK(long id_mission, long id_employe, Date date_debut, Date date_fin) {
		super();
		this.id_mission = id_mission;
		this.id_employe = id_employe;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}

	public TimeSheetPK(Date date_debut, Date date_fin) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}

	public long getId_mission() {
		return id_mission;
	}

	public void setId_mission(long id_mission) {
		this.id_mission = id_mission;
	}

	public long getId_employe() {
		return id_employe;
	}

	public void setId_employe(long id_employe) {
		this.id_employe = id_employe;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TimeSheetPK [id_mission=" + id_mission + ", id_employe=" + id_employe + ", date_debut=" + date_debut
				+ ", date_fin=" + date_fin + "]";
	}

	
	
}
