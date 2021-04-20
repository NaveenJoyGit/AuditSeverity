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

	@Column(name = "Count")
	private int Count;

	@JoinColumn(name = "date")
	private String date;

	@OneToOne
	@JoinColumn(name = "project_id")
	private Project project;
	
	@OneToOne(mappedBy = "detail")
	private AuditResponse response;

	public AuditDetails(String type, int Count, String date, Project project) {
		super();
		this.type = type;
		this.Count = Count;
		this.date = date;
		this.project = project;
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
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	public AuditResponse getResponse() {
		return response;
	}

	public void setResponse(AuditResponse response) {
		this.response = response;
	}

}
