package com.auditseverity.auditseverity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.auditseverity.auditseverity.client.BenchMarkClient;
import com.auditseverity.auditseverity.models.Benchmark;

@SpringBootTest
class BenchmarkTest {

	@Autowired
	BenchMarkClient benchClientt;
	
	public List<Benchmark> getBechmarks(String token) {
		return benchClientt.getBenchmarks(token);
	}
	
	@Test
	void bechTestFeign() {
		String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJEZW1vIEFwcCIsInN1YiI6Im5pcmFqIiwiaWF0IjoxNjE5MzU3NTEyLCJleHAiOjE2MjAwNjI1NDQsIlJvbGVzIjpbIlJPTEVfQURNSU4iXX0.Gt16kGJNXNeasj1kGXUvfWhgx4hl2_SZZy7ooaZSyZyUOMG_dnMIt_b9YU6Kt-nqxSqOJ_l85zaeUN_B7v-Uug";
		List<Benchmark> benchmark = getBechmarks(token);
		assertEquals("Internal", benchmark.get(0).getAudit_type());
	}
	
	@Test
	void test() {
		String url = "http://host.docker.internal:9090/api/AuditBenchMark/AuditBenchmark";
		String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJEZW1vIEFwcCIsInN1YiI6Im5pcmFqIiwiaWF0IjoxNjE5MjU3ODQ0LCJleHAiOjE2MTk5NjI4NzcsIlJvbGVzIjpbIlJPTEVfQURNSU4iXX0.CZ338Muw4Egh06eGvOzDWSYkhkQLJVgGFKN6MvM6x4Qts5j5e_h4vkwW_ruOsM6gjozUR9uGbe_zwqDU80iu2Q";
		
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.add("Authorization", token);	
		
		HttpEntity<String> request = new HttpEntity<>(headers);
		
		RestTemplate rt = new RestTemplate();	
		
		ResponseEntity<Benchmark[]> rs = rt.exchange(
			    url, HttpMethod.GET, request, Benchmark[].class);
		Benchmark b[] = rs.getBody();
		List<Benchmark> benchmark = Arrays.asList(b);
		
		assertEquals("SOX", benchmark.get(0).getAudit_type());
	}

}
