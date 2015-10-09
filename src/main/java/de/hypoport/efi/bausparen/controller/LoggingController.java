package de.hypoport.efi.bausparen.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class LoggingController {

  private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(BausparBerechnungController.class);

  @ModelAttribute
  public void addAttributes(@RequestBody String requestString) {
    LOG.info("request=" + requestString);
  }
}
