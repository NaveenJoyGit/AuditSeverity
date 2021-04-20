package com.auditseverity.auditseverity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.auditseverity.auditseverity.models.AuditDetails;
import com.auditseverity.auditseverity.models.Project;
import com.auditseverity.auditseverity.service.AuditDetailsService;
import com.auditseverity.auditseverity.service.ProjectService;

@SpringBootApplication
public class AuditseverityApplication implements CommandLineRunner {
	
	@Autowired
	AuditDetailsService auditService;
	
	@Autowired
	ProjectService projectService;

	public static void main(String[] args) {
		SpringApplication.run(AuditseverityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Project p1 = new Project("abc", "def", "hij"); 
//		AuditDetails ad1 = new AuditDetails("Internal", 4, "20/04/2021", p1);
//		
//		projectService.saveResponse(p1);
//		auditService.saveResponse(ad1);
	}

}
