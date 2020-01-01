package com.cambot.filesys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cambot.filesys.models.GitResponse;
import com.cambot.filesys.repository.GitRepository;

@Service
public class GitService {

	@Autowired
	private GitRepository gitRepository;

	public ResponseEntity<GitResponse> getFiles() {
		return gitRepository.getFiles();
	}

}
