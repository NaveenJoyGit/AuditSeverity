package com.auditseverity.auditseverity.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity  
@Table
public class AuditResponse {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
		
	@Column(name = "status")
	private String status;
	
	@Column(name = "rem_duration")
	private String rem_duration;
	
	@OneToOne
	@JoinColumn(name = "audit_id")
	private AuditDetails detail;

	public AuditResponse(int id, String status, String rem_duration) {
		super();
		this.id = id;
		this.status = status;
		this.rem_duration = rem_duration;
	}
	
	

	public AuditResponse() {
		super();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRem_duration() {
		return rem_duration;
	}

	public void setRem_duration(String rem_duration) {
		this.rem_duration = rem_duration;
	}

	
}
