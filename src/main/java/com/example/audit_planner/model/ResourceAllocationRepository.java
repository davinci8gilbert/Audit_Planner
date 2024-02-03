package com.example.audit_planner.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceAllocationRepository extends JpaRepository<ResourceAllocation, Long> {

	List<ResourceAllocation> findByAuditeeId(long auditeeId);
	ResourceAllocation findById(long id);
	
	
}
