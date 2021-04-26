package com.auditseverity.auditseverity.models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table
@Data
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
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate date;

	@OneToOne(mappedBy = "detail")
	private AuditResponse response;
	
	@OneToOne
	@JoinColumn(name = "project_id")
	private Project project;
	
	private String token;
		


	public AuditDetails(String type, int count, LocalDate date, Project project) {
		super();
		this.type = type;
		this.count = count;
		this.date = date;
		this.project = project;
	}


}
