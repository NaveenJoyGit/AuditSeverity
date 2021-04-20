package com.auditseverity.auditseverity.models;

import java.util.Date;

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
public class AuditDetails {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "type")
	private String type;

	@Column(name = "count")
	private int count;

	@JoinColumn(name = "date")
	private String date;

	@OneToOne(mappedBy = "detail")
	private AuditResponse response;
	
	@OneToOne
	@JoinColumn(name = "project_id")
	private Project project;
	


	public AuditDetails(String type, int count, String date, Project project) {
		super();
		this.type = type;
		this.count = count;
		this.date = date;
		this.project = project;
	}

	public AuditDetails() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public AuditResponse getResponse() {
		return response;
	}

	public void setResponse(AuditResponse response) {
		this.response = response;
	}

}
