package com.example.audit_planner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="resourceallocation")
public class ResourceAllocation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@JoinColumn(name="auditee_id")
	Auditee auditee;
	
	@Column(name="equalAllocation")
	double equalAllocation;
	
	@Column(name="adjustedManhours")
	double adjustedManhours;
	
	@Column(name="benchmarkResult")
	String benchmarkResult;
	
	@Column (name="auditStatus")
	String auditStatus;
	
	@Column (name="manhourAdjustment")
	double manhourAdjustment;
	
	@Column (name="overrideReason")
	String overrideReason;
	
	int dummyAuditeeId;
	
	public ResourceAllocation() {
		
	}
	
	//this constructor will input the values into equalAllocation column of a specific auditee after triggered at the front-end.
	public ResourceAllocation(Auditee auditee, double equalAllocation) {
		this.auditee = auditee;
		this.equalAllocation = equalAllocation;
		
		
	}
	
	public ResourceAllocation(double equalAllocation) {
		this.equalAllocation = equalAllocation;
		
		
	}
	
				
	public ResourceAllocation(int dummyAuditeeId,double equalAllocation) {
		this.dummyAuditeeId = dummyAuditeeId;
		this.equalAllocation = equalAllocation;
		
	}

	public ResourceAllocation(Auditee auditee) {
		this.auditee = auditee;
	}
	
	public ResourceAllocation(Auditee auditee, String benchmarkResult) {
		super();
		this.auditee = auditee;
		this.benchmarkResult = benchmarkResult;
	}
	
	
	public ResourceAllocation(Auditee auditee, String benchmarkResult, String auditStatus) {
		super();
		this.auditee = auditee;
		this.benchmarkResult = benchmarkResult;
		this.auditStatus = auditStatus;
	}

	public ResourceAllocation(double equalAllocation, double adjustedManhours, double manhourAdjustment) {
		this.equalAllocation = equalAllocation;
		this.adjustedManhours = adjustedManhours;
		this.manhourAdjustment = manhourAdjustment;
	}
	
	public ResourceAllocation(double equalAllocation, double adjustedManhours, String auditStatus,
			double manhourAdjustment) {
		super(); 
		this.equalAllocation = equalAllocation;
		this.adjustedManhours = adjustedManhours;
		this.auditStatus = auditStatus;
		this.manhourAdjustment = manhourAdjustment;
		
	}

	public ResourceAllocation(double equalAllocation, double adjustedManhours, String auditStatus,
			double manhourAdjustment, String overrideReason) {
		super(); 
		this.equalAllocation = equalAllocation;
		this.adjustedManhours = adjustedManhours;
		this.auditStatus = auditStatus;
		this.manhourAdjustment = manhourAdjustment;
		this.overrideReason = overrideReason;
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

	public double getEqualAllocation() {
		return equalAllocation;
	}

	public void setEqualAllocation(double equalAllocation) {
		this.equalAllocation = equalAllocation;
	}

	public double getAdjustedManhours() {
		return adjustedManhours;
	}

	public void setAdjustedManhours(double adjustedManhours) {
		this.adjustedManhours = adjustedManhours;
	}
	
	public int getDummyAuditeeId() {
		return dummyAuditeeId;
	}

	public void setDummyAuditeeId(int dummyAuditeeId) {
		this.dummyAuditeeId = dummyAuditeeId;
	}

	public String getBenchmarkResult() {
		return benchmarkResult;
	}

	public void setBenchmarkResult(String benchmarkResult) {
		this.benchmarkResult = benchmarkResult;
	}

	public String getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}

	public double getManhourAdjustment() {
		return manhourAdjustment;
	}

	public void setManhourAdjustment(double manhourAdjustment) {
		this.manhourAdjustment = manhourAdjustment;
	}

	public String getOverrideReason() {
		return overrideReason;
	}

	public void setOverrideReason(String overrideReason) {
		this.overrideReason = overrideReason;
	}
	
	
	
}
