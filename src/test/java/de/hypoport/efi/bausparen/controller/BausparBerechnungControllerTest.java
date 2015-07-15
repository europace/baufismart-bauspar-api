package de.hypoport.efi.bausparen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hypoport.efi.bausparen.model.BerechnungsZiel;
import de.hypoport.efi.bausparen.model.Berechnungsdaten;
import org.junit.Test;

import java.math.BigDecimal;

public class BausparBerechnungControllerTest {

  @Test
  public void testGenerateRequest() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();

    Berechnungsdaten berechnungsdaten = new Berechnungsdaten();
    berechnungsdaten.setBausparsumme(new BigDecimal("100000"));
    berechnungsdaten.setBerechnungsZiel(BerechnungsZiel.SPARRATE);
    berechnungsdaten.setEinmalzahlung(new BigDecimal("10000"));

    System.out.println(objectMapper.writeValueAsString(berechnungsdaten));
  }
}