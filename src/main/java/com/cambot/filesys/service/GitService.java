package com.cambot.filesys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cambot.filesys.models.FileSystem;
import com.cambot.filesys.models.GitResponse;
import com.cambot.filesys.models.Tree;
import com.cambot.filesys.repository.GitRepository;

@Service
public class GitService {

	@Autowired
	private GitRepository gitRepository;

	public ResponseEntity<GitResponse> getFiles() {

		GitResponse gitResponse = gitRepository.getFiles().getBody();
		getPath(gitResponse);
		return gitRepository.getFiles();
	}

	public void getPath(GitResponse gitResponse) {
		List<Tree> trees = gitResponse.getTree();
		for (Tree tree : trees) {
			// Is file
			if (tree.getType().equalsIgnoreCase("blob")) {
				String path = tree.getPath();
				FileSystem fileSystem = new FileSystem();
				// TODO Lombok, name, size, parentId, children
				fileSystem.setType("__file__");
				fileSystem.setName(getFileName(path));
				fileSystem.setCreatorName("Cam");
				fileSystem.setSize(100);
				fileSystem.setDate("2019-04-20");
				fileSystem.setParentID("1");
				fileSystem.setParentPath(getParentPath(path));
				fileSystem.setPath(path);
				fileSystem.setChildren(null);
				System.out.println(fileSystem.toString());
			} else { // Is directory

			}

		}
	}

	public String getParentPath(String path) {
		int index;

		index = path.lastIndexOf("/");
		if (index == -1) {
			return "/";
		}
		return path.substring(0, index);
	}

	public String getFileName(String path) {
		int index;
		index = path.lastIndexOf('/');
		if (index == -1) {
			return path;
		}
		return path.substring(index + 1);
	}
}
