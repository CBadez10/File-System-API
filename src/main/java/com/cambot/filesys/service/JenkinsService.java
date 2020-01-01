package com.cambot.filesys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cambot.filesys.repository.JenkinsRepository;

@Service
public class JenkinsService {

	@Autowired
	private JenkinsRepository jenkinsRepository;

	public ResponseEntity<String> runJob(String parameters) {
		return jenkinsRepository.runJob(parameters);
	}
}
