package com.example.audit_planner.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentSummaryRepository extends JpaRepository<AssessmentSummary, Long> {

	List<AssessmentSummary> findByAuditeeId(long auditeeId);
	AssessmentSummary findById(long id);
	List<AssessmentSummary> findAll();
	
}
