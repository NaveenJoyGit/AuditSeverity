package com.auditseverity.auditseverity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auditseverity.auditseverity.models.AuditResponse;

@Repository
public interface AuditResponseRepository extends JpaRepository<AuditResponse, Integer> {

}
