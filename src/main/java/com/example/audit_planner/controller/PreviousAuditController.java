package com.example.audit_planner.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.audit_planner.model.PreviousAudit;
import com.example.audit_planner.model.PreviousAuditRepository;

@CrossOrigin(origins="htpp://localhost:8081")
@RestController
@RequestMapping("/api")
public class PreviousAuditController {

	@Autowired
	PreviousAuditRepository previousAuditRepo;
	
	@GetMapping("/previousAudits")
	public ResponseEntity<List<PreviousAudit>>getAllPreviousAudits(@RequestParam(required=false)Long auditeeId){
		try {
			List<PreviousAudit> previousAudits = new ArrayList<PreviousAudit>();
			
			if(auditeeId == null)
				previousAudits=previousAuditRepo.findAll();
			else 
				previousAudits=previousAuditRepo.findByAuditeeId(auditeeId);
			
			if (previousAudits.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(previousAudits,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/previousAudits")
	public ResponseEntity<PreviousAudit>createPreviousAudit(@RequestBody PreviousAudit previousAudit){
		try {
			
			PreviousAudit _previousAudit = previousAuditRepo.save(previousAudit);
			
//			PreviousAudit _previousAudit = previousAuditRepo.save(new PreviousAudit(previousAudit.getAuditee(),previousAudit.getAuditPlanRiskRating(),
//					previousAudit.getDateOfAudit(),previousAudit.getAuditRating(),previousAudit.getNumberHighRiskIssues(),previousAudit.getNumberMediumRiskIssues(),
//					previousAudit.getNumberLowRiskIssues(),previousAudit.getNumberHighRiskIncidents(),previousAudit.getNumberMediumRiskIncidents(),
//					previousAudit.getNumberLowRiskIncidents()));
			
			return new ResponseEntity<>(_previousAudit,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
