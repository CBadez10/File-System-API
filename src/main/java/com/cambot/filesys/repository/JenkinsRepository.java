package com.cambot.filesys.repository;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.cambot.filesys.util.Constants;

@Repository
public class JenkinsRepository {

	private static String url = Constants.POST_URL;

	public ResponseEntity<String> runJob(String parameters) {
		RestTemplate template = new RestTemplate();
		String url = Constants.POST_URL;
		HttpEntity<String> entity = new HttpEntity<>(parameters);
		ResponseEntity<String> response = template.postForEntity(url, entity, String.class);
		return response;
	}
}
