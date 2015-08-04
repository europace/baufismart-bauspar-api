package de.hypoport.efi.bausparen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hypoport.efi.bausparen.model.berechnung.BausparBerechnungsAntwort;
import de.hypoport.efi.bausparen.model.berechnung.Bausparangebot;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.BausparBerechnungsAnfrage;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;

public class FachlicheBeispiele {

  private ObjectMapper objectMapper;

  @Before
  public void setUp() throws Exception {
    objectMapper = new ObjectMapper();
    objectMapper.findAndRegisterModules();
  }

  @Test
  public void berechnungsanfrageIstSyntaktischKorrekt() throws IOException {
    BausparBerechnungsAnfrage bausparBerechnungsAnfrage = objectMapper.readValue(getClass().getResourceAsStream("/testfall1/berechnungsanfrage.json"), BausparBerechnungsAnfrage.class);

    assertNotNull(bausparBerechnungsAnfrage);
    assertNotNull(bausparBerechnungsAnfrage.getZielTarif());
    assertNotNull(bausparBerechnungsAnfrage.getBerechnungsZiel());

    if (bausparBerechnungsAnfrage.getAbzuloesendesDarlehenInEuro() == null) {
      assertNotNull(bausparBerechnungsAnfrage.getBausparsummeInEuro() != null);
    }
    if (bausparBerechnungsAnfrage.getBausparsummeInEuro() == null) {
      assertNotNull(bausparBerechnungsAnfrage.getAbzuloesendesDarlehenInEuro() != null);
    }
    assertNotNull(bausparBerechnungsAnfrage.getDarlehensWunsch());

    // TODO fachl. korrekte Assertions ergänzen
  }

  @Test
  public void berechnetesBausparangebotIstSyntaktischKorrekt() throws IOException {

  BausparBerechnungsAntwort bausparBerechnungsAntwort = objectMapper.readValue(getClass().getResourceAsStream("/testfall1/berechnetesbausparangebot.json"), BausparBerechnungsAntwort.class);

    assertNotNull(bausparBerechnungsAntwort);
    Bausparangebot berechnetesBausparAngebot = bausparBerechnungsAntwort.getBerechnetesBausparAngebot();
    assertNotNull(berechnetesBausparAngebot);
    assertNotNull(berechnetesBausparAngebot.getZuteilungsTermin());

    // TODO fachl. korrekte Assertions

  }

}
