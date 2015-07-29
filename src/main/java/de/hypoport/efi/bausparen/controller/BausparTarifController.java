package de.hypoport.efi.bausparen.controller;

import de.hypoport.efi.bausparen.model.berechnung.BausparBerechnungsAntwort;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.BausparBerechnungsAnfrage;
import de.hypoport.efi.bausparen.model.tarife.BausparTarif;
import de.hypoport.efi.bausparen.model.tarife.BausparTarifInformationen;
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

import static java.util.Arrays.asList;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@Api(value = "/bauspartarife", description = "Bauspartarif Informationen")
public class BausparTarifController {

  @RequestMapping(value = "bauspartarife/", method = GET, produces = APPLICATION_JSON_VALUE + ";charset=UTF-8")
  @ApiOperation(
      value = "Beschreibt die Bauspartarife dieser Bausparkasse",
      response = BausparTarifInformationen.class)

  public
  @ResponseBody
  BausparTarifInformationen getBausparTarife(HttpServletResponse rsp) {

    rsp.setStatus(SC_OK);
    BausparTarifInformationen bausparTarifInformationen = new BausparTarifInformationen();
    bausparTarifInformationen.setTarife(asList(tarif1(), tarif2(), tarif3()));
    return bausparTarifInformationen;
  }

  private BausparTarif tarif1() {
    BausparTarif bausparTarif = new BausparTarif();
    bausparTarif.setId("T1");
    bausparTarif.setName("SparschweinTarif 1");
    return bausparTarif;
  }

  private BausparTarif tarif2() {
    BausparTarif bausparTarif = new BausparTarif();
    bausparTarif.setId("T2");
    bausparTarif.setName("SparschweinTarif 2");
    return bausparTarif;
  }

  private BausparTarif tarif3() {
    BausparTarif bausparTarif = new BausparTarif();
    bausparTarif.setId("T3");
    bausparTarif.setName("SparschweinTarif 3");
    return bausparTarif;
  }
}
