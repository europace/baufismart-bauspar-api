package de.hypoport.efi.bausparen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hypoport.efi.bausparen.model.berechnung.BausparBerechnungsAntwort;
import de.hypoport.efi.bausparen.model.berechnung.Bausparangebot;
import de.hypoport.efi.bausparen.model.berechnung.SparPlan;
import de.hypoport.efi.bausparen.model.berechnung.SparPlanZahlung;
import de.hypoport.efi.bausparen.model.berechnung.TilgungsPlan;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.BausparBerechnungsAnfrage;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    assertEquals((long) berechnetesBausparAngebot.getGesamtlaufzeitKomplettInMonaten(), ermittleLaufzeit(berechnetesBausparAngebot));

    pruefeSparplan(berechnetesBausparAngebot.getSparPhase().getSparPlan());
    pruefeTilgungsplan(berechnetesBausparAngebot.getBausparDarlehen().getTilgungsPlan());
    // TODO fachl. korrekte Assertions

  }

  private void pruefeTilgungsplan(TilgungsPlan tilgungsPlan) {
    List<LocalDate> tilgungsDaten = tilgungsPlan.getZahlungen().stream().map(z -> z.getDatum()).collect(Collectors.toList());
    assertZahlDatenAufeinanderfolgend(tilgungsDaten);
  }

  private void pruefeSparplan(SparPlan sparPlan) {
    List<LocalDate> zahlDaten = sparPlan.getZahlungen().stream().map(z -> z.getDatum()).collect(Collectors.toList());
    assertZahlDatenAufeinanderfolgend(zahlDaten);
  }

  private void assertZahlDatenAufeinanderfolgend(List<LocalDate> zahlDaten) {
    assertTrue(zahlDaten.size() > 0);
    LocalDate datumVorigeZahlung = zahlDaten.get(0);
    for (int i = 1; i < zahlDaten.size(); i++) {
      LocalDate datumZahlung = zahlDaten.get(i);
      long monateZwischen = monateZwischen(datumVorigeZahlung, datumZahlung);
      assertEquals(format("Die Daten %s und %s sollten aufeinander folgen",datumVorigeZahlung, datumZahlung),1, monateZwischen);
      datumVorigeZahlung = datumZahlung;
    }
  }

  private long ermittleLaufzeit(Bausparangebot berechnetesBausparAngebot) {
    SparPlanZahlung ersteSparrate = berechnetesBausparAngebot.getSparPhase().getSparPlan().getZahlungen().get(0);
    LocalDate tilgungsende = berechnetesBausparAngebot.getBausparDarlehen().getTilgungsende();
    return monateZwischen(ersteSparrate.getDatum(), tilgungsende);
  }

  private long monateZwischen(LocalDate erstesDatum, LocalDate zweitesDatumInklusive) {
    return Period.between(erstesDatum, zweitesDatumInklusive.plusDays(1)).toTotalMonths();
  }
}
