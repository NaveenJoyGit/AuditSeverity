package com.auditseverity.auditseverity.controller;

import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.auditseverity.auditseverity.client.BenchMarkClient;
import com.auditseverity.auditseverity.models.AuditDetails;
import com.auditseverity.auditseverity.models.AuditResponse;
import com.auditseverity.auditseverity.models.Benchmark;
import com.auditseverity.auditseverity.service.AuditDetailsService;
import com.auditseverity.auditseverity.service.AuditResponseService;
import com.auditseverity.auditseverity.service.ProjectService;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AuditController {

	@Autowired
	AuditResponseService auditResponseService;

	@Autowired
	AuditDetailsService auditDetailService;

	@Autowired
	ProjectService projectService;
	
	
	
//	org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
//	headers.add("Authorization", token);	
//	
//	HttpEntity<AuditDetails> request = new HttpEntity<>(headers);
//	
//	RestTemplate rt = new RestTemplate();	
//	
//	ResponseEntity<Benchmark[]> rs = rt.exchange(
//		    url, HttpMethod.GET, request, Benchmark[].class);

//	RestTemplate rt = new RestTemplate();
//
//	ResponseEntity<Benchmark[]> rs = rt.getForEntity("http://host.docker.internal:9090/api/AuditBenchMark", Benchmark[].class);
//	Benchmark b[] = rs.getBody();
//	List<Benchmark> benchmark = Arrays.asList(b);

	@PostMapping("/ProjectExecutionStatus")
	public AuditResponse addFavorite(@RequestBody AuditDetails aud) {
		log.info("-------header in severity----------");
//		log.info(request.getHeaders().getFirst("Authorization"));
//		log.info(header.toString());
		
//		headers.forEach((key,value) ->{
//            log.info("Header Name: "+key+" Header Value: "+value);
//        });
		
//		String bearerToken = request.getHeader("Authorization");
//		String token = bearerToken.substring(7, bearerToken.length());
		
		String token = aud.getToken();
		log.info(token);
		log.info("--------date inside severity-----------");
		log.info(aud.getDate().toString());
		Long score = auditDetailService.getScore(aud, token);
		projectService.saveResponse(aud.getProject());
		auditDetailService.saveResponse(aud);

		auditResponseService.setResponse(aud, score);

		return auditResponseService.setResponse(aud, score);
	}
}
