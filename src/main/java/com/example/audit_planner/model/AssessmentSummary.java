package com.example.audit_planner.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="assessmentsummary")
public class AssessmentSummary {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@JoinColumn(name="auditee_id")
	Auditee auditee;
	
	@Column(name = "credit_risk_loan_portfolio_risk")
	private double creditRiskLoanPortfolioRisk;

	@Column(name = "creditRiskCounterpartyCreditRisk")
	private double creditRiskCounterpartyCreditRisk;

	@Column(name = "market_risk_interest_rate_risk")
	private double marketRiskInterestRateRisk;

	@Column(name = "market_risk_commodity_price_risk")
	private double marketRiskCommodityPriceRisk;

	@Column(name="operationalRiskInternalProcessesRisk")
	private double operationalRiskInternalProcessesRisk;
	
	@Column(name = "operational_risk_fraud_misconduct_risk")
	private double operationalRiskFraudMisconductRisk;

	@Column(name = "operational_risk_business_continuity_risk")
	private double operationalRiskBusinessContinuityRisk;

	@Column(name = "liquidity_risk_funding_liquidity_risk")
	private double liquidityRiskFundingLiquidityRisk;

	@Column(name = "liquidity_risk_contingency_funding_risk")
	private double liquidityRiskContingencyFundingRisk;

	@Column(name = "compliance_risk")
	private double complianceRisk;

	@Column(name = "legal_risk")
	private double legalRisk;

	@Column(name = "strategy_risk_business_model_risk")
	private double strategyRiskBusinessModelRisk;

	@Column(name = "strategy_risk_reputational_risk")
	private double strategyRiskReputationalRisk;

	@Column(name = "cyber_security_risk")
	private double cyberSecurityRisk;

	@Column(name = "interest_rate_risk")
	private double interestRateRisk;

	@Column(name = "aml_financial_crime_risk")
	private double amlFinancialCrimeRisk;

	@Column(name = "esg_risk")
	private double esgRisk;

	@Column(name = "conduct_risk")
	private double conductRisk;

	@Column(name = "total_scores")
	private double totalScores;

	@Column(name = "number_risks_rated")
	private double numberRisksRated;

	@Column(name = "benchmark_results")
	private String benchmarkResults;

	private double dummyAuditeeId;

	// Constructor and other methods remain unchanged

       
	public AssessmentSummary() {
	    // Default constructor
	}
	
	public AssessmentSummary(Auditee auditee) {
		this.auditee = auditee;
	}

	public AssessmentSummary(Auditee auditee, double creditRiskLoanPortfolioRisk,
	        double creditRiskCounterpartyCreditRisk, double marketRiskInterestRateRisk,
	        double marketRiskCommodityPriceRisk, double operationalRiskInternalProcessesRisk,double operationalRiskFraudMisconductRisk,
	        double operationalRiskBusinessContinuityRisk, double liquidityRiskFundingLiquidityRisk,
	        double liquidityRiskContingencyFundingRisk, double complianceRisk, double legalRisk,
	        double strategyRiskBusinessModelRisk, double strategyRiskReputationalRisk,
	        double cyberSecurityRisk, double interestRateRisk, double amlFinancialCrimeRisk,
	        double esgRisk, double conductRisk) {
	    
	    this.auditee = auditee;
	    this.creditRiskLoanPortfolioRisk = creditRiskLoanPortfolioRisk;
	    this.creditRiskCounterpartyCreditRisk = creditRiskCounterpartyCreditRisk;
	    this.marketRiskInterestRateRisk = marketRiskInterestRateRisk;
	    this.marketRiskCommodityPriceRisk = marketRiskCommodityPriceRisk;
	    this.operationalRiskInternalProcessesRisk=operationalRiskInternalProcessesRisk;
	    this.operationalRiskFraudMisconductRisk = operationalRiskFraudMisconductRisk;
	    this.operationalRiskBusinessContinuityRisk = operationalRiskBusinessContinuityRisk;
	    this.liquidityRiskFundingLiquidityRisk = liquidityRiskFundingLiquidityRisk;
	    this.liquidityRiskContingencyFundingRisk = liquidityRiskContingencyFundingRisk;
	    this.complianceRisk = complianceRisk;
	    this.legalRisk = legalRisk;
	    this.strategyRiskBusinessModelRisk = strategyRiskBusinessModelRisk;
	    this.strategyRiskReputationalRisk = strategyRiskReputationalRisk;
	    this.cyberSecurityRisk = cyberSecurityRisk;
	    this.interestRateRisk = interestRateRisk;
	    this.amlFinancialCrimeRisk = amlFinancialCrimeRisk;
	    this.esgRisk = esgRisk;
	    this.conductRisk = conductRisk;

	    this.totalScores = creditRiskLoanPortfolioRisk + creditRiskCounterpartyCreditRisk +
	            marketRiskInterestRateRisk + marketRiskCommodityPriceRisk +operationalRiskInternalProcessesRisk+
	            operationalRiskFraudMisconductRisk + operationalRiskBusinessContinuityRisk +
	            liquidityRiskFundingLiquidityRisk + liquidityRiskContingencyFundingRisk +
	            complianceRisk + legalRisk + strategyRiskBusinessModelRisk +
	            strategyRiskReputationalRisk + cyberSecurityRisk + interestRateRisk +
	            amlFinancialCrimeRisk + esgRisk + conductRisk;

	    double[] riskScores = {
	            creditRiskLoanPortfolioRisk, creditRiskCounterpartyCreditRisk,
	            marketRiskInterestRateRisk, marketRiskCommodityPriceRisk,operationalRiskInternalProcessesRisk,
	            operationalRiskFraudMisconductRisk, operationalRiskBusinessContinuityRisk,
	            liquidityRiskFundingLiquidityRisk, liquidityRiskContingencyFundingRisk,
	            complianceRisk, legalRisk,
	            strategyRiskBusinessModelRisk, strategyRiskReputationalRisk,
	            cyberSecurityRisk, interestRateRisk, amlFinancialCrimeRisk,
	            esgRisk, conductRisk
	    };

	    double count = 0;
	    for (double riskScore : riskScores) {
	        if (riskScore != 0) {
	            count++;
	        }
	    }
	    this.numberRisksRated = count;

	    if (totalScores < numberRisksRated * 3) {
	        this.benchmarkResults = "Low Risk";
	    } else if (totalScores < numberRisksRated * 7) {
	        this.benchmarkResults = "Medium Risk";
	    } else if (totalScores < numberRisksRated * 10) {
	        this.benchmarkResults = "High Risk";
	    } else {
	        this.benchmarkResults = "Very High Risk";
	    }
	}
	//without auditee. auditee is supplied at the front end
	public AssessmentSummary(double creditRiskLoanPortfolioRisk,
	        double creditRiskCounterpartyCreditRisk, double marketRiskInterestRateRisk,
	        double marketRiskCommodityPriceRisk, double operationalRiskInternalProcessesRisk,double operationalRiskFraudMisconductRisk,
	        double operationalRiskBusinessContinuityRisk, double liquidityRiskFundingLiquidityRisk,
	        double liquidityRiskContingencyFundingRisk, double complianceRisk, double legalRisk,
	        double strategyRiskBusinessModelRisk, double strategyRiskReputationalRisk,
	        double cyberSecurityRisk, double interestRateRisk, double amlFinancialCrimeRisk,
	        double esgRisk, double conductRisk) {
	    
	    
	    this.creditRiskLoanPortfolioRisk = creditRiskLoanPortfolioRisk;
	    this.creditRiskCounterpartyCreditRisk = creditRiskCounterpartyCreditRisk;
	    this.marketRiskInterestRateRisk = marketRiskInterestRateRisk;
	    this.marketRiskCommodityPriceRisk = marketRiskCommodityPriceRisk;
	    this.operationalRiskInternalProcessesRisk=operationalRiskInternalProcessesRisk;
	    this.operationalRiskFraudMisconductRisk = operationalRiskFraudMisconductRisk;
	    this.operationalRiskBusinessContinuityRisk = operationalRiskBusinessContinuityRisk;
	    this.liquidityRiskFundingLiquidityRisk = liquidityRiskFundingLiquidityRisk;
	    this.liquidityRiskContingencyFundingRisk = liquidityRiskContingencyFundingRisk;
	    this.complianceRisk = complianceRisk;
	    this.legalRisk = legalRisk;
	    this.strategyRiskBusinessModelRisk = strategyRiskBusinessModelRisk;
	    this.strategyRiskReputationalRisk = strategyRiskReputationalRisk;
	    this.cyberSecurityRisk = cyberSecurityRisk;
	    this.interestRateRisk = interestRateRisk;
	    this.amlFinancialCrimeRisk = amlFinancialCrimeRisk;
	    this.esgRisk = esgRisk;
	    this.conductRisk = conductRisk;

	    this.totalScores = creditRiskLoanPortfolioRisk + creditRiskCounterpartyCreditRisk +
	            marketRiskInterestRateRisk + marketRiskCommodityPriceRisk +operationalRiskInternalProcessesRisk+
	            operationalRiskFraudMisconductRisk + operationalRiskBusinessContinuityRisk +
	            liquidityRiskFundingLiquidityRisk + liquidityRiskContingencyFundingRisk +
	            complianceRisk + legalRisk + strategyRiskBusinessModelRisk +
	            strategyRiskReputationalRisk + cyberSecurityRisk + interestRateRisk +
	            amlFinancialCrimeRisk + esgRisk + conductRisk;

	    double[] riskScores = {
	            creditRiskLoanPortfolioRisk, creditRiskCounterpartyCreditRisk,
	            marketRiskInterestRateRisk, marketRiskCommodityPriceRisk,operationalRiskInternalProcessesRisk,
	            operationalRiskFraudMisconductRisk, operationalRiskBusinessContinuityRisk,
	            liquidityRiskFundingLiquidityRisk, liquidityRiskContingencyFundingRisk,
	            complianceRisk, legalRisk,
	            strategyRiskBusinessModelRisk, strategyRiskReputationalRisk,
	            cyberSecurityRisk, interestRateRisk, amlFinancialCrimeRisk,
	            esgRisk, conductRisk
	    };

	    double count = 0;
	    for (double riskScore : riskScores) {
	        if (riskScore != 0) {
	            count++;
	        }
	    }
	    this.numberRisksRated = count;

	    if (totalScores < numberRisksRated * 3) {
	        this.benchmarkResults = "Low Risk";
	    } else if (totalScores < numberRisksRated * 7) {
	        this.benchmarkResults = "Medium Risk";
	    } else if (totalScores < numberRisksRated * 10) {
	        this.benchmarkResults = "High Risk";
	    } else {
	        this.benchmarkResults = "Very High Risk";
	    }
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

	public void setNumberRisksRated(double numberRisksRated) {
		this.numberRisksRated = numberRisksRated;
	}

	public double getCreditRiskLoanPortfolioRisk() {
	    return creditRiskLoanPortfolioRisk;
	}

	public void setCreditRiskLoanPortfolioRisk(double creditRiskLoanPortfolioRisk) {
	    this.creditRiskLoanPortfolioRisk = creditRiskLoanPortfolioRisk;
	}

	public double getCreditRiskCounterpartyCreditRisk() {
	    return creditRiskCounterpartyCreditRisk;
	}

	public void setCreditRiskCounterpartyCreditRisk(double creditRiskCounterpartyCreditRisk) {
	    this.creditRiskCounterpartyCreditRisk = creditRiskCounterpartyCreditRisk;
	}

	public double getMarketRiskInterestRateRisk() {
	    return marketRiskInterestRateRisk;
	}

	public void setMarketRiskInterestRateRisk(double marketRiskInterestRateRisk) {
	    this.marketRiskInterestRateRisk = marketRiskInterestRateRisk;
	}

	public double getMarketRiskCommodityPriceRisk() {
	    return marketRiskCommodityPriceRisk;
	}
	
	public double getOperationalRiskInternalProcessesRisk() {
		return operationalRiskInternalProcessesRisk;
	}

	public void setOperationalRiskInternalProcessesRisk(double operationalRiskInternalProcessesRisk) {
		this.operationalRiskInternalProcessesRisk = operationalRiskInternalProcessesRisk;
	}


	public void setMarketRiskCommodityPriceRisk(double marketRiskCommodityPriceRisk) {
	    this.marketRiskCommodityPriceRisk = marketRiskCommodityPriceRisk;
	}

	public double getOperationalRiskFraudMisconductRisk() {
	    return operationalRiskFraudMisconductRisk;
	}

	public void setOperationalRiskFraudMisconductRisk(double operationalRiskFraudMisconductRisk) {
	    this.operationalRiskFraudMisconductRisk = operationalRiskFraudMisconductRisk;
	}

	public double getOperationalRiskBusinessContinuityRisk() {
	    return operationalRiskBusinessContinuityRisk;
	}

	public void setOperationalRiskBusinessContinuityRisk(double operationalRiskBusinessContinuityRisk) {
	    this.operationalRiskBusinessContinuityRisk = operationalRiskBusinessContinuityRisk;
	}

	public double getLiquidityRiskFundingLiquidityRisk() {
	    return liquidityRiskFundingLiquidityRisk;
	}

	public void setLiquidityRiskFundingLiquidityRisk(double liquidityRiskFundingLiquidityRisk) {
	    this.liquidityRiskFundingLiquidityRisk = liquidityRiskFundingLiquidityRisk;
	}

	public double getLiquidityRiskContingencyFundingRisk() {
	    return liquidityRiskContingencyFundingRisk;
	}

	public void setLiquidityRiskContingencyFundingRisk(double liquidityRiskContingencyFundingRisk) {
	    this.liquidityRiskContingencyFundingRisk = liquidityRiskContingencyFundingRisk;
	}

	public double getComplianceRisk() {
	    return complianceRisk;
	}

	public void setComplianceRisk(double complianceRisk) {
	    this.complianceRisk = complianceRisk;
	}

	public double getLegalRisk() {
	    return legalRisk;
	}

	public void setLegalRisk(double legalRisk) {
	    this.legalRisk = legalRisk;
	}

	public double getStrategyRiskBusinessModelRisk() {
	    return strategyRiskBusinessModelRisk;
	}

	public void setStrategyRiskBusinessModelRisk(double strategyRiskBusinessModelRisk) {
	    this.strategyRiskBusinessModelRisk = strategyRiskBusinessModelRisk;
	}

	public double getStrategyRiskReputationalRisk() {
	    return strategyRiskReputationalRisk;
	}

	public void setStrategyRiskReputationalRisk(double strategyRiskReputationalRisk) {
	    this.strategyRiskReputationalRisk = strategyRiskReputationalRisk;
	}

	public double getCyberSecurityRisk() {
	    return cyberSecurityRisk;
	}

	public void setCyberSecurityRisk(double cyberSecurityRisk) {
	    this.cyberSecurityRisk = cyberSecurityRisk;
	}

	public double getInterestRateRisk() {
	    return interestRateRisk;
	}

	public void setInterestRateRisk(double interestRateRisk) {
	    this.interestRateRisk = interestRateRisk;
	}

	public double getAmlFinancialCrimeRisk() {
	    return amlFinancialCrimeRisk;
	}

	public void setAmlFinancialCrimeRisk(double amlFinancialCrimeRisk) {
	    this.amlFinancialCrimeRisk = amlFinancialCrimeRisk;
	}

	public double getEsgRisk() {
	    return esgRisk;
	}

	public void setEsgRisk(double esgRisk) {
	    this.esgRisk = esgRisk;
	}

	public double getConductRisk() {
	    return conductRisk;
	}

	public void setConductRisk(double conductRisk) {
	    this.conductRisk = conductRisk;
	}

	public double getTotalScores() {
	    return totalScores;
	}

	public void setTotalScores(double totalScores) {
	    this.totalScores = totalScores;
	}

	public double getNumberRisksRated() {
	    return numberRisksRated;
	}

	public String getBenchmarkResults() {
	    return benchmarkResults;
	}

	public void setBenchmarkResults(String benchmarkResults) {
	    this.benchmarkResults = benchmarkResults;
	}

	
	
	
}
