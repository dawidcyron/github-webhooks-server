package com.dawidcyron.githubwebhookshandler.GithubRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class GithubRepositoryController {

  Logger logger = LoggerFactory.getLogger(GithubRepositoryController.class);
  @Autowired GithubRepoRepository githubRepoRepository;
  @Value("${SECRET}")
  private String secret;

  @PostMapping("/payload")
  public void handleWebhook(
      @RequestBody String body,
      @RequestHeader(value = "X-Hub-Signature", required = true) String signature) {
    System.out.println(secret);
    String digest = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, secret).hmacHex(body);
    if (digest.equals(signature)) {
      try {
        ObjectMapper mapper = new ObjectMapper();
        GithubRepositoryWrapper repositoryWrapper =
            mapper.readValue(body, GithubRepositoryWrapper.class);
        githubRepoRepository.save(repositoryWrapper.getRepository());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    System.out.println(digest);
  }

  @GetMapping("/")
  public ResponseEntity<List<GithubRepository>> getSixRecentRepositories() {

    return new ResponseEntity<>(githubRepoRepository.findTop6ByOrderById(), HttpStatus.OK);
  }
}
