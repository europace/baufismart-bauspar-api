package de.hypoport.efi.bausparen.controller;

import de.hypoport.efi.bausparen.model.dokumente.Dokument;
import de.hypoport.efi.bausparen.model.dokumente.DokumentErzeugenAnfrage;
import de.hypoport.efi.bausparen.model.dokumente.DokumentErzeugenAntwort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BausparDokumenteController {

  @RequestMapping(value = "dokumente/", method = GET, produces = APPLICATION_JSON_VALUE + ";charset=UTF-8")
  public
  @ResponseBody
  DokumentErzeugenAntwort getCurrentCustomizingState(@RequestBody DokumentErzeugenAnfrage dokumentErzeugenAnfrage, HttpServletResponse rsp) {

    rsp.setStatus(SC_OK);
    DokumentErzeugenAntwort antwort = new DokumentErzeugenAntwort();
    ArrayList<Dokument> erzeugteDokumente = new ArrayList<>();
    Dokument dokument = new Dokument();
    dokument.setDokumentName("name");
    erzeugteDokumente.add(dokument);
    antwort.setErzeugteDokumente(erzeugteDokumente);
    return antwort;
  }
}
