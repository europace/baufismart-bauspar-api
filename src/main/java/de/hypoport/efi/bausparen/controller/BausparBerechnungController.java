package de.hypoport.efi.bausparen.controller;

import de.hypoport.efi.bausparen.model.BausparBerechungsErgebnis;
import de.hypoport.efi.bausparen.model.Berechnungsdaten;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController(value = "/")
public class BausparBerechnungController {

  @RequestMapping(value = "bausparangebot/", method = GET, produces = APPLICATION_JSON_VALUE + ";charset=UTF-8")
  public
  @ResponseBody
  BausparBerechungsErgebnis getCurrentCustomizingState(@RequestBody Berechnungsdaten berechnungsdaten, HttpServletResponse rsp) {

    rsp.setStatus(SC_OK);
    return new BausparBerechungsErgebnis();
  }
}
