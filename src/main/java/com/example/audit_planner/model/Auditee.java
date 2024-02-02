package com.example.audit_planner.model;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "auditee")
public class Auditee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="unit")
	private String unit;
	
	@Column(name="sector")
	private String sector;
	
	@OneToOne(mappedBy = "auditee", cascade = CascadeType.ALL)
	@JsonIgnore 
	private PreviousAudit previousAudit;
	
	@OneToMany(mappedBy = "auditee",cascade = CascadeType.ALL )
	@JsonIgnore
	private Set<AssessmentScore> assessmentScores =new HashSet<>();
	
	
	public Auditee() {
		
	}
	
	public Auditee(String unit, String sector) {
		this.unit = unit;
		this.sector = sector;
	}
	
	public void addPreviousAudit(PreviousAudit previousAudit) {
		previousAudit.setAuditee(this);
	}
	
	public void addAssessmentScore(AssessmentScore assessmentScore) {
		this.assessmentScores.add(assessmentScore);
		assessmentScore.setAuditee(this);
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	
	@Override
    public String toString() {
        return "Auditee{" +
                "id=" + id +
                ", unit='" + unit + '\'' +
                ", sector='" + sector + '\'' +
                // add other fields as needed
                '}';
    }
	
	
}
