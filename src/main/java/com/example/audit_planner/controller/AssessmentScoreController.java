package com.example.audit_planner.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.audit_planner.model.AssessmentScore;
import com.example.audit_planner.model.AssessmentScoreRepository;
import com.example.audit_planner.model.Auditee;
import com.example.audit_planner.model.AuditeeRepository;

@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AssessmentScoreController {

	@Autowired
	AssessmentScoreRepository assessmentScoreRepo;
	
	@Autowired
	AuditeeRepository auditeeRepo;
	
	@GetMapping("/assessmentscores")
	public ResponseEntity<List<AssessmentScore>> getAllAssessmentScores(@RequestParam
			(required = false)Long auditeeId){
		try {
			List<AssessmentScore>assessmentScores = new ArrayList<AssessmentScore>();
			
			if(auditeeId ==null)
				assessmentScoreRepo.findAll().forEach(assessmentScores::add);
			else
				assessmentScoreRepo.findByAuditeeId(auditeeId).forEach(assessmentScores::add);
			
			if(assessmentScores.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(assessmentScores,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//this is to post the scores. here, the frontend input is using the Auditee object.
	@PostMapping("/assessmentscores")
	public ResponseEntity<AssessmentScore> createAssessmentScoreFactors(@RequestBody AssessmentScore assessmentScore){
		try {
						
			AssessmentScore _assessmentScore = assessmentScoreRepo.save(new AssessmentScore(
					assessmentScore.getAuditee(),
					assessmentScore.getFactorName(),
					assessmentScore.getFactorWeight(),
					assessmentScore.getCreditRiskLoanPortfolioRisk(),
					assessmentScore.getCreditRiskCounterpartyCreditRisk(),
					assessmentScore.getMarketRiskInterestRateRisk(),
					assessmentScore.getMaketRiskCommodityPriceRisk(),
					assessmentScore.getOperationalRiskInternalProcessesRisk(),
					assessmentScore.getOperationalRiskFraudMisconductRisk(),
					assessmentScore.getOperationalRiskBusinessContinuityRisk(),
					assessmentScore.getLiquidityRiskFundingLiquidityRisk(),
					assessmentScore.getLiquidityRiskContingencyFundingRisk(),
					assessmentScore.getComplianceRisk(),
					assessmentScore.getLegalRisk(),
					assessmentScore.getStrategyRiskBusinessModelRisk(),
					assessmentScore.getStrategyRiskReputationalRisk(),
					assessmentScore.getCybersecurityRisk(),
					assessmentScore.getInterestRateRisk(),
					assessmentScore.getAmlFinancialCrimeRisk(),
					assessmentScore.getEsgRisk(),
					assessmentScore.getConductRisk()	
					));
					
			return new ResponseEntity<>(_assessmentScore, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR );
		}
	}
	
	@PostMapping("/assessmentscoresdummyauditeeid")
	public ResponseEntity<AssessmentScore> createAssessmentScoreFactors2(@RequestBody AssessmentScore assessmentScore){
		try {
			
			List<Auditee> auditees = auditeeRepo.findAll();
			
			AssessmentScore _assessmentScore = assessmentScoreRepo.save(new AssessmentScore(
					auditees.get(assessmentScore.getDummyAuditeeId()-1),
					assessmentScore.getFactorName(),
					assessmentScore.getFactorWeight(),
					assessmentScore.getCreditRiskLoanPortfolioRisk(),
					assessmentScore.getCreditRiskCounterpartyCreditRisk(),
					assessmentScore.getMarketRiskInterestRateRisk(),
					assessmentScore.getMaketRiskCommodityPriceRisk(),
					assessmentScore.getOperationalRiskInternalProcessesRisk(),
					assessmentScore.getOperationalRiskFraudMisconductRisk(),
					assessmentScore.getOperationalRiskBusinessContinuityRisk(),
					assessmentScore.getLiquidityRiskFundingLiquidityRisk(),
					assessmentScore.getLiquidityRiskContingencyFundingRisk(),
					assessmentScore.getComplianceRisk(),
					assessmentScore.getLegalRisk(),
					assessmentScore.getStrategyRiskBusinessModelRisk(),
					assessmentScore.getStrategyRiskReputationalRisk(),
					assessmentScore.getCybersecurityRisk(),
					assessmentScore.getInterestRateRisk(),
					assessmentScore.getAmlFinancialCrimeRisk(),
					assessmentScore.getEsgRisk(),
					assessmentScore.getConductRisk()	
					));
					
			return new ResponseEntity<>(_assessmentScore, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR );
		}
	}
	
	@PutMapping("/assessmentscore/{id}")
	public ResponseEntity<AssessmentScore> updateAssessmentScores(@PathVariable("id")long id,@RequestBody AssessmentScore assessmentScore){
		AssessmentScore _assessmentScore = assessmentScoreRepo.findById(id);
		
		if(assessmentScore !=null) {
			_assessmentScore.setCreditRiskLoanPortfolioRisk(assessmentScore.getCreditRiskLoanPortfolioRisk());
			_assessmentScore.setCreditRiskCounterpartyCreditRisk(assessmentScore.getCreditRiskCounterpartyCreditRisk());
			_assessmentScore.setMarketRiskInterestRateRisk(assessmentScore.getMarketRiskInterestRateRisk());
			_assessmentScore.setMaketRiskCommodityPriceRisk(assessmentScore.getMaketRiskCommodityPriceRisk());
			_assessmentScore.setOperationalRiskInternalProcessesRisk(assessmentScore.getOperationalRiskInternalProcessesRisk());
			_assessmentScore.setOperationalRiskFraudMisconductRisk(assessmentScore.getOperationalRiskFraudMisconductRisk());
			_assessmentScore.setOperationalRiskBusinessContinuityRisk(assessmentScore.getOperationalRiskBusinessContinuityRisk());
			_assessmentScore.setLiquidityRiskFundingLiquidityRisk(assessmentScore.getLiquidityRiskFundingLiquidityRisk());
			_assessmentScore.setLiquidityRiskContingencyFundingRisk(assessmentScore.getLiquidityRiskContingencyFundingRisk());
			_assessmentScore.setComplianceRisk(assessmentScore.getComplianceRisk());
			_assessmentScore.setLegalRisk(assessmentScore.getLegalRisk());
			_assessmentScore.setStrategyRiskBusinessModelRisk(assessmentScore.getStrategyRiskBusinessModelRisk());
			_assessmentScore.setStrategyRiskReputationalRisk(assessmentScore.getStrategyRiskReputationalRisk());
			_assessmentScore.setCybersecurityRisk(assessmentScore.getCybersecurityRisk());
			_assessmentScore.setInterestRateRisk(assessmentScore.getInterestRateRisk());
			_assessmentScore.setAmlFinancialCrimeRisk(assessmentScore.getAmlFinancialCrimeRisk());
			_assessmentScore.setEsgRisk(assessmentScore.getEsgRisk());
			_assessmentScore.setConductRisk(assessmentScore.getConductRisk());
			return new ResponseEntity<>(assessmentScoreRepo.save(_assessmentScore),HttpStatus.OK);

		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/assessmentscore/{id}")
	public ResponseEntity<HttpStatus>deleteAssessmentScore(@PathVariable("id")long id){
		try {
			assessmentScoreRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@DeleteMapping("/assessmentscores")
	public ResponseEntity<HttpStatus> deleteAllAssessmentScores() {
		try {
			assessmentScoreRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
}
