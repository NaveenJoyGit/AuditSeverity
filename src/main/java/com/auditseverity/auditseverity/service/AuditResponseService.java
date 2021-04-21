package com.auditseverity.auditseverity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auditseverity.auditseverity.models.AuditDetails;
import com.auditseverity.auditseverity.models.AuditResponse;
import com.auditseverity.auditseverity.repository.AuditResponseRepository;

@Service
public class AuditResponseService {

	@Autowired
	AuditResponseRepository auditResponseRepository;

	@Transactional
	public List<AuditResponse> FindAllResponse() {

		return auditResponseRepository.findAll();
	}

	@Transactional
	public void saveResponse(AuditResponse auditResponse) {

		auditResponseRepository.save(auditResponse);
	}

	public AuditResponse setResponse(AuditDetails aud, Long score) {
		AuditResponse ar= new AuditResponse();
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
		return auditResponseRepository.save(ar);
	}
}
