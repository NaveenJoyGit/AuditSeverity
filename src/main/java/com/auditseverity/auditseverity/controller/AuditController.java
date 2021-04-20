package com.auditseverity.auditseverity.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.auditseverity.auditseverity.models.AuditDetails;
import com.auditseverity.auditseverity.models.AuditResponse;
import com.auditseverity.auditseverity.models.Benchmark;
import com.auditseverity.auditseverity.service.AuditDetailsService;
import com.auditseverity.auditseverity.service.AuditResponseService;
import com.auditseverity.auditseverity.service.ProjectService;

@RestController
public class AuditController {

	@Autowired
	AuditResponseService auditResponseService;
	
	@Autowired
	AuditDetailsService auditDetailService;
	
	@Autowired
	ProjectService projectService;
	
	RestTemplate rt = new RestTemplate();
	
	ResponseEntity<Benchmark[]> rs = rt.getForEntity("http://localhost:8081/AuditBenchmark", Benchmark[].class);
	Benchmark b[] = rs.getBody();
	List<Benchmark> benchmark = Arrays.asList(b); 
	
	
	
	@PostMapping("/ProjectExecutionStatus")
	public AuditResponse addFavorite(@RequestBody AuditDetails aud) {
		System.out.println(aud.getCount());
		AuditResponse ar= new AuditResponse();
		Long score = null;
		if(aud.getType().equals(benchmark.get(0).getAudit_type())) {
			score = benchmark.get(0).getScore();
			
		}
		if(aud.getType().equals(benchmark.get(1).getAudit_type())) {
			score = benchmark.get(1).getScore();
			
		}
		projectService.saveResponse(aud.getProject());
		auditDetailService.saveResponse(aud);
		
		if(aud.getCount() < score)
		{
			ar.setStatus("green");
			ar.setRem_duration("No action needed");
			ar.setDetail(aud);
					
		}
		else
		{
			ar.setStatus("red");
			ar.setRem_duration("2 weeks");
			ar.setDetail(aud);
		}
		auditResponseService.saveResponse(ar);
		return ar;
	}
}
