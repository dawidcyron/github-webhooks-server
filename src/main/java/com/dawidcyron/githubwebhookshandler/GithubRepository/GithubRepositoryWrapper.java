package com.dawidcyron.githubwebhookshandler.GithubRepository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepositoryWrapper {
  private GithubRepository repository;
}
