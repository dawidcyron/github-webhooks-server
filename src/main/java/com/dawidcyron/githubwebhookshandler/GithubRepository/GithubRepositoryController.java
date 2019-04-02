package com.dawidcyron.githubwebhookshandler.GithubRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class GithubRepositoryController {

	Logger logger = LoggerFactory.getLogger(GithubRepositoryController.class);

	@Autowired
	GithubRepoRepository githubRepoRepository;

	@PostMapping("/")
	public void handleWebhook(@RequestBody GithubRepositoryWrapper repositoryWrapper) {
		githubRepoRepository.save(repositoryWrapper.getRepository());
	}

	@GetMapping("/")
	public ResponseEntity<List<GithubRepository>> getSixRecentRepositories() {

		return new ResponseEntity<>(githubRepoRepository.findTop10ByOrderById(), HttpStatus.OK);
	}
}
