package com.auditseverity.auditseverity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.auditseverity.auditseverity.models.AuditDetails;
import com.auditseverity.auditseverity.models.AuditResponse;
import com.auditseverity.auditseverity.models.Project;
import com.auditseverity.auditseverity.service.AuditDetailsService;
import com.auditseverity.auditseverity.service.AuditResponseService;
import com.auditseverity.auditseverity.service.ProjectService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = { "com.auditbenchmark.auditbenchmark" })
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class ControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	AuditResponseService auditResponseService;

	@MockBean
	AuditDetailsService auditDetailService;

	@MockBean
	ProjectService projectService;

	@Test
	void testResponse() throws Exception {
		Project p = new Project("abc", "def", "xyz");
		AuditDetails aud = new AuditDetails("Internal", 2, LocalDate.of(2021, 4, 28), p);
//		aud.setToken("aajscakjcaksjc");
//		log.debug(LocalDate.of(2021, 4, 28).toString());
//		AuditResponse ar = new AuditResponse("Green", "No action", aud);
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		String json = objectMapper.writeValueAsString(aud);
//
//		when(auditDetailService.getScore(aud, "aajscakjcaksjc")).thenReturn(3l);
//
//		when(auditResponseService.setResponse(aud, 2l)).thenReturn(ar);
		
		ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(aud);

		mvc.perform(MockMvcRequestBuilders.post("/ProjectExecutionStatus")
				.content(
				"{\"type\": \"Internal\", \"count\": 2, \"date\": \"2021-04-28\", \"project\": {\"name\": \"Audit Maagement\", \"manager\": \"Subrrao\", \"owner\": \"Cognizant\"}, \"token\": \"Bearer abcd\"}")
				.contentType("application/json")).andDo(print()).andExpect(status().isOk());

	}

}
