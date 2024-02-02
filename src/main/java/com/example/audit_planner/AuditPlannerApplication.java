package com.example.audit_planner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.audit_planner.model.AssessmentScore;
import com.example.audit_planner.model.AssessmentScoreRepository;
import com.example.audit_planner.model.Auditee;
import com.example.audit_planner.model.AuditeeRepository;
import com.example.audit_planner.model.Auditor;
import com.example.audit_planner.model.AuditorRepository;
import com.example.audit_planner.model.PreviousAudit;
import com.example.audit_planner.model.PreviousAuditRepository;

@SpringBootApplication
public class AuditPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditPlannerApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(AuditeeRepository auditeeRepo, AuditorRepository auditorRepo, PreviousAuditRepository previousAuditRepo, 
			AssessmentScoreRepository assessmentScoreRepo) {
		return args ->{
			List<Auditee>auditees = new ArrayList<>();
			
			auditees.add(new Auditee("Sales","Global Markets"));
			auditees.add(new Auditee("Wealth Management","Community Financial Services"));
			auditees.add(new Auditee("Commercial Banking Division","Community Financial Services"));
			auditees.add(new Auditee("Cards & Personal Loans","Community Financial Services"));
			auditees.add(new Auditee("Retail Loans","Community Financial Services"));
			auditees.add(new Auditee("Distribution Channel Service","Operations"));
			auditees.add(new Auditee("Treasury","Operations"));
			auditees.add(new Auditee("Credit Doc & Admin","Operations"));
			auditees.add(new Auditee("Operations & Payment Support","Operations"));
			auditees.add(new Auditee("Planning & Service Management","Operations"));
			auditees.add(new Auditee("Property Services","Operations"));
			auditees.add(new Auditee("Rewards","Human Capital"));
			auditees.add(new Auditee("Resourcing & Workforce Management","Human Capital"));
			auditees.add(new Auditee("Financial Analytics","Finance"));
			auditees.add(new Auditee("Financial Management","Finance"));
			auditees.add(new Auditee("Products Control","Finance"));
			auditees.add(new Auditee("Remedial Management","Finance"));
			auditees.add(new Auditee("Tax","Finance"));
			auditees.add(new Auditee("Credit Management","Risk Management"));
			auditees.add(new Auditee("Traded Risk Management","Risk Management"));
			auditees.add(new Auditee("Portfolio Risk Management","Risk Management"));
			auditees.add(new Auditee("Operational Risk Management","Risk Management"));
			auditees.add(new Auditee("Enterprise Risk Management","Risk Management"));
			auditees.add(new Auditee("Transformation Office","Strategy"));
			auditees.add(new Auditee("Digital Banking","Strategy"));
			auditees.add(new Auditee("Sustainability Office","Strategy"));
			auditees.add(new Auditee("Legal-Global Banking","Legal & Corporate Office"));
			auditees.add(new Auditee("Legal-CFS Support","Legal & Corporate Office"));
			auditees.add(new Auditee("Corporate Affairs","Country Corporate Office"));
			auditees.add(new Auditee("Financial Crime Compliance","Compliance"));
			auditees.add(new Auditee("Regulatory Monitoring","Compliance"));
			auditees.add(new Auditee("Regulatory Affairs","Compliance"));
			auditees.add(new Auditee("Core Banking and Data Warehouse","Technology"));
			auditees.add(new Auditee("Wealth, Branch Channel and Treasury","Technology"));
			auditees.add(new Auditee("Digital Channels","Technology"));
			auditees.add(new Auditee("Cards","Technology"));
			auditees.add(new Auditee("Trade","Technology"));
			auditees.add(new Auditee("Technology Infrastructure","Technology"));
			auditees.add(new Auditee("Technology Risk Management","Technology"));
			auditees.add(new Auditee("IT Security Defense","Technology"));
			auditees.add(new Auditee("Finance and Corporate Function","Technology"));
			
			// For auditee at index 0
			auditees.get(0).addAssessmentScore(new AssessmentScore("Change", 0.20, 2, 7, 4, 9, 1, 6, 0, 8, 3, 2, 0, 1, 5, 6, 7, 8, 9, 4));
			auditees.get(0).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15, 3, 6, 2, 9, 4, 5, 1, 7, 8, 0, 2, 3, 5, 6, 7, 9, 1, 4));
			auditees.get(0).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10, 1, 5, 7, 0, 8, 2, 3, 4, 9, 6, 0, 1, 2, 4, 5, 7, 8, 3));
			auditees.get(0).addAssessmentScore(new AssessmentScore("Financial", 0.10, 6, 2, 1, 0, 7, 3, 5, 8, 9, 4, 1, 2, 3, 5, 7, 8, 0, 6));
			auditees.get(0).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10, 9, 5, 0, 3, 8, 2, 1, 6, 7, 4, 0, 2, 3, 5, 7, 8, 1, 4));
			auditees.get(0).addAssessmentScore(new AssessmentScore("Complexity", 0.10, 8, 4, 1, 9, 6, 3, 5, 0, 7, 2, 8, 0, 1, 2, 4, 5, 7, 9));
			auditees.get(0).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10, 3, 7, 8, 0, 2, 1, 6, 9, 4, 5, 3, 0, 2, 4, 5, 7, 8, 6));
			auditees.get(0).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10, 5, 9, 6, 4, 0, 2, 3, 1, 7, 2, 3, 5, 7, 8, 1, 4, 6, 9));
			auditees.get(0).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05, 4, 2, 1, 0, 8, 3, 9, 6, 7, 5, 0, 2, 3, 5, 7, 4, 6, 9));

			// For auditee at index 1
			auditees.get(1).addAssessmentScore(new AssessmentScore("Change", 0.20, 7, 4, 9, 1, 6, 0, 8, 3, 2, 0, 1, 5, 6, 7, 8, 9, 4, 3));
			auditees.get(1).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15, 6, 2, 9, 4, 5, 1, 7, 8, 0, 2, 3, 5, 6, 7, 9, 1, 4, 8));
			auditees.get(1).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10, 5, 7, 0, 8, 2, 3, 4, 9, 6, 0, 1, 2, 4, 5, 7, 8, 3, 9));
			auditees.get(1).addAssessmentScore(new AssessmentScore("Financial", 0.10, 2, 1, 0, 7, 3, 5, 8, 9, 4, 1, 2, 3, 5, 7, 8, 0, 6, 9));
			auditees.get(1).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10, 5, 0, 3, 8, 2, 1, 6, 7, 4, 0, 2, 3, 5, 7, 8, 1, 4, 6));
			auditees.get(1).addAssessmentScore(new AssessmentScore("Complexity", 0.10, 4, 1, 9, 6, 3, 5, 0, 7, 2, 8, 0, 1, 2, 4, 5, 7, 9, 6));
			auditees.get(1).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10, 7, 8, 0, 2, 1, 6, 9, 4, 5, 3, 0, 2, 4, 5, 7, 8, 6, 9));
			auditees.get(1).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10, 9, 6, 4, 0, 2, 3, 1, 7, 8, 0, 2, 3, 5, 7, 8, 6, 9, 5));
			auditees.get(1).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05, 2, 1, 0, 8, 3, 9, 6, 7, 5, 0, 2, 3, 5, 7, 8, 6, 9, 4));
			
			// For auditee at index 2
			auditees.get(2).addAssessmentScore(new AssessmentScore("Change", 0.20, 2, 3, 1, 0, 7, 8, 9, 4, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(2).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15, 1, 3, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(2).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10, 3, 0, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(2).addAssessmentScore(new AssessmentScore("Financial", 0.10, 1, 2, 3, 0, 7, 8, 9, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
			auditees.get(2).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10, 0, 2, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(2).addAssessmentScore(new AssessmentScore("Complexity", 0.10, 2, 3, 1, 0, 7, 8, 9, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(2).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10, 3, 2, 1, 0, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
			auditees.get(2).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10, 3, 0, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
			auditees.get(2).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05, 2, 1, 3, 0, 7, 8, 9, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));

			// For auditee at index 4
			auditees.get(4).addAssessmentScore(new AssessmentScore("Change", 0.20, 2, 3, 1, 0, 7, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(4).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15, 1, 0, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(4).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10, 1, 2, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(4).addAssessmentScore(new AssessmentScore("Financial", 0.10, 1, 2, 3, 0, 7, 8, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
			auditees.get(4).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10, 0, 2, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(4).addAssessmentScore(new AssessmentScore("Complexity", 0.10, 2, 3, 1, 0, 7, 8, 9, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			auditees.get(4).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10, 3, 2, 1, 0, 7, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
			auditees.get(4).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10, 1, 0, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
			auditees.get(4).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05, 2, 1, 3, 0, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
			
			auditees.get(5).addAssessmentScore(new AssessmentScore("Change", 0.20));
			auditees.get(5).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15));
			auditees.get(5).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10));
			auditees.get(5).addAssessmentScore(new AssessmentScore("Financial", 0.10));
			auditees.get(5).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10));
			auditees.get(5).addAssessmentScore(new AssessmentScore("Complexity", 0.10));
			auditees.get(5).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10));
			auditees.get(5).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10));
			auditees.get(5).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05));
			
					
			auditeeRepo.saveAll(auditees);

			auditeeRepo.findAll().forEach(System.out::println);
							
			List<Auditor>auditors = new ArrayList<>();
			auditors.add(new Auditor("Operations","Clara","Manager"));
			auditors.add(new Auditor("Credit","Farhana","Manager"));
			auditors.add(new Auditor("Technology","Sunny","Manager"));
			auditors.add(new Auditor("Treasury","Chee Wan","Manager"));
			
			auditorRepo.saveAll(auditors);
			
			auditorRepo.findAll().forEach(System.out::println);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			List<PreviousAudit> previousAudits = new ArrayList<>();
			previousAudits.add(new PreviousAudit(auditees.get(0),"Medium",dateFormat.parse("2023-01-30"),"Medium",2,1,0,0,1,3));
			previousAudits.add(new PreviousAudit(auditees.get(1),"Medium",dateFormat.parse("2023-02-15"),"Medium",2,1,0,0,1,3));
			previousAudits.add(new PreviousAudit(auditees.get(3),"High",dateFormat.parse("2023-03-10"),"Medium",2,1,0,0,1,4));
	
			previousAuditRepo.saveAll(previousAudits);
			previousAuditRepo.findAll().forEach(System.out::println);	
				
//			List<AssessmentScore> assessmentScores = assessmentScoreRepo.findAll();
//			List<AssessmentScore>assessmentScores5= new ArrayList<>();
//									
//			for (int i=0; i<assessmentScores.size();i++) {
//				if (assessmentScores.get(i).getAuditee().getId()==5) {
//					assessmentScores5.add(assessmentScores.get(i));
//
//				}
//			}
//			
//			for (int i=0; i<assessmentScores5.size();i++) {
//				System.out.println(assessmentScores5.get(i).getFactorName());
//				}
			
			
		};
	}

}
