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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	private int dummyAuditorId;
	
	
	@OneToOne(mappedBy = "auditee", cascade = CascadeType.ALL)
	@JsonIgnore 
	private PreviousAudit previousAudit;
	
	@OneToMany(mappedBy = "auditee",cascade = CascadeType.ALL )
	@JsonIgnore
	private Set<AssessmentScore> assessmentScores =new HashSet<>();
	
	@OneToOne(mappedBy="auditee",cascade=CascadeType.ALL)
	@JsonIgnore
	private AssessmentSummary assessmentSummary;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="auditor_id",nullable=false)
	private Auditor auditor;
	
	@OneToOne(mappedBy="auditee",cascade=CascadeType.ALL)
	@JsonIgnore
	private ResourceAllocation resourceAllocation;
	
	
	public Auditee() {
		
	}
	
	public Auditee(String unit, String sector) {
		this.unit = unit;
		this.sector = sector;
	}
	
		
	public Auditee(String unit, String sector, Auditor auditor) {
		this.unit = unit;
		this.sector = sector;
		this.auditor = auditor;
	}
	
	
	public Auditee(String unit, String sector, int dummyAuditorId) {
		super();
		this.unit = unit;
		this.sector = sector;
		this.dummyAuditorId = dummyAuditorId;
	}

//	public Auditee(long id, PreviousAudit previousAudit, Set<AssessmentScore> assessmentScores,
//			AssessmentSummary assessmentSummary, Auditor auditor) {
//		super();
//		this.id = id;
//		this.previousAudit = previousAudit;
//		this.assessmentScores = assessmentScores;
//		this.assessmentSummary = assessmentSummary;
//		this.auditor = auditor;
//	}

	public void addPreviousAudit(PreviousAudit previousAudit) {
		previousAudit.setAuditee(this);
	}
	
	
	public Auditor getAuditor() {
		return auditor;
	}

	public void setAuditor(Auditor auditor) {
		this.auditor = auditor;
	}

	public PreviousAudit getPreviousAudit() {
		return previousAudit;
	}

	public void setPreviousAudit(PreviousAudit previousAudit) {
		this.previousAudit = previousAudit;
	}

	public Set<AssessmentScore> getAssessmentScores() {
		return assessmentScores;
	}

	public void setAssessmentScores(Set<AssessmentScore> assessmentScores) {
		this.assessmentScores = assessmentScores;
	}

	public AssessmentSummary getAssessmentSummary() {
		return assessmentSummary;
	}

	public void setAssessmentSummary(AssessmentSummary assessmentSummary) {
		this.assessmentSummary = assessmentSummary;
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
	
	public int getDummyAuditorId() {
		return dummyAuditorId;
	}

	public void setDummyAuditorId(int dummyAuditorId) {
		this.dummyAuditorId = dummyAuditorId;
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
