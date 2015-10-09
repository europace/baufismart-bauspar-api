package de.hypoport.efi.bausparen.controller;

import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice(annotations = RestController.class)
public class LoggingController {

  private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(BausparBerechnungController.class);

  @ModelAttribute
  public void addAttributes(HttpServletRequest request, HttpServletResponse response,Model model, @RequestBody String requestString, @RequestHeader(value = "User-Agent") String userAgent) {
    LOG.info("request="+requestString);
  }

}
