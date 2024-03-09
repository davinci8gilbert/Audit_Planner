package com.example.audit_planner.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.audit_planner.model.Auditor;
import com.example.audit_planner.model.ResourceAllocation;
import com.example.audit_planner.model.ResourceAllocationRepository;

@CrossOrigin(origins="http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ResourceAllocationController {

	@Autowired
	ResourceAllocationRepository resourceAllocationRepo;
	
	@GetMapping("/resourceallocations")
	public ResponseEntity<List<ResourceAllocation>> getAllResourceAllocations(@RequestParam(required = false) 
	Long auditeeId) {
		try {
			List<ResourceAllocation> resourceAllocations = new ArrayList<ResourceAllocation>();

			if (auditeeId == null)
				resourceAllocationRepo.findAll().forEach(resourceAllocations::add);
			else
				resourceAllocationRepo.findByAuditeeId(auditeeId).forEach(resourceAllocations::add);

			if (resourceAllocations.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(resourceAllocations, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/resourceallocations/{id}")
	public ResponseEntity<ResourceAllocation> getResourceById(@PathVariable("id") long id) {
		ResourceAllocation resourceAllocation = resourceAllocationRepo.findById(id);

		if (resourceAllocation != null) {
			return new ResponseEntity<>(resourceAllocation, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/resourceallocations")
	public ResponseEntity<?> createResourceAllocation(@RequestBody ResourceAllocation resourceAllocation){
		try {
			ResourceAllocation _resourceAllocation = resourceAllocationRepo.save(new ResourceAllocation
					(resourceAllocation.getAuditee(),resourceAllocation.getBenchmarkResult(),resourceAllocation.getAuditStatus()));
			
			return new ResponseEntity<>(_resourceAllocation,HttpStatus.CREATED);
		}catch (Exception e) {
//			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			return new ResponseEntity<>("Failed to create resource allocation: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//update the equal allocation. at the front-end a loop can be generated to update only the applicable auditees
	@PutMapping("/resourceallocations/{id}")
	public ResponseEntity<ResourceAllocation> updateResourceAllocation(@PathVariable("id") long id, 
			@RequestBody ResourceAllocation resourceAllocation) {
		
		ResourceAllocation _resourceAllocation = resourceAllocationRepo.findById(id);

		if (_resourceAllocation !=null) {
			_resourceAllocation.setEqualAllocation(resourceAllocation.getEqualAllocation());
			return new ResponseEntity<>(resourceAllocationRepo.save(_resourceAllocation), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//to manually update the manhours
	@PutMapping("/resourceallocationsmanualadj/{id}")
	public ResponseEntity<ResourceAllocation> updateAdjustedManhours(@PathVariable("id") long id, 
			@RequestBody ResourceAllocation resourceAllocation) {
		
		ResourceAllocation _resourceAllocation = resourceAllocationRepo.findById(id);

		if (_resourceAllocation !=null) {
			_resourceAllocation.setAdjustedManhours(resourceAllocation.getAdjustedManhours());
			return new ResponseEntity<>(resourceAllocationRepo.save(_resourceAllocation), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	input of both allocated manhours and adjusted manhours
	@PutMapping("/resourceallocmanhours/{id}")
	public ResponseEntity<ResourceAllocation> updateAdjustedAllocManhours(@PathVariable("id") long id, 
			@RequestBody ResourceAllocation resourceAllocation) {
		
		ResourceAllocation _resourceAllocation = resourceAllocationRepo.findById(id);

		if (_resourceAllocation !=null) {
			_resourceAllocation.setEqualAllocation(resourceAllocation.getEqualAllocation());
			_resourceAllocation.setAdjustedManhours(resourceAllocation.getAdjustedManhours());
			_resourceAllocation.setAuditStatus(resourceAllocation.getAuditStatus());
			_resourceAllocation.setManhourAdjustment(resourceAllocation.getManhourAdjustment());
			return new ResponseEntity<>(resourceAllocationRepo.save(_resourceAllocation), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/resourceallocmanhoursreason/{id}")
	public ResponseEntity<ResourceAllocation> updateAdjustedAllocManhoursReason(@PathVariable("id") long id, 
			@RequestBody ResourceAllocation resourceAllocation) {
		
		ResourceAllocation _resourceAllocation = resourceAllocationRepo.findById(id);

		if (_resourceAllocation !=null) {
			_resourceAllocation.setEqualAllocation(resourceAllocation.getEqualAllocation());
			_resourceAllocation.setAdjustedManhours(resourceAllocation.getAdjustedManhours());
			_resourceAllocation.setAuditStatus(resourceAllocation.getAuditStatus());
			_resourceAllocation.setManhourAdjustment(resourceAllocation.getManhourAdjustment());
			_resourceAllocation.setOverrideReason(resourceAllocation.getOverrideReason());
			return new ResponseEntity<>(resourceAllocationRepo.save(_resourceAllocation), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/resourcetable/{id}")
	public ResponseEntity<ResourceAllocation> updateResourceTable(@PathVariable("id") long id, 
			@RequestBody ResourceAllocation resourceAllocation) {
		
		ResourceAllocation _resourceAllocation = resourceAllocationRepo.findById(id);

		if (_resourceAllocation !=null) {
			_resourceAllocation.setAuditee(resourceAllocation.getAuditee());
			_resourceAllocation.setBenchmarkResult(resourceAllocation.getBenchmarkResult());
			_resourceAllocation.setAuditStatus(resourceAllocation.getAuditStatus());
			return new ResponseEntity<>(resourceAllocationRepo.save(_resourceAllocation), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
