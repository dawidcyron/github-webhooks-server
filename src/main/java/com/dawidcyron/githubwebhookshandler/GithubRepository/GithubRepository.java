package com.dawidcyron.githubwebhookshandler.GithubRepository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
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

  private String live_url;
}
