package de.hypoport.efi.bausparen.controller;

import de.hypoport.efi.bausparen.model.berechnung.BausparBerechnungsAnfrage;
import de.hypoport.efi.bausparen.model.berechnung.BausparBerechnungsAntwort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BausparBerechnungController {

  @RequestMapping(value = "bausparangebot/", method = GET, produces = APPLICATION_JSON_VALUE + ";charset=UTF-8")
  public
  @ResponseBody
  BausparBerechnungsAntwort getCurrentCustomizingState(@RequestBody BausparBerechnungsAnfrage berechnungsdaten, HttpServletResponse rsp) {

    rsp.setStatus(SC_OK);
    BausparBerechnungsAntwort bausparBerechungsErgebnis = new BausparBerechnungsAntwort();
    bausparBerechungsErgebnis.setTarif("4711");
    return bausparBerechungsErgebnis;
  }
}
