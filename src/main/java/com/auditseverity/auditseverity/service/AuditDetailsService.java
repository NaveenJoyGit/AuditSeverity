package com.auditseverity.auditseverity.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.auditseverity.auditseverity.models.AuditDetails;
import com.auditseverity.auditseverity.models.AuditResponse;
import com.auditseverity.auditseverity.models.Benchmark;
import com.auditseverity.auditseverity.repository.AuditDetailsRepository;
import com.auditseverity.auditseverity.repository.AuditResponseRepository;

@Service
public class AuditDetailsService {
	
	RestTemplate rt = new RestTemplate();
	
	ResponseEntity<Benchmark[]> rs = rt.getForEntity("http://localhost:8081/AuditBenchmark", Benchmark[].class);
	Benchmark b[] = rs.getBody();
	List<Benchmark> benchmark = Arrays.asList(b);

	@Autowired
	AuditDetailsRepository auditDetailsRepository;

	@Transactional
	public List<AuditDetails> getAllMovies() {

		return auditDetailsRepository.findAll();
	}

	@Transactional
	public void saveResponse(AuditDetails auditDetails) {

		auditDetailsRepository.save(auditDetails);
	}
	
	public Long getScore(AuditDetails aud) {
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
