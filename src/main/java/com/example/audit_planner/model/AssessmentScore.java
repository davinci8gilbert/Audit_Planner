package com.example.audit_planner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="assessmentscore")
public class AssessmentScore {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
//	@OneToOne
//	@JoinColumn(name = "auditee_id")
//	private Auditee auditee;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="auditee_id",nullable=false)
	private Auditee auditee;
	
	@Column(name="factorName")
	String factorName;
	
	@Column(name="factorWeight")
	double factorWeight;
	
	@Column(name="creditRiskLoanPortfolioRisk")
	int creditRiskLoanPortfolioRisk;
	
	@Column(name="creditRiskCounterpartyCreditRisk")
	int creditRiskCounterpartyCreditRisk;
	
	@Column(name="marketRiskInterestRateRisk")
	int marketRiskInterestRateRisk;
	
	@Column(name="maketRiskCommodityPriceRisk")
	int maketRiskCommodityPriceRisk;
	
	@Column(name="operationalRiskInternalProcessesRisk")
	int operationalRiskInternalProcessesRisk;
	
	@Column(name="operationalRiskFraudMisconductRisk")
	int operationalRiskFraudMisconductRisk;
	
	@Column(name="operationalRiskBusinessContinuityRisk")
	int operationalRiskBusinessContinuityRisk;
	
	@Column(name="liquidityRiskFundingLiquidityRisk")
	int liquidityRiskFundingLiquidityRisk;
	
	@Column(name="liquidityRiskContingencyFundingRisk")
	int liquidityRiskContingencyFundingRisk;
	
	@Column(name="complianceRisk")
	int complianceRisk;
	
	@Column(name="legalRisk")
	int legalRisk;
	
	@Column(name="strategyRiskBusinessModelRisk")
	int strategyRiskBusinessModelRisk;
	
	@Column(name="strategyRiskReputationalRisk")
	int strategyRiskReputationalRisk;
	
	@Column(name="cybersecurityRisk")
	int cybersecurityRisk;
	
	@Column(name="interestRateRisk")
	int interestRateRisk;
	
	@Column(name="amlFinancialCrimeRisk")
	int amlFinancialCrimeRisk;
	
	@Column(name="esgRisk")
	int esgRisk;
	
	@Column(name="conductRisk")
	int conductRisk;
	
	int dummyAuditeeId;
	
	public int getDummyAuditeeId() {
		return dummyAuditeeId;
	}


	public void setDummyAuditeeId(int dummyAuditeeId) {
		this.dummyAuditeeId = dummyAuditeeId;
	}


	public AssessmentScore() {
		
	}
	
		
	public AssessmentScore( int dummyAuditeeId,String factorName, double factorWeight, int creditRiskLoanPortfolioRisk,
			int creditRiskCounterpartyCreditRisk, int marketRiskInterestRateRisk, int maketRiskCommodityPriceRisk,
			int operationalRiskInternalProcessesRisk, int operationalRiskFraudMisconductRisk,
			int operationalRiskBusinessContinuityRisk, int liquidityRiskFundingLiquidityRisk,
			int liquidityRiskContingencyFundingRisk, int complianceRisk, int legalRisk,
			int strategyRiskBusinessModelRisk, int strategyRiskReputationalRisk, int cybersecurityRisk,
			int interestRateRisk, int amlFinancialCrimeRisk, int esgRisk, int conductRisk) {
		this.dummyAuditeeId = dummyAuditeeId;
		this.factorName = factorName;
		this.factorWeight = factorWeight;
		this.creditRiskLoanPortfolioRisk = creditRiskLoanPortfolioRisk;
		this.creditRiskCounterpartyCreditRisk = creditRiskCounterpartyCreditRisk;
		this.marketRiskInterestRateRisk = marketRiskInterestRateRisk;
		this.maketRiskCommodityPriceRisk = maketRiskCommodityPriceRisk;
		this.operationalRiskInternalProcessesRisk = operationalRiskInternalProcessesRisk;
		this.operationalRiskFraudMisconductRisk = operationalRiskFraudMisconductRisk;
		this.operationalRiskBusinessContinuityRisk = operationalRiskBusinessContinuityRisk;
		this.liquidityRiskFundingLiquidityRisk = liquidityRiskFundingLiquidityRisk;
		this.liquidityRiskContingencyFundingRisk = liquidityRiskContingencyFundingRisk;
		this.complianceRisk = complianceRisk;
		this.legalRisk = legalRisk;
		this.strategyRiskBusinessModelRisk = strategyRiskBusinessModelRisk;
		this.strategyRiskReputationalRisk = strategyRiskReputationalRisk;
		this.cybersecurityRisk = cybersecurityRisk;
		this.interestRateRisk = interestRateRisk;
		this.amlFinancialCrimeRisk = amlFinancialCrimeRisk;
		this.esgRisk = esgRisk;
		this.conductRisk = conductRisk;
		
	}


	public AssessmentScore(String factorName, double factorWeight) {
		this.factorName = factorName;
		this.factorWeight = factorWeight;
	}

	

	public AssessmentScore(Auditee auditee, String factorName, double factorWeight) {
		
		this.auditee = auditee;
		this.factorName = factorName;
		this.factorWeight = factorWeight;
	}


	public AssessmentScore(Auditee auditee, String factorName, double factorWeight, int creditRiskLoanPortfolioRisk,
			int creditRiskCounterpartyCreditRisk, int marketRiskInterestRateRisk, int maketRiskCommodityPriceRisk,
			int operationalRiskInternalProcessesRisk, int operationalRiskFraudMisconductRisk,
			int operationalRiskBusinessContinuityRisk, int liquidityRiskFundingLiquidityRisk,
			int liquidityRiskContingencyFundingRisk, int complianceRisk, int legalRisk,
			int strategyRiskBusinessModelRisk, int strategyRiskReputationalRisk, int cybersecurityRisk,
			int interestRateRisk, int amlFinancialCrimeRisk, int esgRisk, int conductRisk) {
		this.auditee = auditee;
		this.factorName = factorName;
		this.factorWeight = factorWeight;
		this.creditRiskLoanPortfolioRisk = creditRiskLoanPortfolioRisk;
		this.creditRiskCounterpartyCreditRisk = creditRiskCounterpartyCreditRisk;
		this.marketRiskInterestRateRisk = marketRiskInterestRateRisk;
		this.maketRiskCommodityPriceRisk = maketRiskCommodityPriceRisk;
		this.operationalRiskInternalProcessesRisk = operationalRiskInternalProcessesRisk;
		this.operationalRiskFraudMisconductRisk = operationalRiskFraudMisconductRisk;
		this.operationalRiskBusinessContinuityRisk = operationalRiskBusinessContinuityRisk;
		this.liquidityRiskFundingLiquidityRisk = liquidityRiskFundingLiquidityRisk;
		this.liquidityRiskContingencyFundingRisk = liquidityRiskContingencyFundingRisk;
		this.complianceRisk = complianceRisk;
		this.legalRisk = legalRisk;
		this.strategyRiskBusinessModelRisk = strategyRiskBusinessModelRisk;
		this.strategyRiskReputationalRisk = strategyRiskReputationalRisk;
		this.cybersecurityRisk = cybersecurityRisk;
		this.interestRateRisk = interestRateRisk;
		this.amlFinancialCrimeRisk = amlFinancialCrimeRisk;
		this.esgRisk = esgRisk;
		this.conductRisk = conductRisk;
	}
	
	
	public AssessmentScore(String factorName, double factorWeight, int creditRiskLoanPortfolioRisk,
			int creditRiskCounterpartyCreditRisk, int marketRiskInterestRateRisk, int maketRiskCommodityPriceRisk,
			int operationalRiskInternalProcessesRisk, int operationalRiskFraudMisconductRisk,
			int operationalRiskBusinessContinuityRisk, int liquidityRiskFundingLiquidityRisk,
			int liquidityRiskContingencyFundingRisk, int complianceRisk, int legalRisk,
			int strategyRiskBusinessModelRisk, int strategyRiskReputationalRisk, int cybersecurityRisk,
			int interestRateRisk, int amlFinancialCrimeRisk, int esgRisk, int conductRisk) {
		super();
		this.factorName = factorName;
		this.factorWeight = factorWeight;
		this.creditRiskLoanPortfolioRisk = creditRiskLoanPortfolioRisk;
		this.creditRiskCounterpartyCreditRisk = creditRiskCounterpartyCreditRisk;
		this.marketRiskInterestRateRisk = marketRiskInterestRateRisk;
		this.maketRiskCommodityPriceRisk = maketRiskCommodityPriceRisk;
		this.operationalRiskInternalProcessesRisk = operationalRiskInternalProcessesRisk;
		this.operationalRiskFraudMisconductRisk = operationalRiskFraudMisconductRisk;
		this.operationalRiskBusinessContinuityRisk = operationalRiskBusinessContinuityRisk;
		this.liquidityRiskFundingLiquidityRisk = liquidityRiskFundingLiquidityRisk;
		this.liquidityRiskContingencyFundingRisk = liquidityRiskContingencyFundingRisk;
		this.complianceRisk = complianceRisk;
		this.legalRisk = legalRisk;
		this.strategyRiskBusinessModelRisk = strategyRiskBusinessModelRisk;
		this.strategyRiskReputationalRisk = strategyRiskReputationalRisk;
		this.cybersecurityRisk = cybersecurityRisk;
		this.interestRateRisk = interestRateRisk;
		this.amlFinancialCrimeRisk = amlFinancialCrimeRisk;
		this.esgRisk = esgRisk;
		this.conductRisk = conductRisk;
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




	public String getFactorName() {
		return factorName;
	}




	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}




	public double getFactorWeight() {
		return factorWeight;
	}




	public void setFactorWeight(double factorWeight) {
		this.factorWeight = factorWeight;
	}




	public int getCreditRiskLoanPortfolioRisk() {
		return creditRiskLoanPortfolioRisk;
	}




	public void setCreditRiskLoanPortfolioRisk(int creditRiskLoanPortfolioRisk) {
		this.creditRiskLoanPortfolioRisk = creditRiskLoanPortfolioRisk;
	}




	public int getCreditRiskCounterpartyCreditRisk() {
		return creditRiskCounterpartyCreditRisk;
	}




	public void setCreditRiskCounterpartyCreditRisk(int creditRiskCounterpartyCreditRisk) {
		this.creditRiskCounterpartyCreditRisk = creditRiskCounterpartyCreditRisk;
	}




	public int getMarketRiskInterestRateRisk() {
		return marketRiskInterestRateRisk;
	}




	public void setMarketRiskInterestRateRisk(int marketRiskInterestRateRisk) {
		this.marketRiskInterestRateRisk = marketRiskInterestRateRisk;
	}




	public int getMaketRiskCommodityPriceRisk() {
		return maketRiskCommodityPriceRisk;
	}




	public void setMaketRiskCommodityPriceRisk(int maketRiskCommodityPriceRisk) {
		this.maketRiskCommodityPriceRisk = maketRiskCommodityPriceRisk;
	}




	public int getOperationalRiskInternalProcessesRisk() {
		return operationalRiskInternalProcessesRisk;
	}




	public void setOperationalRiskInternalProcessesRisk(int operationalRiskInternalProcessesRisk) {
		this.operationalRiskInternalProcessesRisk = operationalRiskInternalProcessesRisk;
	}




	public int getOperationalRiskFraudMisconductRisk() {
		return operationalRiskFraudMisconductRisk;
	}




	public void setOperationalRiskFraudMisconductRisk(int operationalRiskFraudMisconductRisk) {
		this.operationalRiskFraudMisconductRisk = operationalRiskFraudMisconductRisk;
	}




	public int getOperationalRiskBusinessContinuityRisk() {
		return operationalRiskBusinessContinuityRisk;
	}




	public void setOperationalRiskBusinessContinuityRisk(int operationalRiskBusinessContinuityRisk) {
		this.operationalRiskBusinessContinuityRisk = operationalRiskBusinessContinuityRisk;
	}




	public int getLiquidityRiskFundingLiquidityRisk() {
		return liquidityRiskFundingLiquidityRisk;
	}




	public void setLiquidityRiskFundingLiquidityRisk(int liquidityRiskFundingLiquidityRisk) {
		this.liquidityRiskFundingLiquidityRisk = liquidityRiskFundingLiquidityRisk;
	}




	public int getLiquidityRiskContingencyFundingRisk() {
		return liquidityRiskContingencyFundingRisk;
	}




	public void setLiquidityRiskContingencyFundingRisk(int liquidityRiskContingencyFundingRisk) {
		this.liquidityRiskContingencyFundingRisk = liquidityRiskContingencyFundingRisk;
	}




	public int getComplianceRisk() {
		return complianceRisk;
	}




	public void setComplianceRisk(int complianceRisk) {
		this.complianceRisk = complianceRisk;
	}




	public int getLegalRisk() {
		return legalRisk;
	}




	public void setLegalRisk(int legalRisk) {
		this.legalRisk = legalRisk;
	}




	public int getStrategyRiskBusinessModelRisk() {
		return strategyRiskBusinessModelRisk;
	}




	public void setStrategyRiskBusinessModelRisk(int strategyRiskBusinessModelRisk) {
		this.strategyRiskBusinessModelRisk = strategyRiskBusinessModelRisk;
	}




	public int getStrategyRiskReputationalRisk() {
		return strategyRiskReputationalRisk;
	}




	public void setStrategyRiskReputationalRisk(int strategyRiskReputationalRisk) {
		this.strategyRiskReputationalRisk = strategyRiskReputationalRisk;
	}




	public int getCybersecurityRisk() {
		return cybersecurityRisk;
	}




	public void setCybersecurityRisk(int cybersecurityRisk) {
		this.cybersecurityRisk = cybersecurityRisk;
	}




	public int getInterestRateRisk() {
		return interestRateRisk;
	}




	public void setInterestRateRisk(int interestRateRisk) {
		this.interestRateRisk = interestRateRisk;
	}




	public int getAmlFinancialCrimeRisk() {
		return amlFinancialCrimeRisk;
	}




	public void setAmlFinancialCrimeRisk(int amlFinancialCrimeRisk) {
		this.amlFinancialCrimeRisk = amlFinancialCrimeRisk;
	}




	public int getEsgRisk() {
		return esgRisk;
	}




	public void setEsgRisk(int esgRisk) {
		this.esgRisk = esgRisk;
	}




	public int getConductRisk() {
		return conductRisk;
	}




	public void setConductRisk(int conductRisk) {
		this.conductRisk = conductRisk;
	}




	@Override
	public String toString() {
	    return "YourClassName{" +
	            "id=" + id +
	            ", auditee=" + auditee +
	            ", factorName='" + factorName + '\'' +
	            ", factorWeight=" + factorWeight +
	            ", creditRiskLoanPortfolioRisk=" + creditRiskLoanPortfolioRisk +
	            ", creditRiskCounterpartyCreditRisk=" + creditRiskCounterpartyCreditRisk +
	            ", marketRiskInterestRateRisk=" + marketRiskInterestRateRisk +
	            ", maketRiskCommodityPriceRisk=" + maketRiskCommodityPriceRisk +
	            ", operationalRiskInternalProcessesRisk=" + operationalRiskInternalProcessesRisk +
	            ", operationalRiskFraudMisconductRisk=" + operationalRiskFraudMisconductRisk +
	            ", operationalRiskBusinessContinuityRisk=" + operationalRiskBusinessContinuityRisk +
	            ", liquidityRiskFundingLiquidityRisk=" + liquidityRiskFundingLiquidityRisk +
	            ", liquidityRiskContingencyFundingRisk=" + liquidityRiskContingencyFundingRisk +
	            ", complianceRisk=" + complianceRisk +
	            ", legalRisk=" + legalRisk +
	            ", strategyRiskBusinessModelRisk=" + strategyRiskBusinessModelRisk +
	            ", strategyRiskReputationalRisk=" + strategyRiskReputationalRisk +
	            ", cybersecurityRisk=" + cybersecurityRisk +
	            ", interestRateRisk=" + interestRateRisk +
	            ", amlFinancialCrimeRisk=" + amlFinancialCrimeRisk +
	            ", esgRisk=" + esgRisk +
	            ", conductRisk=" + conductRisk +
	            '}';
	}
	
	
}
