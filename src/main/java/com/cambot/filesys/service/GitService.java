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

	private List<FileSystem> fileSystemList = new LinkedList<>();

	public ResponseEntity<List<FileSystem>> getFiles() {

		GitResponse gitResponse = gitRepository.getFiles().getBody();
		ResponseEntity<List<FileSystem>> fileSystem = new ResponseEntity<List<FileSystem>>(getPath(gitResponse),
				HttpStatus.OK);
		return fileSystem;
		// return gitRepository.getFiles();
	}

	public List<FileSystem> getPath(GitResponse gitResponse) {
		List<Tree> trees = gitResponse.getTree();
		for (Tree tree : trees) {
			boolean isFile = false;
			if (tree.getType().equalsIgnoreCase("blob")) {
				isFile = true;
			}
			FileSystem fileSystem = new FileSystem();
			String path = tree.getPath();
			// TODO Builder, name, size, parentId, children
			fileSystem.setHash(tree.getSha());
			fileSystem.setName(getFileName(path));
			fileSystem.setCreatorName("Cam");
			fileSystem.setSize(tree.getSize());
			fileSystem.setDate("2019-04-20");
			fileSystem.setParentID("1");
			fileSystem.setParentPath(getParentPath(path));
			fileSystem.setPath(path);
			fileSystem.setChildren(null);
			if (isFile) {
				fileSystem.setType("__file__");
			} else {
				fileSystem.setType("__folder__");
			}
			fileSystemList.add(fileSystem);
		}
		findChildren(fileSystemList);
		return fileSystemList;
	}

	public void findChildren(List<FileSystem> fileSystemList) {
		String comp = null;
		for (FileSystem entity : fileSystemList) {
			List<String> children = new LinkedList<>();
			comp = entity.getPath();
			for (int i = 1; i < fileSystemList.size(); i++) {
				FileSystem compEntity = fileSystemList.get(i);
				if (comp.equalsIgnoreCase((String) compEntity.getParentPath())) {
					children.add(compEntity.getHash());
				}
			}
			entity.setChildren(children);
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
