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

import com.example.audit_planner.model.Auditee;
import com.example.audit_planner.model.Auditor;
import com.example.audit_planner.model.AuditorRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AuditorController {

	@Autowired
	AuditorRepository auditorRepo;
	
	@GetMapping("/auditors")
	public ResponseEntity<List<Auditor>> getAllAuditors(@RequestParam(required=false) String teamName){
		try {
			List<Auditor> auditors = new ArrayList<Auditor>();
			
			if (teamName == null) auditorRepo.findAll().forEach(auditors::add);
			else auditorRepo.findByTeamName(teamName).forEach(auditors::add);
			
			if(auditors.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(auditors, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/auditors/{id}")
	public ResponseEntity<Auditor> getAuditorById(@PathVariable("id") long id){
		Auditor auditorData = auditorRepo.findById(id);
		
		if(auditorData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(auditorData,HttpStatus.OK);
		}
	}
	
	@PostMapping("/auditors")
	public ResponseEntity<Auditor> createAuditor(@RequestBody Auditor auditor){
		try {
			Auditor _auditor = auditorRepo.save(new Auditor(auditor.getTeamName(),auditor.getAuditorName(),auditor.getRole(),
					auditor.getPassword(),auditor.getHeadcount(),auditor.getNumberOfWorkingDays(),auditor.getNumberOfDailyWorkHours(),auditor.getTotalWorkingHours(),
					auditor.getAnnualLeaves(),auditor.getMaternityLeaves(),auditor.getAnnualPlanningActivities(),auditor.getContinuousAudit(),
					auditor.getAdministrativeActivities(),auditor.getContingencyBudget(),auditor.getTotalAdjustment(),auditor.getAvailableHoursAudit(),
					auditor.getActualAllocatedManhours(),auditor.getExcessShort()));
			return new ResponseEntity<>(_auditor,HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/auditors/{id}")
	public ResponseEntity<Auditor> updateAuditor(@PathVariable("id")long id, @RequestBody Auditor auditor){
		Auditor auditorData = auditorRepo.findById(id);
		if(auditorData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			auditorData.setTeamName(auditor.getTeamName());
			auditorData.setAuditorName(auditor.getAuditorName());
			auditorData.setRole(auditor.getRole());
			auditorData.setPassword(auditor.getPassword());
			auditorData.setHeadcount(auditor.getHeadcount());
			auditorData.setNumberOfWorkingDays(auditor.getNumberOfWorkingDays());
			auditorData.setNumberOfDailyWorkHours(auditor.getNumberOfDailyWorkHours());
			auditorData.setTotalWorkingHours(auditor.getTotalWorkingHours());
			auditorData.setAnnualLeaves(auditor.getAnnualLeaves());
			auditorData.setMaternityLeaves(auditor.getMaternityLeaves());
			auditorData.setAnnualPlanningActivities(auditor.getAnnualPlanningActivities());
			auditorData.setContinuousAudit(auditor.getContinuousAudit());
			auditorData.setAdministrativeActivities(auditor.getAdministrativeActivities());
			auditorData.setContingencyBudget(auditor.getContingencyBudget());
			auditorData.setTotalAdjustment(auditor.getTotalAdjustment());
			auditorData.setAvailableHoursAudit(auditor.getAvailableHoursAudit());
			auditorData.setActualAllocatedManhours(auditor.getActualAllocatedManhours());
			auditorData.setExcessShort(auditor.getExcessShort());
				
			return new ResponseEntity<>(auditorRepo.save(auditorData),HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/auditors")
	public ResponseEntity<HttpStatus> deleteAllAuditors(){
		try {
			auditorRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
