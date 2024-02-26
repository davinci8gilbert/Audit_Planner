package com.example.audit_planner.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.audit_planner.model.Auditor;
import com.example.audit_planner.model.AuditorLoginRequest;
import com.example.audit_planner.model.AuditorRepository;
import com.example.audit_planner.model.MessageResponse;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	AuditorRepository auditorRepo;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuditorLoginRequest loginRequest) {

		
		try {
			Auditor auditor = auditorRepo.findByUserName(loginRequest.getUserName());
			if (auditor != null) {
				String password = auditor.getPassword();
				if (password.equals(loginRequest.getPassword())) {
					return new ResponseEntity<>(auditor, HttpStatus.OK);
				}
				MessageResponse msg = new MessageResponse("Incorrect password");
				
				return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
			}
			MessageResponse msg = new MessageResponse("No such an auditor");
			return new ResponseEntity<>(msg, HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			MessageResponse msg = new MessageResponse("Server Error");
			return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
