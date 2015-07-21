package de.hypoport.efi.bausparen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import de.hypoport.efi.bausparen.model.berechnung.BerechnungsZiel;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.BausparBerechnungsAnfrage;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BausparBerechnungControllerTest {

  @Test
  public void testGenerateRequest() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.findAndRegisterModules();
    objectMapper.setDateFormat(new ISO8601DateFormat());

    BausparBerechnungsAnfrage berechnungsdaten = new BausparBerechnungsAnfrage();
    berechnungsdaten.setBausparsummeInEuro(new BigDecimal("100000"));
    berechnungsdaten.setBerechnungsZiel(BerechnungsZiel.SPARRATE);
    berechnungsdaten.setEinmalzahlungInEuro(new BigDecimal("10000"));
    berechnungsdaten.setVertragsbeginn(LocalDate.now());

    System.out.println(objectMapper.writeValueAsString(berechnungsdaten));
  }
}