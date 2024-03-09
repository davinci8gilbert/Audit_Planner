package com.example.audit_planner.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="previousAudit")
public class PreviousAudit {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "auditee_id")
	private Auditee auditee;
	
	@Column(name="auditPlanRiskRating")
	private String auditPlanRiskRating;
	
	@Column(name="dateOfAudit")
	private Date dateOfAudit;
	
	@Column(name="auditRating")
	private String auditRating;
	
	@Column(name="numberHighRiskIssues")
	private int numberHighRiskIssues;
	
	@Column(name="numberMediumRiskIssues")
	private int numberMediumRiskIssues;
	
	@Column(name="numberLowRiskIssues")
	private int numberLowRiskIssues;
	
	@Column(name="numberHighRiskIncidents")
	private int numberHighRiskIncidents;
	
	@Column(name="numberMediumRiskIncidents")
	private int numberMediumRiskIncidents;
	
	@Column(name="numberLowRiskIncidents")
	private int numberLowRiskIncidents;

	
	public PreviousAudit() {
		
	}
	
	public PreviousAudit(Auditee auditee, String auditPlanRiskRating,Date date,String auditRating,int numberHighRiskIssues,
			int numberMediumRiskIssues,int numberLowRiskIssues, int numberHighRiskIncidents,int numberMediumRiskIncidents,
			int numberLowRiskIncidents) {
		this.auditee = auditee;
		this.auditPlanRiskRating=auditPlanRiskRating;
		this.dateOfAudit=date;
		this.auditRating=auditRating;
		this.numberHighRiskIssues=numberHighRiskIssues;
		this.numberMediumRiskIssues=numberMediumRiskIssues;
		this.numberLowRiskIssues=numberLowRiskIssues;
		this.numberHighRiskIncidents=numberHighRiskIncidents;
		this.numberMediumRiskIncidents=numberMediumRiskIncidents;
		this.numberLowRiskIncidents=numberLowRiskIncidents;
	}
	
	public PreviousAudit(String auditPlanRiskRating,Date date,String auditRating,int numberHighRiskIssues,
			int numberMediumRiskIssues,int numberLowRiskIssues, int numberHighRiskIncidents,int numberMediumRiskIncidents,
			int numberLowRiskIncidents) {
		this.auditPlanRiskRating=auditPlanRiskRating;
		this.dateOfAudit=date;
		this.auditRating=auditRating;
		this.numberHighRiskIssues=numberHighRiskIssues;
		this.numberMediumRiskIssues=numberMediumRiskIssues;
		this.numberLowRiskIssues=numberLowRiskIssues;
		this.numberHighRiskIncidents=numberHighRiskIncidents;
		this.numberMediumRiskIncidents=numberMediumRiskIncidents;
		this.numberLowRiskIncidents=numberLowRiskIncidents;
	}
	
	
			
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Auditee getAuditee() {
		return auditee;
	}

	public void setAuditee(Auditee auditee) {
		this.auditee = auditee;
	}

	public String getAuditPlanRiskRating() {
		return auditPlanRiskRating;
	}

	public void setAuditPlanRiskRating(String auditPlanRiskRating) {
		this.auditPlanRiskRating = auditPlanRiskRating;
	}

	public Date getDateOfAudit() {
		return dateOfAudit;
	}

	public void setDateOfAudit(Date dateOfAudit) {
		this.dateOfAudit = dateOfAudit;
	}

	public String getAuditRating() {
		return auditRating;
	}

	public void setAuditRating(String auditRating) {
		this.auditRating = auditRating;
	}

	public int getNumberHighRiskIssues() {
		return numberHighRiskIssues;
	}

	public void setNumberHighRiskIssues(int numberHighRiskIssues) {
		this.numberHighRiskIssues = numberHighRiskIssues;
	}

	public int getNumberMediumRiskIssues() {
		return numberMediumRiskIssues;
	}

	public void setNumberMediumRiskIssues(int numberMediumRiskIssues) {
		this.numberMediumRiskIssues = numberMediumRiskIssues;
	}

	public int getNumberLowRiskIssues() {
		return numberLowRiskIssues;
	}

	public void setNumberLowRiskIssues(int numberLowRiskIssues) {
		this.numberLowRiskIssues = numberLowRiskIssues;
	}

	public int getNumberHighRiskIncidents() {
		return numberHighRiskIncidents;
	}

	public void setNumberHighRiskIncidents(int numberHighRiskIncidents) {
		this.numberHighRiskIncidents = numberHighRiskIncidents;
	}

	public int getNumberMediumRiskIncidents() {
		return numberMediumRiskIncidents;
	}

	public void setNumberMediumRiskIncidents(int numberMediumRiskIncidents) {
		this.numberMediumRiskIncidents = numberMediumRiskIncidents;
	}

	public int getNumberLowRiskIncidents() {
		return numberLowRiskIncidents;
	}

	public void setNumberLowRiskIncidents(int numberLowRiskIncidents) {
		this.numberLowRiskIncidents = numberLowRiskIncidents;
	}
	
	@Override
    public String toString() {
        return "PreviousAudit{" +
                "id=" + id +
                ", auditee=" + auditee +
                ", auditPlanRiskRating='" + auditPlanRiskRating + '\'' +
                ", dateOfAudit=" + dateOfAudit +
                ", auditRating='" + auditRating + '\'' +
                ", numberHighRiskIssues=" + numberHighRiskIssues +
                ", numberMediumRiskIssues=" + numberMediumRiskIssues +
                ", numberLowRiskIssues=" + numberLowRiskIssues +
                ", numberHighRiskIncidents=" + numberHighRiskIncidents +
                ", numberMediumRiskIncidents=" + numberMediumRiskIncidents +
                ", numberLowRiskIncidents=" + numberLowRiskIncidents +
                '}';
    }
	
	
	
	
}
