package com.dawidcyron.githubwebhookshandler.GithubRepository;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class GithubRepositoryWrapper {
	private GithubRepository repository;
}
