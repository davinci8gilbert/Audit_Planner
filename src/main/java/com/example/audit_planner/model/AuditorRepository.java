package com.example.audit_planner.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditorRepository extends JpaRepository<Auditor, Long> {

	List<Auditor> findByTeamName(String teamName);
	Auditor findById(long id);
}
