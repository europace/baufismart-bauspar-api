package de.hypoport.efi.bausparen.controller;

import de.hypoport.efi.bausparen.model.berechnung.BausparBerechnungsAntwort;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.BausparBerechnungsAnfrage;
import de.hypoport.efi.bausparen.proofofconcept.ProofOfConceptBausparBerechnung;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@Api(value = "/bausparangebot", description = "Bausparberechnungs Operationen")
@RequestMapping(value = "${url.prefix}/bausparangebot")
public class BausparBerechnungController {

  @Autowired
  private ProofOfConceptBausparBerechnung bausparBerechnung;

  @RequestMapping(value = "/", method = POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE + ";charset=UTF-8")
  @ApiOperation(
      value = "Berechne Bauspar Angebot",
      response = BausparBerechnungsAntwort.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Es wird eine gültige Schnittstellenantwort geliefert"),
      @ApiResponse(code = 500, message = "Es konnte keine Schnittstellenantwort erstellt werden")}
  )
  public
  @ResponseBody
  BausparBerechnungsAntwort berechneBausparAngebot(@RequestBody BausparBerechnungsAnfrage berechnungsdaten, HttpServletResponse rsp) {

    BausparBerechnungsAntwort bausparBerechnungsAntwort = null;
    try {
      bausparBerechnungsAntwort = bausparBerechnung.berechneBausparAngebot(berechnungsdaten);
      rsp.setStatus(SC_OK);
    }
    catch (Exception e) {
      e.printStackTrace();
      rsp.setStatus(500);
    }
    return bausparBerechnungsAntwort;
  }
}
