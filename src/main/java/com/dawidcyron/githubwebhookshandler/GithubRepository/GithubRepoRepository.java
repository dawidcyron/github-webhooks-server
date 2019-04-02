package com.dawidcyron.githubwebhookshandler.GithubRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GithubRepoRepository extends PagingAndSortingRepository<GithubRepository, Long> {
}
