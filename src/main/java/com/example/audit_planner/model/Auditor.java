package com.example.audit_planner.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="auditor")
public class Auditor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "teamName")
	private String teamName;
	
	@Column(name="auditorName")
	private String auditorName;
	
	@Column(name="role")
	private String role;
	
	@Column(name="password")
	private String password;
	
	@Column(name="headcount")
	private int headcount;
	
	@Column(name="numberOfWorkingDays")
	private double numberOfWorkingDays;
	
	@Column(name="numberOfDailyWorkHours")
	private double numberOfDailyWorkHours;
	
	@Column(name="totalWorkingHours")
	private double totalWorkingHours;
	
	@Column(name="annualLeaves")
	private double annualLeaves;
	
	@Column(name="maternityLeaves")
	private double maternityLeaves;
	
	@Column(name="annualPlanningActivities")
	private double annualPlanningActivities;
	
	@Column(name="continuousAudit")
	private double continuousAudit;
	
	@Column(name="administrativeActivities")
	private double administrativeActivities;
	
	@Column(name="contingencyBudget")
	private double contingencyBudget;
	
	@Column(name="totalAdjustment")
	private double totalAdjustment;
	
	@Column(name="availableHoursAudit")
	private double availableHoursAudit;
	
	@Column(name="actualAllocatedManhours")
	private double actualAllocatedManhours;
	
	@Column(name="excessShort")
	private double excessShort;
	
		
	@OneToMany(mappedBy="auditor",cascade=CascadeType.ALL)
	private Set<Auditee>auditees = new HashSet<>();
	
	
	public Auditor() {
		
	}
	
	public Auditor(String teamName,String auditorName,String role, String password, int headcount,double numberOfWorkingDays,
			double numberOfDailyWorkHours,double totalWorkingHours, double annualLeaves, double maternityLeaves,
			double annualPlanningActivities, double continuousAudit,double administrativeActivities,double contingencyBudget,
			double totalAdjustment,double availableHoursAudit,double actualAllocatedManhours,double excessShort) {
		
		this.teamName = teamName;
		this.auditorName=auditorName;
		this.role=role;
		this.password=password;
		this.headcount=headcount;
		this.numberOfWorkingDays=numberOfWorkingDays;
		this.numberOfDailyWorkHours=numberOfDailyWorkHours;
		this.totalWorkingHours=totalWorkingHours;
		this.annualLeaves=annualLeaves;
		this.maternityLeaves=maternityLeaves;
		this.annualPlanningActivities=annualPlanningActivities;
		this.continuousAudit=continuousAudit;
		this.administrativeActivities=administrativeActivities;
		this.contingencyBudget=contingencyBudget;
		this.totalAdjustment=totalAdjustment;
		this.availableHoursAudit=availableHoursAudit;
		this.actualAllocatedManhours=actualAllocatedManhours;
		this.excessShort=excessShort;
	}
	
	public Auditor(String teamName, String auditorName, String role) {
		this.teamName = teamName;
		this.auditorName=auditorName;
		this.role=role;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getAuditorName() {
		return auditorName;
	}
	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getHeadcount() {
		return headcount;
	}
	public void setHeadcount(int headcount) {
		this.headcount = headcount;
	}
	public double getNumberOfWorkingDays() {
		return numberOfWorkingDays;
	}
	public void setNumberOfWorkingDays(double numberOfWorkingDays) {
		this.numberOfWorkingDays = numberOfWorkingDays;
	}
	public double getNumberOfDailyWorkHours() {
		return numberOfDailyWorkHours;
	}
	public void setNumberOfDailyWorkHours(double numberOfDailyWorkHours) {
		this.numberOfDailyWorkHours = numberOfDailyWorkHours;
	}
	public double getTotalWorkingHours() {
		return totalWorkingHours;
	}
	public void setTotalWorkingHours(double totalWorkingHours) {
		this.totalWorkingHours = totalWorkingHours;
	}
	public double getAnnualLeaves() {
		return annualLeaves;
	}
	public void setAnnualLeaves(double annualLeaves) {
		this.annualLeaves = annualLeaves;
	}
	public double getMaternityLeaves() {
		return maternityLeaves;
	}
	public void setMaternityLeaves(double maternityLeaves) {
		this.maternityLeaves = maternityLeaves;
	}
	public double getAnnualPlanningActivities() {
		return annualPlanningActivities;
	}
	public void setAnnualPlanningActivities(double annualPlanningActivities) {
		this.annualPlanningActivities = annualPlanningActivities;
	}
	public double getContinuousAudit() {
		return continuousAudit;
	}
	public void setContinuousAudit(double continuousAudit) {
		this.continuousAudit = continuousAudit;
	}
	public double getAdministrativeActivities() {
		return administrativeActivities;
	}
	public void setAdministrativeActivities(double administrativeActivities) {
		this.administrativeActivities = administrativeActivities;
	}
	public double getContingencyBudget() {
		return contingencyBudget;
	}
	public void setContingencyBudget(double contingencyBudget) {
		this.contingencyBudget = contingencyBudget;
	}
	public double getTotalAdjustment() {
		return totalAdjustment;
	}
	public void setTotalAdjustment(double totalAdjustment) {
		this.totalAdjustment = totalAdjustment;
	}
	public double getAvailableHoursAudit() {
		return availableHoursAudit;
	}
	public void setAvailableHoursAudit(double availableHoursAudit) {
		this.availableHoursAudit = availableHoursAudit;
	}
	public double getActualAllocatedManhours() {
		return actualAllocatedManhours;
	}
	public void setActualAllocatedManhours(double actualAllocatedManhours) {
		this.actualAllocatedManhours = actualAllocatedManhours;
	}
	public double getExcessShort() {
		return excessShort;
	}
	public void setExcessShort(double excessShort) {
		this.excessShort = excessShort;
	}
	
	
	
}
