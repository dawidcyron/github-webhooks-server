package com.dawidcyron.githubwebhookshandler.GithubRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class GithubRepositoryController {

  @Autowired GithubRepoRepository githubRepoRepository;

  @Value("${SECRET}")
  private String secret;

  @PostMapping("/payload")
  public void handleWebhook(
      @RequestBody String body,
      @RequestHeader(value = "X-Hub-Signature", required = true) String signature)
      throws IOException {
    String digest = "sha1=" + new HmacUtils(HmacAlgorithms.HMAC_SHA_1, secret).hmacHex(body);
    if (digest.equals(signature)) {
      ObjectMapper mapper = new ObjectMapper();
      GithubRepositoryWrapper repositoryWrapper =
          mapper.readValue(body, GithubRepositoryWrapper.class);
      githubRepoRepository.save(repositoryWrapper.getRepository());
    }
  }

  @GetMapping("/")
  public ResponseEntity<List<GithubRepository>> getSixRecentRepositories() {
    return new ResponseEntity<>(githubRepoRepository.findTop6ByOrderById(), HttpStatus.OK);
  }

  @ExceptionHandler({IOException.class})
  public ResponseEntity<String> handleIncorrectPayloadException() {
    return new ResponseEntity<>(
        "This server is supposed to be used only by Github Webhooks! Provided payload couldn't be unmarshalled!",
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({MissingServletRequestParameterException.class})
  public ResponseEntity<String> handleMissingRequestHeaderException() {
    return new ResponseEntity<>(
        "This server is supposed to be used only by Github Webhooks! Missing request header!",
        HttpStatus.BAD_REQUEST);
  }
}
