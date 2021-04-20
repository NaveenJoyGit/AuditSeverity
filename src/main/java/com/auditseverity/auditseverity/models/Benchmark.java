package com.auditseverity.auditseverity.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="benchmark")
public class Benchmark {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
	@Column(name="audit_type")
    String audit_type;
	@Column(name="score")
    long score;

public Benchmark(int id, String audit_type, long score) {
	super();
	this.id = id;
	this.audit_type = audit_type;
	this.score = score;
}

public Benchmark() {
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getAudit_type() {
	return audit_type;
}

public void setAudit_type(String audit_type) {
	this.audit_type = audit_type;
}

public long getScore() {
	return score;
}

public void setScore(long score) {
	this.score = score;
}


}
