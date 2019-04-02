package com.dawidcyron.githubwebhookshandler.GithubRepository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.URL;

@Entity
@Data
public class GithubRepository {

	@Id
	private Long id;

	private URL url;

	private String name;

	private String description;

	private  String language;

	private Integer stargazers;
}
