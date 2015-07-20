package de.hypoport.efi.bausparen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hypoport.efi.bausparen.model.berechnung.BerechnungsZiel;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.BausparBerechnungsAnfrage;
import org.junit.Test;

import java.math.BigDecimal;

public class BausparBerechnungControllerTest {

  @Test
  public void testGenerateRequest() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();

    BausparBerechnungsAnfrage berechnungsdaten = new BausparBerechnungsAnfrage();
    berechnungsdaten.setBausparsummeInEuro(new BigDecimal("100000"));
    berechnungsdaten.setBerechnungsZiel(BerechnungsZiel.SPARRATE);
    berechnungsdaten.setEinmalzahlungInEuro(new BigDecimal("10000"));

    System.out.println(objectMapper.writeValueAsString(berechnungsdaten));
  }
}