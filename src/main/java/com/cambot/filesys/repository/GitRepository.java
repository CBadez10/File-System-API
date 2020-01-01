package com.cambot.filesys.repository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.cambot.filesys.models.GitResponse;
import com.cambot.filesys.util.Constants;

@Repository
public class GitRepository {

	private static String url = Constants.GIT_URL
			+ "/repos/CBadez10/SpringDemo/git/trees/ccfca9993d14e49478bc2bd226ec430e91150ade?recursive=1";

	public ResponseEntity<GitResponse> getFiles() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<GitResponse> response = template.getForEntity(url, GitResponse.class);
		return response;
	}
}
