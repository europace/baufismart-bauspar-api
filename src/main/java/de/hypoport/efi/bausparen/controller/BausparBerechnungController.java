package de.hypoport.efi.bausparen.controller;

import de.hypoport.efi.bausparen.model.berechnung.BausparBerechnungsAnfrage;
import de.hypoport.efi.bausparen.model.berechnung.BausparBerechnungsAntwort;
import de.hypoport.efi.bausparen.proofofconcept.ProofOfConceptBausparBerechnung;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BausparBerechnungController {

  @Autowired
  private ProofOfConceptBausparBerechnung bausparBerechnung;

  @RequestMapping(value = "bausparangebot/", method = POST, produces = APPLICATION_JSON_VALUE + ";charset=UTF-8")
  @ApiOperation(
      value = "Berechne Bauspar Angebot",
      response = BausparBerechnungsAntwort.class)
  @ApiResponses(value = {
      @ApiResponse(code = 400, message = "Ungueltige Anfrage"),
      @ApiResponse(code = 404, message = "Bausparkasse kann kein Angebot erstellen")}
  )

  public
  @ResponseBody
  BausparBerechnungsAntwort berechneBausparAngebot(@RequestBody BausparBerechnungsAnfrage berechnungsdaten, HttpServletResponse rsp) {

    rsp.setStatus(SC_OK);
    return bausparBerechnung.berechneBausparAngebot(berechnungsdaten);
  }
}
