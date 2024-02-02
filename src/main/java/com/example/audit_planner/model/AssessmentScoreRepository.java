package com.example.audit_planner.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentScoreRepository extends JpaRepository<AssessmentScore, Long> {

	List<AssessmentScore> findByAuditeeId(long auditeeId);
	AssessmentScore findById(long id);
	
}
