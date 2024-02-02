package com.example.audit_planner.model;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PreviousAuditRepository extends JpaRepository<PreviousAudit, Long> {

	List<PreviousAudit> findByAuditeeId(long auditeeId);
	PreviousAudit findById(long id);
	
		
	@Query(value="SELECT PA FROM PreviousAudit PA LEFT JOIN FETCH PA.auditee")
	List<PreviousAudit> findAllEagerly();
	
}
