package com.example.audit_planner;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.audit_planner.model.Auditee;
import com.example.audit_planner.model.AuditeeRepository;

@SpringBootApplication
public class AuditPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditPlannerApplication.class, args);
	}
	
	@Bean
	ApplicationRunner init(AuditeeRepository auditeeRepo) {
		return args ->{
			auditeeRepo.save(new Auditee("Sales","Global Markets"));
			auditeeRepo.save(new Auditee("Wealth Management","Community Financial Services"));
			auditeeRepo.save(new Auditee("Commercial Banking Division","Community Financial Services"));
			auditeeRepo.save(new Auditee("Cards & Personal Loans","Community Financial Services"));
			auditeeRepo.save(new Auditee("Retail Loans","Community Financial Services"));
			auditeeRepo.save(new Auditee("Distribution Channel Service","Operations"));
			auditeeRepo.save(new Auditee("Treasury","Operations"));
			auditeeRepo.save(new Auditee("Credit Doc & Admin","Operations"));
			auditeeRepo.save(new Auditee("Operations & Payment Support","Operations"));
			auditeeRepo.save(new Auditee("Planning & Service Management","Operations"));
			auditeeRepo.save(new Auditee("Property Services","Operations"));
			auditeeRepo.save(new Auditee("Rewards","Human Capital"));
			auditeeRepo.save(new Auditee("Resourcing & Workforce Management","Human Capital"));
			auditeeRepo.save(new Auditee("Financial Analytics","Finance"));
			auditeeRepo.save(new Auditee("Financial Management","Finance"));
			auditeeRepo.save(new Auditee("Products Control","Finance"));
			auditeeRepo.save(new Auditee("Remedial Management","Finance"));
			auditeeRepo.save(new Auditee("Tax","Finance"));
			auditeeRepo.save(new Auditee("Credit Management","Risk Management"));
			auditeeRepo.save(new Auditee("Traded Risk Management","Risk Management"));
			auditeeRepo.save(new Auditee("Portfolio Risk Management","Risk Management"));
			auditeeRepo.save(new Auditee("Operational Risk Management","Risk Management"));
			auditeeRepo.save(new Auditee("Enterprise Risk Management","Risk Management"));
			auditeeRepo.save(new Auditee("Transformation Office","Strategy"));
			auditeeRepo.save(new Auditee("Digital Banking","Strategy"));
			auditeeRepo.save(new Auditee("Sustainability Office","Strategy"));
			auditeeRepo.save(new Auditee("Legal-Global Banking","Legal & Corporate Office"));
			auditeeRepo.save(new Auditee("Legal-CFS Support","Legal & Corporate Office"));
			auditeeRepo.save(new Auditee("Corporate Affairs","Country Corporate Office"));
			auditeeRepo.save(new Auditee("Financial Crime Compliance","Compliance"));
			auditeeRepo.save(new Auditee("Regulatory Monitoring","Compliance"));
			auditeeRepo.save(new Auditee("Regulatory Affairs","Compliance"));
			auditeeRepo.save(new Auditee("Core Banking and Data Warehouse","Technology"));
			auditeeRepo.save(new Auditee("Wealth, Branch Channel and Treasury","Technology"));
			auditeeRepo.save(new Auditee("Digital Channels","Technology"));
			auditeeRepo.save(new Auditee("Cards","Technology"));
			auditeeRepo.save(new Auditee("Trade","Technology"));
			auditeeRepo.save(new Auditee("Technology Infrastructure","Technology"));
			auditeeRepo.save(new Auditee("Technology Risk Management","Technology"));
			auditeeRepo.save(new Auditee("IT Security Defense","Technology"));
			auditeeRepo.save(new Auditee("Finance and Corporate Function","Technology"));
			
			auditeeRepo.findAll().forEach(System.out::println);
		};
	}

}
