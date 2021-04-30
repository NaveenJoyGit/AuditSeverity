package com.auditseverity.auditseverity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.auditseverity.auditseverity.service.AuditDetailsService;
import com.auditseverity.auditseverity.service.AuditResponseService;
import com.auditseverity.auditseverity.service.ProjectService;

@SpringBootTest
class AuditRequestTest {

	@Autowired
	AuditResponseService auditResponseService;
	
	@Autowired
	AuditDetailsService auditDetailService;
	
	@Autowired
	ProjectService projectService;
	
	@Test
	void Requesttest() {
//		Project p1 = new Project("aksb", "jjbjhb", "jgvvyrdt");
//		AuditDetails a1 = new AuditDetails("Internal", 4, "20/04/2021", p1);
//		AuditResponse ar1 = new AuditResponse("Green", "No Action", a1);
//		
//		projectService.saveResponse(p1);
//		auditDetailService.saveResponse(a1);
//		auditResponseService.saveResponse(ar1);
//		
//		assertEquals("aksb", 
//				auditResponseService.FindAllResponse().get(0).getDetail().getProject().getName());
		
	}

}
