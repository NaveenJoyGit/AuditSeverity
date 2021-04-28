package com.auditseverity.auditseverity.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.auditseverity.auditseverity.client.BenchMarkClient;
import com.auditseverity.auditseverity.models.AuditDetails;
import com.auditseverity.auditseverity.models.Benchmark;
import com.auditseverity.auditseverity.repository.AuditDetailsRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuditDetailsService {
	
//	RestTemplate rt = new RestTemplate();
//	
//	ResponseEntity<Benchmark[]> rs = rt.getForEntity("http://host.docker.internal:9090/api/AuditBenchMark", Benchmark[].class);
//	Benchmark b[] = rs.getBody();
//	List<Benchmark> benchmark = Arrays.asList(b);

	@Autowired
	AuditDetailsRepository auditDetailsRepository;
	
	@Autowired
	BenchMarkClient benchClientt;
	
	public List<Benchmark> getBechmarks(String token) {
		return benchClientt.getBenchmarks(token);
	}

	@Transactional
	public List<AuditDetails> getAuditDetails() {

		return auditDetailsRepository.findAll();
	}

	@Transactional
	public void saveResponse(AuditDetails auditDetails) {

		auditDetailsRepository.save(auditDetails);
	}
	
	public Long getScore(AuditDetails aud, String token) {
		
		List<Benchmark> benchmark = getBechmarks(token);
		log.info("-----from aud-service------" + benchmark.get(0).getAudit_type());
		
		
		Long score = null;
		if(aud.getType().equals(benchmark.get(0).getAudit_type())) {
			score = benchmark.get(0).getScore();
			
		}
		if(aud.getType().equals(benchmark.get(1).getAudit_type())) {
			score = benchmark.get(1).getScore();
			
		}
		return score;
	}
}
