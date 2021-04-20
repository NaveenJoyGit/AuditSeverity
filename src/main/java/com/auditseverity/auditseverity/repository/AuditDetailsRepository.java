package com.auditseverity.auditseverity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auditseverity.auditseverity.models.AuditDetails;
import com.auditseverity.auditseverity.models.Project;

@Repository
public interface AuditDetailsRepository extends JpaRepository<AuditDetails, Integer> {

}
