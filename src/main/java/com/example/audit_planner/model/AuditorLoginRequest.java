package com.example.audit_planner.model;

public class AuditorLoginRequest {

	private int auditorId;

	private String password;
	
		
	public AuditorLoginRequest(int auditorId, String password) {
		
		this.auditorId = auditorId;
		this.password = password;
	}

	public int getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(int auditorId) {
		this.auditorId = auditorId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
