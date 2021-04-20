package com.auditseverity.auditseverity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.auditseverity.auditseverity.models.Benchmark;

class RestTemplateTest {

	@Test
	void test() {
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<Benchmark[]> rs = rt.getForEntity("http://localhost:8081/AuditBenchmark", Benchmark[].class);
		Benchmark b[] = rs.getBody();
		List<Benchmark> benchmark = Arrays.asList(b);
		
		assertEquals(3, benchmark.get(0).getScore());
	}

}
