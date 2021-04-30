package com.auditseverity.auditseverity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.auditseverity.auditseverity.client.BenchMarkClient;
import com.auditseverity.auditseverity.models.AuditDetails;
import com.auditseverity.auditseverity.models.Benchmark;
import com.auditseverity.auditseverity.models.Project;
import com.auditseverity.auditseverity.service.AuditDetailsService;

@SpringBootTest
class ServiceTest {
	
	@MockBean
	BenchMarkClient benchClientt;
	
	@Autowired
	AuditDetailsService auditService;
	
	public List<Benchmark> getBechmarks(String token) {
		return benchClientt.getBenchmarks(token);
	}

	@Test
	void testAuditDetailsService() {
		Benchmark b1 = new Benchmark(1, "Internal", 3);
		Benchmark b2 = new Benchmark(2, "SOX", 1);
		List<Benchmark> bList = new ArrayList<>();
		bList.add(b1);
		bList.add(b2);
		
		Project p = new Project("abc", "def", "xyz");
		AuditDetails aud = new AuditDetails("Internal", 2, LocalDate.of(2021, 4, 28), p);
		
		when(benchClientt.getBenchmarks("token")).thenReturn(bList);
		when(auditService.getBechmarks("token")).thenReturn(bList);
		
		Long score = auditService.getScore(aud, "token");
		
		assertEquals(3, score);
		
	}

}
