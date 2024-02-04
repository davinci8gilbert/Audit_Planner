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
	
	
}
