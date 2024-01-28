package com.example.audit_planner.model;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditeeRepository extends JpaRepository<Auditee, Long> {

	List<Auditee> findByUnit(String unit);
	List<Auditee> findBySector(String sector);
	Auditee findById(long id);
	
}
