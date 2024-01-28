package com.example.audit_planner.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
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
import com.example.audit_planner.model.AuditeeRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class AuditeeController {
	
	@Autowired
	AuditeeRepository auditeeRepo;
	
	@GetMapping("/auditees")
	public ResponseEntity<List<Auditee>> getAllAuditees(@RequestParam(required=false) String unit){
		try {
			List<Auditee> auditees = new ArrayList<Auditee>();
			
			if (unit == null) auditeeRepo.findAll().forEach(auditees::add);
			else auditeeRepo.findByUnit(unit).forEach(auditees::add);
			
			if(auditees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(auditees, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/auditees/{id}")
	public ResponseEntity<Auditee> getAuditeeById(@PathVariable("id") long id){
		Auditee auditeeData = auditeeRepo.findById(id);
		
		if(auditeeData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(auditeeData,HttpStatus.OK);
		}
	}
	
	@PostMapping("/auditees")
	public ResponseEntity<Auditee> createAuditee(@RequestBody Auditee auditee){
		try {
			Auditee _auditee = auditeeRepo.save(new Auditee(auditee.getUnit(),auditee.getSector()));
			return new ResponseEntity<>(_auditee,HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/auditees/{id}")
	public ResponseEntity<Auditee> updateAuditee(@PathVariable("id")long id, @RequestBody Auditee auditee){
		Auditee auditeeData = auditeeRepo.findById(id);
		if(auditeeData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			auditeeData.setUnit(auditee.getUnit());
			auditeeData.setSector(auditee.getSector());
			return new ResponseEntity<>(auditeeRepo.save(auditeeData),HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/auditees")
	public ResponseEntity<HttpStatus> deleteAllAuditees(){
		try {
			auditeeRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/auditees/{id}")
	public ResponseEntity<HttpStatus>deleteAuditee(@PathVariable("id")long id){
		try {
			auditeeRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
}
