package com.dawidcyron.githubwebhookshandler.GithubRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GithubRepositoryController {


	@Autowired
	GithubRepoRepository githubRepoRepository;

	@PostMapping("/")
	public ResponseEntity<GithubRepository> handleWebhook(@RequestBody GithubRepositoryWrapper repositoryWrapper) {
		githubRepoRepository.save(repositoryWrapper.getRepository());
		return new ResponseEntity<>(repositoryWrapper.getRepository(), HttpStatus.OK);
	}
}
