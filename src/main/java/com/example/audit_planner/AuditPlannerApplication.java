package com.example.audit_planner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.audit_planner.model.AssessmentScore;
import com.example.audit_planner.model.AssessmentScoreRepository;
import com.example.audit_planner.model.AssessmentSummary;
import com.example.audit_planner.model.AssessmentSummaryRepository;
import com.example.audit_planner.model.Auditee;
import com.example.audit_planner.model.AuditeeRepository;
import com.example.audit_planner.model.Auditor;
import com.example.audit_planner.model.AuditorRepository;
import com.example.audit_planner.model.PreviousAudit;
import com.example.audit_planner.model.PreviousAuditRepository;
import com.example.audit_planner.model.ResourceAllocation;
import com.example.audit_planner.model.ResourceAllocationRepository;

@SpringBootApplication
public class AuditPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditPlannerApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(AuditorRepository auditorRepo, AuditeeRepository auditeeRepo,  PreviousAuditRepository previousAuditRepo, 
			AssessmentScoreRepository assessmentScoreRepo,AssessmentSummaryRepository assessmentSummaryRepo,
			ResourceAllocationRepository resourceAllocationRepo) {
		return args ->{
			
			//instantiation of auditors
			List<Auditor>auditors = new ArrayList<>();
			auditors.add(new Auditor("Operations","Clara","Manager"));
			auditors.add(new Auditor("Credit","Farhana","Manager"));
			auditors.add(new Auditor("Technology","Sunny","Manager"));
			auditors.add(new Auditor("Treasury","Chee Wan","Manager"));
			
			auditorRepo.saveAll(auditors);
			
			auditorRepo.findAll().forEach(System.out::println);
			
			//----------------------------------------------------------------------------------------------------------
			
			
			//instantiation of "auditees"
			List<Auditee>auditees = new ArrayList<>();
						
			auditees.add(new Auditee("Sales","Global Markets",auditors.get(4-1)));
			auditees.add(new Auditee("Wealth Management","Community Financial Services",auditors.get(1-1)));
			auditees.add(new Auditee("Commercial Banking Division","Community Financial Services",auditors.get(2-1)));
			auditees.add(new Auditee("Cards & Personal Loans","Community Financial Services",auditors.get(2-1)));
			auditees.add(new Auditee("Retail Loans","Community Financial Services",auditors.get(2-1)));
			auditees.add(new Auditee("Distribution Channel Service","Operations",auditors.get(1-1)));
			auditees.add(new Auditee("Treasury","Operations",auditors.get(4-1)));
			auditees.add(new Auditee("Credit Doc & Admin","Operations",auditors.get(2-1)));
			auditees.add(new Auditee("Operations & Payment Support","Operations",auditors.get(1-1)));
			auditees.add(new Auditee("Planning & Service Management","Operations",auditors.get(1-1)));
			auditees.add(new Auditee("Property Services","Operations",auditors.get(1-1)));
			auditees.add(new Auditee("Rewards","Human Capital",auditors.get(1-1)));
			auditees.add(new Auditee("Resourcing & Workforce Management","Human Capital",auditors.get(1-1)));
			auditees.add(new Auditee("Financial Analytics","Finance",auditors.get(2-1)));
			auditees.add(new Auditee("Financial Management","Finance",auditors.get(2-1)));
			auditees.add(new Auditee("Products Control","Finance",auditors.get(4-1)));
			auditees.add(new Auditee("Remedial Management","Finance",auditors.get(2-1)));
			auditees.add(new Auditee("Tax","Finance",auditors.get(1-1)));
			auditees.add(new Auditee("Credit Management","Risk Management",auditors.get(2-1)));
			auditees.add(new Auditee("Traded Risk Management","Risk Management",auditors.get(4-1)));
			auditees.add(new Auditee("Portfolio Risk Management","Risk Management",auditors.get(2-1)));
			auditees.add(new Auditee("Operational Risk Management","Risk Management",auditors.get(1-1)));
			auditees.add(new Auditee("Enterprise Risk Management","Risk Management",auditors.get(4-1)));
			auditees.add(new Auditee("Transformation Office","Strategy",auditors.get(1-1)));
			auditees.add(new Auditee("Digital Banking","Strategy",auditors.get(3-1)));
			auditees.add(new Auditee("Sustainability Office","Strategy",auditors.get(1-1)));
			auditees.add(new Auditee("Legal-Global Banking","Legal & Corporate Office",auditors.get(4-1)));
			auditees.add(new Auditee("Legal-CFS Support","Legal & Corporate Office",auditors.get(2-1)));
			auditees.add(new Auditee("Corporate Affairs","Country Corporate Office",auditors.get(1-1)));
			auditees.add(new Auditee("Financial Crime Compliance","Compliance",auditors.get(1-1)));
			auditees.add(new Auditee("Regulatory Monitoring","Compliance",auditors.get(4-1)));
			auditees.add(new Auditee("Regulatory Affairs","Compliance",auditors.get(4-1)));
			auditees.add(new Auditee("Core Banking and Data Warehouse","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("Wealth, Branch Channel and Treasury","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("Digital Channels","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("Cards","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("Trade","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("Technology Infrastructure","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("Technology Risk Management","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("IT Security Defense","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("Finance and Corporate Function","Technology",auditors.get(3-1)));
			
			// For auditee at index 0
			auditees.get(0).addAssessmentScore(new AssessmentScore("Change", 0.20, 2, 7, 4, 9, 1, 6, 0, 8, 3, 2, 0, 1, 5, 6, 7, 8, 9, 4));
			auditees.get(0).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15, 3, 6, 2, 9, 4, 5, 1, 7, 8, 0, 2, 3, 5, 6, 7, 9, 1, 4));
			auditees.get(0).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10, 1, 5, 7, 0, 8, 2, 3, 4, 9, 6, 0, 1, 2, 4, 5, 7, 8, 3));
			auditees.get(0).addAssessmentScore(new AssessmentScore("Financial", 0.10, 6, 2, 1, 0, 7, 3, 5, 8, 9, 4, 1, 2, 3, 5, 7, 8, 0, 6));
			auditees.get(0).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10, 9, 5, 0, 3, 8, 2, 1, 6, 7, 4, 0, 2, 3, 5, 7, 8, 1, 4));
			auditees.get(0).addAssessmentScore(new AssessmentScore("Complexity", 0.10, 8, 4, 1, 9, 6, 3, 5, 0, 7, 2, 8, 0, 1, 2, 4, 5, 7, 9));
			auditees.get(0).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10, 3, 7, 8, 0, 2, 1, 6, 9, 4, 5, 3, 0, 2, 4, 5, 7, 8, 6));
			auditees.get(0).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10, 5, 9, 6, 4, 0, 2, 3, 1, 7, 2, 3, 5, 7, 8, 1, 4, 6, 9));
			auditees.get(0).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05, 4, 2, 1, 0, 8, 3, 9, 6, 7, 5, 0, 2, 3, 5, 7, 4, 6, 9));

			// For auditee at index 1
			auditees.get(1).addAssessmentScore(new AssessmentScore("Change", 0.20, 7, 4, 9, 1, 6, 0, 8, 3, 2, 0, 1, 5, 6, 7, 8, 9, 4, 3));
			auditees.get(1).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15, 6, 2, 9, 4, 5, 1, 7, 8, 0, 2, 3, 5, 6, 7, 9, 1, 4, 8));
			auditees.get(1).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10, 5, 7, 0, 8, 2, 3, 4, 9, 6, 0, 1, 2, 4, 5, 7, 8, 3, 9));
			auditees.get(1).addAssessmentScore(new AssessmentScore("Financial", 0.10, 2, 1, 0, 7, 3, 5, 8, 9, 4, 1, 2, 3, 5, 7, 8, 0, 6, 9));
			auditees.get(1).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10, 5, 0, 3, 8, 2, 1, 6, 7, 4, 0, 2, 3, 5, 7, 8, 1, 4, 6));
			auditees.get(1).addAssessmentScore(new AssessmentScore("Complexity", 0.10, 4, 1, 9, 6, 3, 5, 0, 7, 2, 8, 0, 1, 2, 4, 5, 7, 9, 6));
			auditees.get(1).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10, 7, 8, 0, 2, 1, 6, 9, 4, 5, 3, 0, 2, 4, 5, 7, 8, 6, 9));
			auditees.get(1).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10, 9, 6, 4, 0, 2, 3, 1, 7, 8, 0, 2, 3, 5, 7, 8, 6, 9, 5));
			auditees.get(1).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05, 2, 1, 0, 8, 3, 9, 6, 7, 5, 0, 2, 3, 5, 7, 8, 6, 9, 4));
			
			// For auditee at index 2
			auditees.get(2).addAssessmentScore(new AssessmentScore("Change", 0.20, 2, 3, 1, 0, 7, 8, 9, 4, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(2).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15, 1, 3, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(2).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10, 3, 0, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(2).addAssessmentScore(new AssessmentScore("Financial", 0.10, 1, 2, 3, 0, 7, 8, 9, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
			auditees.get(2).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10, 0, 2, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(2).addAssessmentScore(new AssessmentScore("Complexity", 0.10, 2, 3, 1, 0, 7, 8, 9, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(2).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10, 3, 2, 1, 0, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
			auditees.get(2).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10, 3, 0, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
			auditees.get(2).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05, 2, 1, 3, 0, 7, 8, 9, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));

			// For auditee at index 4
			auditees.get(3).addAssessmentScore(new AssessmentScore("Change", 0.20, 2, 3, 1, 0, 7, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(3).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15, 1, 0, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(3).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10, 1, 2, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(3).addAssessmentScore(new AssessmentScore("Financial", 0.10, 1, 2, 3, 0, 7, 8, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
			auditees.get(3).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10, 0, 2, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(3).addAssessmentScore(new AssessmentScore("Complexity", 0.10, 2, 3, 1, 0, 7, 8, 9, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(3).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10, 3, 2, 1, 0, 7, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
			auditees.get(3).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10, 1, 0, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
			auditees.get(3).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05, 2, 1, 3, 0, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			
			auditees.get(4).addAssessmentScore(new AssessmentScore("Change", 0.20));
			auditees.get(4).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15));
			auditees.get(4).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10));
			auditees.get(4).addAssessmentScore(new AssessmentScore("Financial", 0.10));
			auditees.get(4).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10));
			auditees.get(4).addAssessmentScore(new AssessmentScore("Complexity", 0.10));
			auditees.get(4).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10));
			auditees.get(4).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10));
			auditees.get(4).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05));
			
					
			auditeeRepo.saveAll(auditees);

			auditeeRepo.findAll().forEach(System.out::println);
			
			//---------------------------------------------------------------------------------------------------------
			
			
			
			//instantiation of PreviousAudit
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			List<PreviousAudit> previousAudits = new ArrayList<>();
			previousAudits.add(new PreviousAudit(auditees.get(0),"Medium",dateFormat.parse("2023-01-30"),"Medium",2,1,0,0,1,3));
			previousAudits.add(new PreviousAudit(auditees.get(1),"Medium",dateFormat.parse("2023-02-15"),"Medium",2,1,0,0,1,3));
			previousAudits.add(new PreviousAudit(auditees.get(3),"High",dateFormat.parse("2023-03-10"),"Medium",2,1,0,0,1,4));
	
			previousAuditRepo.saveAll(previousAudits);
			previousAuditRepo.findAll().forEach(System.out::println);	
				
			//----------------------------------------------------------------------------------------------------------
			
			//instantiation of assessmentScores
			List<AssessmentScore> assessmentScores = assessmentScoreRepo.findAll();
			

			double[] riskIndicators = new double[17]; // Assuming there are 17 risk indicators
			int currentAuditeeId = -1; // Start with an invalid ID

			for (int i = 0; i < assessmentScores.size(); i++) {
			    int auditeeId = (int)assessmentScores.get(i).getAuditee().getId();

			    if (auditeeId != currentAuditeeId) {
			        if (currentAuditeeId != -1) {
			        	
			            AssessmentSummary assessmentSummary = new AssessmentSummary(
			                    assessmentScores.get(i - 1).getAuditee(),
			                    riskIndicators[0], riskIndicators[1], riskIndicators[2], riskIndicators[3],
			                    riskIndicators[4], riskIndicators[5], riskIndicators[6], riskIndicators[7],
			                    riskIndicators[8], riskIndicators[9], riskIndicators[10], riskIndicators[11],
			                    riskIndicators[12], riskIndicators[13], riskIndicators[14], riskIndicators[15],
			                    riskIndicators[16]
			            );
			            assessmentSummaryRepo.save(assessmentSummary);

			            // Reset risk indicators for the next auditee
			            Arrays.fill(riskIndicators, 0);
			        }

			        currentAuditeeId = auditeeId;
			    }

			    riskIndicators[0] +=(int) Math.round((assessmentScores.get(i).getCreditRiskLoanPortfolioRisk())*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[1] += (int) Math.round(assessmentScores.get(i).getCreditRiskCounterpartyCreditRisk()*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[2] += (int) Math.round(assessmentScores.get(i).getMarketRiskInterestRateRisk()*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[3] += (int) Math.round(assessmentScores.get(i).getMaketRiskCommodityPriceRisk()*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[4] += (int) Math.round(assessmentScores.get(i).getOperationalRiskFraudMisconductRisk()*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[5] += (int) Math.round(assessmentScores.get(i).getOperationalRiskBusinessContinuityRisk()*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[6] += (int) Math.round(assessmentScores.get(i).getLiquidityRiskFundingLiquidityRisk()*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[7] +=(int) Math.round (assessmentScores.get(i).getLiquidityRiskContingencyFundingRisk()*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[8] += (int) Math.round(assessmentScores.get(i).getComplianceRisk()*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[9] += (int) Math.round(assessmentScores.get(i).getLegalRisk()*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[10] +=(int) Math.round (assessmentScores.get(i).getStrategyRiskBusinessModelRisk()*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[11] += (int) Math.round(assessmentScores.get(i).getStrategyRiskReputationalRisk()*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[12] +=(int) Math.round( assessmentScores.get(i).getCybersecurityRisk()*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[13] +=(int) Math.round( assessmentScores.get(i).getInterestRateRisk()*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[14] +=(int) Math.round( assessmentScores.get(i).getAmlFinancialCrimeRisk()*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[15] +=(int) Math.round (assessmentScores.get(i).getEsgRisk()*assessmentScores.get(i).getFactorWeight());
			    riskIndicators[16] +=(int) Math.round( assessmentScores.get(i).getConductRisk()*assessmentScores.get(i).getFactorWeight());
			}

			// Save the last AssessmentSummary
			AssessmentSummary lastAssessmentSummary = new AssessmentSummary(
			        assessmentScores.get(assessmentScores.size() - 1).getAuditee(),
			        riskIndicators[0], riskIndicators[1], riskIndicators[2], riskIndicators[3],
			        riskIndicators[4], riskIndicators[5], riskIndicators[6], riskIndicators[7],
			        riskIndicators[8], riskIndicators[9], riskIndicators[10], riskIndicators[11],
			        riskIndicators[12], riskIndicators[13], riskIndicators[14], riskIndicators[15],
			        riskIndicators[16]
			);
			assessmentSummaryRepo.save(lastAssessmentSummary);		

			//---------------------------------------------------------------------------------------------------------------
			
			//Resource Allocation instantiation for the auditable units
			//for now, it is based on those auditees from the AssessmentSummary Table with Medium or High Risk ratings
			//there should be another column that would specifically indicate whether the auditee is auditable or not
			//to accommodate overridess
			
			List<AssessmentSummary>assessmentSummaries = assessmentSummaryRepo.findAll();
			List<AssessmentSummary>auditableUnits = new ArrayList<>();
			
			for(int i =0; i<assessmentSummaries.size();i++) {
				if(assessmentSummaries.get(i).getBenchmarkResults()=="Medium Risk"||assessmentSummaries.get(i).getBenchmarkResults()=="High Risk") {
					auditableUnits.add(assessmentSummaries.get(i));
				}
			}
			
			List<ResourceAllocation> resourceAllocations = new ArrayList<>();
			Auditee auditee;
			for(int i =0; i<auditableUnits.size();i++) {
				
				auditee=auditableUnits.get(i).getAuditee();
				resourceAllocations.add(new ResourceAllocation(auditee));						
				}
			
			resourceAllocationRepo.saveAll(resourceAllocations);
			
		};
		
	}

}
