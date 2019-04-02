package com.dawidcyron.githubwebhookshandler.GithubRepository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepository {

  @Id
  @NotNull
  @Column(nullable = false)
  private Long id;

  @NotNull
  @URL
  @Column(nullable = false)
  private String html_url;

  @NotNull
  @NotEmpty
  @Column(nullable = false)
  private String name;

  private String description;

  private String language;
}
