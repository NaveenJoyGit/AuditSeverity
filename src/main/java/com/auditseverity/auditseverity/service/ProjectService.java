package com.auditseverity.auditseverity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auditseverity.auditseverity.models.Project;
import com.auditseverity.auditseverity.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;

	@Transactional
	public List<Project> getAllMovies() {

		return projectRepository.findAll();
	}

	@Transactional
	public void saveResponse(Project project) {

		projectRepository.save(project);
	}
}
