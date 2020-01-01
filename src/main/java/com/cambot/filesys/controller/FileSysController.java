package com.cambot.filesys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cambot.filesys.models.FileSystem;
import com.cambot.filesys.service.GitService;
import com.cambot.filesys.service.JenkinsService;

/*
 *  Controller for endpoint that will send a post request to jenkins to run the job with specified parameters
 */

@RestController
public class FileSysController {

	@Autowired
	private GitService gitService;

	@Autowired
	private JenkinsService jenkinsService;

	@PostMapping(path = "/run")
	public ResponseEntity<String> runJob(@RequestBody String parameters) {
		return jenkinsService.runJob(parameters);
	}

	@GetMapping(path = "/files")
	public ResponseEntity<List<FileSystem>> getFiles() {
		return gitService.getFiles();
	}

}
