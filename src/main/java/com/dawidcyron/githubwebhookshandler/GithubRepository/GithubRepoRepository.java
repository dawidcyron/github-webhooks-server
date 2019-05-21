package com.dawidcyron.githubwebhookshandler.GithubRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GithubRepoRepository extends CrudRepository<GithubRepository, Long> {
  List<GithubRepository> findTop6ByOrderByIdDesc();
}
