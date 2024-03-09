package com.example.audit_planner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.audit_planner.model.AssessmentScore;
import com.example.audit_planner.model.AssessmentScoreRepository;
import com.example.audit_planner.model.AssessmentSummary;
import com.example.audit_planner.model.AssessmentSummaryRepository;
import com.example.audit_planner.model.Auditee;
import com.example.audit_planner.model.AuditeeRepository;
import com.example.audit_planner.model.Auditor;
import com.example.audit_planner.model.AuditorRepository;
import com.example.audit_planner.model.PreviousAudit;
import com.example.audit_planner.model.PreviousAuditRepository;
import com.example.audit_planner.model.ResourceAllocation;
import com.example.audit_planner.model.ResourceAllocationRepository;

@SpringBootApplication
public class AuditPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditPlannerApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(AuditorRepository auditorRepo, AuditeeRepository auditeeRepo,  PreviousAuditRepository previousAuditRepo, 
			AssessmentScoreRepository assessmentScoreRepo,AssessmentSummaryRepository assessmentSummaryRepo,
			ResourceAllocationRepository resourceAllocationRepo) {
		return args ->{
			
			//instantiation of auditors
			List<Auditor>auditors = new ArrayList<>();
			auditors.add(new Auditor("Operations","Clara","Manager","claramanager","manager123",4,230,8,7360,480,0,200,300,100,300,1380,5980,0,0));
			auditors.add(new Auditor("Credit","Farhana","Manager","farhanamanager","manager123",5,230,8,9200,600,0,200,350,125,350,1625,7575,0,0));
			auditors.add(new Auditor("Technology","Sunny","Manager","sunnymanager","manager123"));
			auditors.add(new Auditor("Treasury","Chee Wan","Manager","cheewanmanager","manager123",3,230,8,5520,360,0,200,250,75,275,1160,4360,0,0));
			auditors.add(new Auditor("Head of Audit","Gilbert Gule","Chief","gilbertchief","chief123"));
			
			auditorRepo.saveAll(auditors);
			
			auditorRepo.findAll().forEach(System.out::println);
			
			//----------------------------------------------------------------------------------------------------------
			
			
			//instantiation of "auditees"
			List<Auditee>auditees = new ArrayList<>();
						
			auditees.add(new Auditee("Sales","Global Markets",auditors.get(4-1)));
			auditees.add(new Auditee("Wealth Management","Community Financial Services",auditors.get(1-1)));
			auditees.add(new Auditee("Commercial Banking Division","Community Financial Services",auditors.get(2-1)));
			auditees.add(new Auditee("Cards & Personal Loans","Community Financial Services",auditors.get(2-1)));
			auditees.add(new Auditee("Retail Loans","Community Financial Services",auditors.get(2-1)));
			auditees.add(new Auditee("Distribution Channel Service","Operations",auditors.get(1-1)));
			auditees.add(new Auditee("Treasury","Operations",auditors.get(4-1)));
			auditees.add(new Auditee("Credit Doc & Admin","Operations",auditors.get(2-1)));
			auditees.add(new Auditee("Operations & Payment Support","Operations",auditors.get(1-1)));
			auditees.add(new Auditee("Planning & Service Management","Operations",auditors.get(1-1)));
			auditees.add(new Auditee("Property Services","Operations",auditors.get(1-1)));
			auditees.add(new Auditee("Rewards","Human Capital",auditors.get(1-1)));
			auditees.add(new Auditee("Resourcing & Workforce Management","Human Capital",auditors.get(1-1)));
			auditees.add(new Auditee("Financial Analytics","Finance",auditors.get(2-1)));
			auditees.add(new Auditee("Financial Management","Finance",auditors.get(2-1)));
			auditees.add(new Auditee("Products Control","Finance",auditors.get(4-1)));
			auditees.add(new Auditee("Remedial Management","Finance",auditors.get(2-1)));
			auditees.add(new Auditee("Tax","Finance",auditors.get(1-1)));
			auditees.add(new Auditee("Credit Management","Risk Management",auditors.get(2-1)));
			auditees.add(new Auditee("Traded Risk Management","Risk Management",auditors.get(4-1)));
			auditees.add(new Auditee("Portfolio Risk Management","Risk Management",auditors.get(2-1)));
			auditees.add(new Auditee("Operational Risk Management","Risk Management",auditors.get(1-1)));
			auditees.add(new Auditee("Enterprise Risk Management","Risk Management",auditors.get(4-1)));
			auditees.add(new Auditee("Transformation Office","Strategy",auditors.get(1-1)));
			auditees.add(new Auditee("Digital Banking","Strategy",auditors.get(3-1)));
			auditees.add(new Auditee("Sustainability Office","Strategy",auditors.get(1-1)));
			auditees.add(new Auditee("Legal-Global Banking","Legal & Corporate Office",auditors.get(4-1)));
			auditees.add(new Auditee("Legal-CFS Support","Legal & Corporate Office",auditors.get(2-1)));
			auditees.add(new Auditee("Corporate Affairs","Country Corporate Office",auditors.get(1-1)));
			auditees.add(new Auditee("Financial Crime Compliance","Compliance",auditors.get(1-1)));
			auditees.add(new Auditee("Regulatory Monitoring","Compliance",auditors.get(4-1)));
			auditees.add(new Auditee("Regulatory Affairs","Compliance",auditors.get(4-1)));
			auditees.add(new Auditee("Core Banking and Data Warehouse","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("Wealth, Branch Channel and Treasury","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("Digital Channels","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("Cards","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("Trade","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("Technology Infrastructure","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("Technology Risk Management","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("IT Security Defense","Technology",auditors.get(3-1)));
			auditees.add(new Auditee("Finance and Corporate Function","Technology",auditors.get(3-1)));
	
			
//		------------------------------------------------------------------------------------------------	
			//setting up of scores
			
			//medium
			for (int i = 0; i< 15;i++) {
				
				auditees.get(i).addAssessmentScore(new AssessmentScore("Change", 0.20, 2, 3, 1, 0, 7, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15, 1, 0, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10, 1, 2, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Financial", 0.10, 1, 2, 3, 0, 7, 8, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
				auditees.get(i).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10, 0, 2, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Complexity", 0.10, 2, 3, 1, 0, 7, 8, 9, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
				auditees.get(i).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10, 3, 2, 1, 0, 7, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10, 1, 0, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05, 2, 1, 3, 0, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
				
				auditeeRepo.saveAll(auditees);
			}
			//low risk
			for (int i = 15; i< 20;i++) {
				
				auditees.get(i).addAssessmentScore(new AssessmentScore("Change", 0.20, 0, 1, 2, 3, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15, 1, 0, 2, 3, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10, 2, 3, 0, 1, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Financial", 0.10, 3, 0, 1, 2, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10, 0, 1, 2, 3, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Complexity", 0.10, 1, 2, 3, 0, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10, 2, 3, 0, 1, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10, 3, 0, 1, 2, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05, 0, 1, 2, 3, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
			
				auditeeRepo.saveAll(auditees);
			}
					
			//high
			for (int i = 20; i< 30;i++) {
				
				auditees.get(i).addAssessmentScore(new AssessmentScore("Change", 0.20, 8, 9, 10, 10, 10, 10, 8, 8, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15, 8, 8, 8, 9, 10, 8, 9, 10, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10, 8, 9, 10, 8, 9, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Financial", 0.10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10));
				auditees.get(i).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Complexity", 0.10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10));
				auditees.get(i).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10, 8, 9, 10));
				
				auditeeRepo.saveAll(auditees);
			}
			
			//medium
			for (int i = 30; i< 38;i++) {
				
				auditees.get(i).addAssessmentScore(new AssessmentScore("Change", 0.20, 2, 3, 1, 0, 7, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15, 1, 0, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10, 1, 2, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Financial", 0.10, 1, 2, 3, 0, 7, 8, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
				auditees.get(i).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10, 0, 2, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Complexity", 0.10, 2, 3, 1, 0, 7, 8, 9, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
				auditees.get(i).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10, 3, 2, 1, 0, 7, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10, 1, 0, 7, 8, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 4, 6, 7));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05, 2, 1, 3, 0, 9, 4, 5, 6, 0, 2, 3, 5, 7, 8, 9, 1, 4, 6));
				
				auditeeRepo.saveAll(auditees);
			}
			
			//low
			for (int i = 38; i< 41;i++) {
				
				auditees.get(i).addAssessmentScore(new AssessmentScore("Change", 0.20, 0, 1, 2, 3, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15, 1, 0, 2, 3, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10, 2, 3, 0, 1, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Financial", 0.10, 3, 0, 1, 2, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10, 0, 1, 2, 3, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Complexity", 0.10, 1, 2, 3, 0, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10, 2, 3, 0, 1, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10, 3, 0, 1, 2, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));
				auditees.get(i).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05, 0, 1, 2, 3, 3, 2, 1, 0, 2, 3, 3, 3, 3, 3, 3, 1, 3, 2));

				
				auditeeRepo.saveAll(auditees);
			}
			
			
		

			auditeeRepo.findAll().forEach(System.out::println);
			
			
			//alternative to only put in the factor name and factor weight:
//				for (int i = 0; i< auditees.size();i++) {
//				
//				auditees.get(i).addAssessmentScore(new AssessmentScore("Change", 0.20));
//				auditees.get(i).addAssessmentScore(new AssessmentScore("Recent Audit Rating", 0.15));
//				auditees.get(i).addAssessmentScore(new AssessmentScore("Duration from Last Audit", 0.10));
//				auditees.get(i).addAssessmentScore(new AssessmentScore("Financial", 0.10));
//				auditees.get(i).addAssessmentScore(new AssessmentScore("New Regulatory Requirements", 0.10));
//				auditees.get(i).addAssessmentScore(new AssessmentScore("Complexity", 0.10));
//				auditees.get(i).addAssessmentScore(new AssessmentScore("IT System Risk", 0.10));
//				auditees.get(i).addAssessmentScore(new AssessmentScore("Risk Rating of Recent Incidents", 0.10));
//				auditees.get(i).addAssessmentScore(new AssessmentScore("Emerging Risks", 0.05));
//				
//				auditeeRepo.saveAll(auditees);
//			}
//				auditeeRepo.findAll().forEach(System.out::println);
//			
			
			//---------------------------------------------------------------------------------------------------------
			
			
			
			//instantiation of PreviousAudit
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			List<PreviousAudit> previousAudits = new ArrayList<>();
			previousAudits.add(new PreviousAudit(auditees.get(0),"Medium Risk",dateFormat.parse("2023-01-30"),"Satisfactory",0,1,3,0,1,3));
			previousAudits.add(new PreviousAudit(auditees.get(1),"Medium Risk",dateFormat.parse("2022-02-15"),"Satisfactory",0,1,1,2,1,0));
			previousAudits.add(new PreviousAudit(auditees.get(2),"Low Risk",dateFormat.parse("2023-02-28"),"Not Audited",0,0,0,0,1,2));
			previousAudits.add(new PreviousAudit(auditees.get(3),"Low Risk",dateFormat.parse("2023-03-1"),"Not Audited",0,0,1,0,1,1));
			previousAudits.add(new PreviousAudit(auditees.get(4),"High Risk",dateFormat.parse("2023-03-10"),"Needs Improvement",4,3,3,1,1,4));
			previousAudits.add(new PreviousAudit(auditees.get(5),"High Risk",dateFormat.parse("2022-03-20"),"Needs Improvement",3,5,1,3,1,4));
			previousAudits.add(new PreviousAudit(auditees.get(6),"Medium Risk",dateFormat.parse("2023-03-25"),"Satisfactory",1,4,3,0,1,4));
			previousAudits.add(new PreviousAudit(auditees.get(7),"Medium Risk",dateFormat.parse("2023-04-2"),"Needs Improvement",4,3,1,1,2,4));
			previousAudits.add(new PreviousAudit(auditees.get(8),"Medium Risk",dateFormat.parse("2022-04-5"),"Satisfactory",1,1,0,0,1,1));
			previousAudits.add(new PreviousAudit(auditees.get(9),"High Risk",dateFormat.parse("2023-04-10"),"Needs Improvement",4,2,2,2,1,4));
			previousAudits.add(new PreviousAudit(auditees.get(10),"Low Risk",dateFormat.parse("2023-04-15"),"Satisfactory",0,1,0,0,0,0));
			previousAudits.add(new PreviousAudit(auditees.get(11),"Medium Risk",dateFormat.parse("2022-05-5"),"Satisfactory",0,2,1,1,0,1));
			previousAudits.add(new PreviousAudit(auditees.get(12),"Medium Risk",dateFormat.parse("2023-05-15"),"Satisfactory",0,3,2,1,1,1));
			previousAudits.add(new PreviousAudit(auditees.get(13),"Medium Risk",dateFormat.parse("2022-05-31"),"Satisfactory",0,5,1,3,2,1));
			previousAudits.add(new PreviousAudit(auditees.get(14),"Medium Risk",dateFormat.parse("2023-06-5"),"Needs Improvement",5,3,4,5,5,1));
			previousAudits.add(new PreviousAudit(auditees.get(15),"Low Risk",dateFormat.parse("2023-06-10"),"Needs Improvement",2,5,4,5,4,3));
			previousAudits.add(new PreviousAudit(auditees.get(16),"Low Risk",dateFormat.parse("2023-06-12"),"Satisfactory",0,1,5,0,1,4));
			previousAudits.add(new PreviousAudit(auditees.get(17),"Medium Risk",dateFormat.parse("2022-06-18"),"Satisfactory",0,3,5,0,1,1));
			previousAudits.add(new PreviousAudit(auditees.get(18),"High Risk",dateFormat.parse("2023-07-1"),"Poor",5,4,5,2,1,4));
			previousAudits.add(new PreviousAudit(auditees.get(19),"Low Risk",dateFormat.parse("2023-07-5"),"Poor",2,12,3,4,3,1));
			previousAudits.add(new PreviousAudit(auditees.get(20),"Medium Risk",dateFormat.parse("2023-07-10"),"Needs Improvement",4,2,0,3,2,7));
			previousAudits.add(new PreviousAudit(auditees.get(21),"Medium Risk",dateFormat.parse("2023-07-19"),"Satisfactory",0,2,5,0,0,2));
			previousAudits.add(new PreviousAudit(auditees.get(22),"Medium Risk",dateFormat.parse("2022-08-2"),"Fail",10,5,3,2,3,1));
			previousAudits.add(new PreviousAudit(auditees.get(23),"High Risk",dateFormat.parse("2022-08-3"),"Satisfactory",0,1,1,0,0,1));
			previousAudits.add(new PreviousAudit(auditees.get(24),"High Risk",dateFormat.parse("2023-08-12"),"Needs Improvement",2,2,2,3,2,1));
			previousAudits.add(new PreviousAudit(auditees.get(25),"Low Risk",dateFormat.parse("2022-09-2"),"Satisfactory",0,3,3,0,1,1));
			previousAudits.add(new PreviousAudit(auditees.get(26),"Medium Risk",dateFormat.parse("2023-09-8"),"Satisfactory",0,2,2,3,3,3));
			previousAudits.add(new PreviousAudit(auditees.get(27),"Medium Risk",dateFormat.parse("2023-09-17"),"Unsatisfactory",15,12,3,1,1,1));
			previousAudits.add(new PreviousAudit(auditees.get(28),"Low Risk",dateFormat.parse("2023-09-20"),"Not Audited",0,0,0,0,1,4));
			previousAudits.add(new PreviousAudit(auditees.get(29),"Medium Risk",dateFormat.parse("2023-10-10"),"Needs Improvement",2,4,0,0,7,2));
			previousAudits.add(new PreviousAudit(auditees.get(30),"High Risk",dateFormat.parse("2023-10-12"),"Satisfactory",0,1,0,0,1,1));
			previousAudits.add(new PreviousAudit(auditees.get(31),"High Risk",dateFormat.parse("2023-10-15"),"Fail",7,5,0,0,1,8));
			previousAudits.add(new PreviousAudit(auditees.get(32),"Medium Risk",dateFormat.parse("2022-10-16"),"Satisfactory",0,1,5,4,2,1));
			previousAudits.add(new PreviousAudit(auditees.get(33),"Medium Risk",dateFormat.parse("2023-10-25"),"Satisfactory",0,4,1,3,1,1));
			previousAudits.add(new PreviousAudit(auditees.get(34),"Medium Risk",dateFormat.parse("2023-11-1"),"Satisfactory",1,0,1,0,1,1));
			previousAudits.add(new PreviousAudit(auditees.get(35),"High Risk",dateFormat.parse("2023-11-5"),"Satisfactory",0,1,0,6,2,0));
			previousAudits.add(new PreviousAudit(auditees.get(36),"Low Risk",dateFormat.parse("2023-11-9"),"Satisfactory",0,4,2,0,1,5));
			previousAudits.add(new PreviousAudit(auditees.get(37),"Medium Risk",dateFormat.parse("2022-11-19"),"Satisfactory",0,1,3,0,5,4));
			previousAudits.add(new PreviousAudit(auditees.get(38),"High Risk",dateFormat.parse("2023-12-1"),"Needs Improvement",3,5,4,4,5,6));
			previousAudits.add(new PreviousAudit(auditees.get(39),"Low Risk",dateFormat.parse("2023-12-12"),"Needs Improvement",4,4,4,0,2,3));
			previousAudits.add(new PreviousAudit(auditees.get(40),"Medium Risk",dateFormat.parse("2023-12-18"),"Satisfactory",0,1,7,7,6,1));
			
			
			previousAuditRepo.saveAll(previousAudits);
			previousAuditRepo.findAll().forEach(System.out::println);	
				
			//----------------------------------------------------------------------------------------------------------
			
			
			List<AssessmentSummary>assessmentSummaries1 = new ArrayList<>();
			for(int i=0; i< auditees.size();i++) {
				assessmentSummaries1.add(new AssessmentSummary(auditees.get(i)));
			}
			assessmentSummaryRepo.saveAll(assessmentSummaries1);
			
			
			
			
			
			
			
			
			
			
			//instantiation of assessmentScores
//			List<AssessmentScore> assessmentScores = assessmentScoreRepo.findAll();
//						
//			double[] riskIndicators = new double[18]; // 18 risk indicators refer to the risks
//			int currentAuditeeId = -1; // Start with an invalid ID
//
//			for (int i = 0; i < assessmentScores.size(); i++) {
//			    int auditeeId = (int)assessmentScores.get(i).getAuditee().getId();
//
//			    if (auditeeId != currentAuditeeId) {
//			        if (currentAuditeeId != -1) {
//			        	//to post the weighted scores into the Assessment_Summary table
//			            AssessmentSummary assessmentSummary = new AssessmentSummary(
//			                    assessmentScores.get(i - 1).getAuditee(),
//			                    riskIndicators[0], riskIndicators[1], riskIndicators[2], riskIndicators[3],
//			                    riskIndicators[4], riskIndicators[5], riskIndicators[6], riskIndicators[7],
//			                    riskIndicators[8], riskIndicators[9], riskIndicators[10], riskIndicators[11],
//			                    riskIndicators[12], riskIndicators[13], riskIndicators[14], riskIndicators[15],
//			                    riskIndicators[16],riskIndicators[17]
//			            );
//			            assessmentSummaryRepo.save(assessmentSummary);
//
//			            // Reset risk indicators for the next auditee
//			            Arrays.fill(riskIndicators, 0);
//			        }
//
//			        currentAuditeeId = auditeeId;
//			    }
//
//			    //obtain the score per factor per risk and multiply with the weights
//			    riskIndicators[0] +=(int) Math.round((assessmentScores.get(i).getCreditRiskLoanPortfolioRisk())
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[1] += (int) Math.round(assessmentScores.get(i).getCreditRiskCounterpartyCreditRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[2] += (int) Math.round(assessmentScores.get(i).getMarketRiskInterestRateRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[3] += (int) Math.round(assessmentScores.get(i).getMaketRiskCommodityPriceRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[4] += (int) Math.round(assessmentScores.get(i).getOperationalRiskInternalProcessesRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[5] += (int) Math.round(assessmentScores.get(i).getOperationalRiskFraudMisconductRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[6] += (int) Math.round(assessmentScores.get(i).getOperationalRiskBusinessContinuityRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[7] += (int) Math.round(assessmentScores.get(i).getLiquidityRiskFundingLiquidityRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[8] +=(int) Math.round (assessmentScores.get(i).getLiquidityRiskContingencyFundingRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[9] += (int) Math.round(assessmentScores.get(i).getComplianceRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[10] += (int) Math.round(assessmentScores.get(i).getLegalRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[11] +=(int) Math.round (assessmentScores.get(i).getStrategyRiskBusinessModelRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[12] += (int) Math.round(assessmentScores.get(i).getStrategyRiskReputationalRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[13] +=(int) Math.round( assessmentScores.get(i).getCybersecurityRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[14] +=(int) Math.round( assessmentScores.get(i).getInterestRateRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[15] +=(int) Math.round( assessmentScores.get(i).getAmlFinancialCrimeRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[16] +=(int) Math.round (assessmentScores.get(i).getEsgRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			    riskIndicators[17] +=(int) Math.round( assessmentScores.get(i).getConductRisk()
//			    		*assessmentScores.get(i).getFactorWeight());
//			}
//
//			// Save the last AssessmentSummary
//			AssessmentSummary lastAssessmentSummary = new AssessmentSummary(
//			        assessmentScores.get(assessmentScores.size() - 1).getAuditee(),
//			        riskIndicators[0], riskIndicators[1], riskIndicators[2], riskIndicators[3],
//			        riskIndicators[4], riskIndicators[5], riskIndicators[6], riskIndicators[7],
//			        riskIndicators[8], riskIndicators[9], riskIndicators[10], riskIndicators[11],
//			        riskIndicators[12], riskIndicators[13], riskIndicators[14], riskIndicators[15],
//			        riskIndicators[16],riskIndicators[17]
//			);
//			assessmentSummaryRepo.save(lastAssessmentSummary);		

			//---------------------------------------------------------------------------------------------------------------
			
			//Resource Allocation instantiation for the auditable units
			//for now, it is based on those auditees from the AssessmentSummary Table with Medium or High Risk ratings
			//there should be another column that would specifically indicate whether the auditee is auditable or not
			//to accommodate overridess
			
//			List<AssessmentSummary>assessmentSummaries = assessmentSummaryRepo.findAll();
//			List<AssessmentSummary>auditableUnits = new ArrayList<>();
//			
//			for(int i =0; i<assessmentSummaries.size();i++) {
//				if(assessmentSummaries.get(i).getBenchmarkResults()=="Medium Risk"||
//						assessmentSummaries.get(i).getBenchmarkResults()=="High Risk") {
//					auditableUnits.add(assessmentSummaries.get(i));
//				}
//			}
//			
//			List<ResourceAllocation> resourceAllocations = new ArrayList<>();
//			Auditee auditee;
//			for(int i =0; i<auditableUnits.size();i++) {
//				
//				auditee=auditableUnits.get(i).getAuditee();
//				resourceAllocations.add(new ResourceAllocation(auditee));						
//				}
//			
//			resourceAllocationRepo.saveAll(resourceAllocations);
			
		};
		
	}

}
