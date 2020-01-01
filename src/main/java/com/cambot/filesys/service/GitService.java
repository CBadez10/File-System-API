package com.cambot.filesys.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	public ResponseEntity<List<FileSystem>> getFiles() {

		GitResponse gitResponse = gitRepository.getFiles().getBody();
		ResponseEntity<List<FileSystem>> fileSystem = new ResponseEntity<List<FileSystem>>(getPath(gitResponse),
				HttpStatus.OK);
		return fileSystem;
		// return gitRepository.getFiles();
	}

	public List<FileSystem> getPath(GitResponse gitResponse) {
		List<Tree> trees = gitResponse.getTree();
		List<FileSystem> fileSystemList = new LinkedList<>();
		for (Tree tree : trees) {
			// Is file
			if (tree.getType().equalsIgnoreCase("blob")) {
				FileSystem fileSystem = new FileSystem();
				String path = tree.getPath();
				// TODO Lombok, name, size, parentId, children
				fileSystem.setHash(tree.getSha());
				fileSystem.setType("__file__");
				fileSystem.setName(getFileName(path));
				fileSystem.setCreatorName("Cam");
				fileSystem.setSize(100);
				fileSystem.setDate("2019-04-20");
				fileSystem.setParentID("1");
				fileSystem.setParentPath(getParentPath(path));
				fileSystem.setPath(path);
				fileSystem.setChildren(null);
				fileSystemList.add(fileSystem);
			} else { // Is directory

			}
		}
		return fileSystemList;
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
