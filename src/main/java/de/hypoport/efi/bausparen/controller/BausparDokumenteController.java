package de.hypoport.efi.bausparen.controller;

import de.hypoport.efi.bausparen.model.dokumente.Dokument;
import de.hypoport.efi.bausparen.model.dokumente.DokumentErzeugenAnfrage;
import de.hypoport.efi.bausparen.model.dokumente.DokumentErzeugenAntwort;
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
public class BausparDokumenteController {

  @RequestMapping(value = "dokumente/", method = GET, produces = APPLICATION_JSON_VALUE + ";charset=UTF-8")
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
    String theString = IOUtils.toString(inputStream, "UTF-8");
    byte[] base64Encoded = encoder.encode(theString.getBytes());
    return new String(base64Encoded);
  }
}
