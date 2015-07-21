package de.hypoport.efi.bausparen.controller;

import de.hypoport.efi.bausparen.model.dokumente.Dokument;
import de.hypoport.efi.bausparen.model.dokumente.DokumentErzeugenAnfrage;
import de.hypoport.efi.bausparen.model.dokumente.DokumentErzeugenAntwort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Api(value = "/dokumente", description = "Dokumente Service")
public class BausparDokumenteController {

  @RequestMapping(value = "dokumente/", method = GET, produces = APPLICATION_JSON_VALUE + ";charset=UTF-8")
  @ApiOperation(
      value = "Erzeuge Dokument",
      response = DokumentErzeugenAntwort.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Dokument erzeugt"),
      @ApiResponse(code = 404, message = "Dokument konnte nicht erzeugt werden")}
  )
  public
  @ResponseBody
  DokumentErzeugenAntwort getCurrentCustomizingState(@RequestBody DokumentErzeugenAnfrage dokumentErzeugenAnfrage, HttpServletResponse rsp) throws Exception {

    rsp.setStatus(SC_OK);
    DokumentErzeugenAntwort antwort = erzeugeAntwort();
    return antwort;
  }

  private DokumentErzeugenAntwort erzeugeAntwort() throws IOException {
    DokumentErzeugenAntwort antwort = new DokumentErzeugenAntwort();
    ArrayList<Dokument> erzeugteDokumente = new ArrayList<>();
    Dokument dokument = new Dokument();
    dokument.setDokumentName("Beispiel");
    dokument.setDokumentBase64Encoded(getDokument("documents/beispiel.pdf"));
    erzeugteDokumente.add(dokument);
    antwort.setErzeugteDokumente(erzeugteDokumente);
    return antwort;
  }

  private String getDokument(String path) throws IOException {
    InputStream inputStream = new ClassPathResource(path).getInputStream();
    Base64.Encoder encoder = Base64.getEncoder();
    byte[] bytes = IOUtils.toByteArray(inputStream);
    byte[] base64Encoded = encoder.encode(bytes);
    return new String(base64Encoded);
  }
}
