package com.auditseverity.auditseverity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auditseverity.auditseverity.models.AuditDetails;
import com.auditseverity.auditseverity.models.AuditResponse;
import com.auditseverity.auditseverity.repository.AuditDetailsRepository;
import com.auditseverity.auditseverity.repository.AuditResponseRepository;

@Service
public class AuditDetailsService {

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
}
