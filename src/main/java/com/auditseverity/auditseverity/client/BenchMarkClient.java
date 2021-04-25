package com.auditseverity.auditseverity.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.auditseverity.auditseverity.models.Benchmark;

@FeignClient(url = "http://host.docker.internal:9090/api/AuditBenchMark", name = "BENCHMARK")
public interface BenchMarkClient {

	@GetMapping("/AuditBenchmark")
	public List<Benchmark> getBenchmarks(@RequestHeader(value = "Authorization", required = true) String authorizationHeader);
}
