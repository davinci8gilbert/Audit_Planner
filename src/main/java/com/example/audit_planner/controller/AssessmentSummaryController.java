package com.example.audit_planner.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.audit_planner.model.AssessmentSummary;
import com.example.audit_planner.model.AssessmentSummaryRepository;

@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AssessmentSummaryController {

	@Autowired
	AssessmentSummaryRepository assessmentSummaryRepo;
	
	@GetMapping("/assessmentsummaries")
	public ResponseEntity<List<AssessmentSummary>> getAllAssessmentSummaries(@RequestParam(required = false) Long auditeeId) {
		try {
			List<AssessmentSummary> assessmentSummaries = new ArrayList<AssessmentSummary>();

			if (auditeeId == null)
				assessmentSummaryRepo.findAll().forEach(assessmentSummaries::add);
				
			else
				assessmentSummaryRepo.findByAuditeeId(auditeeId).forEach(assessmentSummaries::add);

			if (assessmentSummaries.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(assessmentSummaries, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/assessmentsummaries/{id}")
	public ResponseEntity<AssessmentSummary> getAssessmentSummaryById(@PathVariable("id") long id) {
		AssessmentSummary assessmentSummary = assessmentSummaryRepo.findById(id);

		if (assessmentSummary!=null) {
			return new ResponseEntity<>(assessmentSummary, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/assessmentsummaries/{id}")
	public ResponseEntity<AssessmentSummary>updateAssessmentSummaries(@PathVariable("id")long id,@RequestBody AssessmentSummary
			assessmentSummary){
		AssessmentSummary _assessmentSummary = assessmentSummaryRepo.findById(id);
		
		if(assessmentSummary !=null) {
			_assessmentSummary.setAuditee(assessmentSummary.getAuditee());
			_assessmentSummary.setCreditRiskLoanPortfolioRisk(assessmentSummary.getCreditRiskLoanPortfolioRisk());
			_assessmentSummary.setCreditRiskCounterpartyCreditRisk(assessmentSummary.getCreditRiskCounterpartyCreditRisk());
			_assessmentSummary.setMarketRiskInterestRateRisk(assessmentSummary.getMarketRiskInterestRateRisk());
			_assessmentSummary.setMarketRiskCommodityPriceRisk(assessmentSummary.getMarketRiskCommodityPriceRisk());
			_assessmentSummary.setOperationalRiskInternalProcessesRisk(assessmentSummary.getOperationalRiskInternalProcessesRisk());
			_assessmentSummary.setOperationalRiskFraudMisconductRisk(assessmentSummary.getOperationalRiskFraudMisconductRisk());
			_assessmentSummary.setOperationalRiskBusinessContinuityRisk(assessmentSummary.getOperationalRiskBusinessContinuityRisk());
			_assessmentSummary.setLiquidityRiskFundingLiquidityRisk(assessmentSummary.getLiquidityRiskFundingLiquidityRisk());
			_assessmentSummary.setLiquidityRiskContingencyFundingRisk(assessmentSummary.getLiquidityRiskContingencyFundingRisk());
			_assessmentSummary.setComplianceRisk(assessmentSummary.getComplianceRisk());
			_assessmentSummary.setLegalRisk(assessmentSummary.getLegalRisk());
			_assessmentSummary.setStrategyRiskBusinessModelRisk(assessmentSummary.getStrategyRiskBusinessModelRisk());
			_assessmentSummary.setStrategyRiskReputationalRisk(assessmentSummary.getStrategyRiskReputationalRisk());
			_assessmentSummary.setCyberSecurityRisk(assessmentSummary.getCyberSecurityRisk());
			_assessmentSummary.setInterestRateRisk(assessmentSummary.getInterestRateRisk());
			_assessmentSummary.setAmlFinancialCrimeRisk(assessmentSummary.getAmlFinancialCrimeRisk());
			_assessmentSummary.setEsgRisk(assessmentSummary.getEsgRisk());
			_assessmentSummary.setConductRisk(assessmentSummary.getConductRisk());
			_assessmentSummary.setTotalScores(assessmentSummary.getTotalScores());
			_assessmentSummary.setNumberRisksRated(assessmentSummary.getNumberRisksRated());
			_assessmentSummary.setBenchmarkResults(assessmentSummary.getBenchmarkResults());
			
			return new ResponseEntity<>(assessmentSummaryRepo.save(_assessmentSummary),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	

}
