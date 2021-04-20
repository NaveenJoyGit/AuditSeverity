package com.auditseverity.auditseverity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auditseverity.auditseverity.models.AuditResponse;
import com.auditseverity.auditseverity.repository.AuditResponseRepository;

@Service
public class AuditResponseService {

	@Autowired
	AuditResponseRepository auditResponseRepository;

	@Transactional
	public List<AuditResponse> getAllMovies() {

		return auditResponseRepository.findAll();
	}

	@Transactional
	public void saveResponse(AuditResponse auditResponse) {

		auditResponseRepository.save(auditResponse);
	}
}
