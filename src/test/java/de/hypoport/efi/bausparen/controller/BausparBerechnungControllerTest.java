package de.hypoport.efi.bausparen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import de.hypoport.efi.bausparen.model.berechnung.BerechnungsZiel;
import de.hypoport.efi.bausparen.model.berechnung.Zahlungsrhythmus;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.BausparBerechnungsAnfrage;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.SparBeitrag;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.util.Arrays.asList;

public class BausparBerechnungControllerTest {

  @Test
  public void testGenerateRequest() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.findAndRegisterModules();
    objectMapper.setDateFormat(new ISO8601DateFormat());

    BausparBerechnungsAnfrage berechnungsdaten = new BausparBerechnungsAnfrage();
    berechnungsdaten.setBausparsummeInEuro(new BigDecimal("100000"));
    berechnungsdaten.setBerechnungsZiel(BerechnungsZiel.SPARBEITRAG_INKL_VL);

    SparBeitrag sparBeitrag = new SparBeitrag();
    sparBeitrag.setBeitrag(new BigDecimal("100"));
    sparBeitrag.setZahlungAb(LocalDate.now());
    sparBeitrag.setZahlungBis(LocalDate.now().plusYears(10));
    sparBeitrag.setZahlungsrhythmus(Zahlungsrhythmus.MONATLICH);

    berechnungsdaten.setSparBeitraege(asList(sparBeitrag));

    System.out.println(objectMapper.writeValueAsString(berechnungsdaten));
  }
}