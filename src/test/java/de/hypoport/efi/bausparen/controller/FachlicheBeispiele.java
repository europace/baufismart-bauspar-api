package de.hypoport.efi.bausparen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hypoport.efi.bausparen.model.berechnung.BausparBerechnungsAntwort;
import de.hypoport.efi.bausparen.model.berechnung.Bausparangebot;
import de.hypoport.efi.bausparen.model.berechnung.SparPlan;
import de.hypoport.efi.bausparen.model.berechnung.SparPlanZahlung;
import de.hypoport.efi.bausparen.model.berechnung.TilgungsPlan;
import de.hypoport.efi.bausparen.model.berechnung.TilgungsPlanZahlung;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.BausparBerechnungsAnfrage;
import de.hypoport.efi.bausparen.model.dokumente.DokumentErzeugenAnfrage;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FachlicheBeispiele {

  private ObjectMapper objectMapper;

  @Before
  public void setUp() {
    objectMapper = new ObjectMapper();
    objectMapper.findAndRegisterModules();
  }

  @Test
  public void berechnungsanfrageBeispiel1IstSyntaktischKorrekt() throws IOException {
    berechnungsAnfrageIstGueltig("/testfall1/berechnungsanfrage.json");
  }

  @Test
  public void berechnungsanfrageBeispiel2IstSyntaktischKorrekt() throws IOException {
    berechnungsAnfrageIstGueltig("/testfall2/berechnungsanfrage.json");
  }

  @Test
  public void berechnetesBausparangebotBeispiel1IstSyntaktischKorrekt() throws IOException {
    berechnetesAngebotIstGueltig("/testfall1/berechnetesbausparangebot.json");
  }

  @Test
  public void berechnetesBausparangebotBeispiel2IstSyntaktischKorrekt() throws IOException {
    berechnetesAngebotIstGueltig("/testfall2/berechnetesbausparangebot.json");
  }

  private void berechnetesAngebotIstGueltig(String zuPruefendesAngebot) throws IOException {
    BausparBerechnungsAntwort bausparBerechnungsAntwort = objectMapper.readValue(getClass().getResourceAsStream(zuPruefendesAngebot), BausparBerechnungsAntwort.class);

    assertNotNull(bausparBerechnungsAntwort);
    Bausparangebot berechnetesBausparAngebot = bausparBerechnungsAntwort.getBerechnetesBausparAngebot();
    assertNotNull(berechnetesBausparAngebot);
    assertNotNull(berechnetesBausparAngebot.getZuteilungsTermin());
    assertNotNull(berechnetesBausparAngebot.getProvision());
    assertNotNull(berechnetesBausparAngebot.getProvision().getVertriebsProvisionInEuro());

    assertEquals((long) berechnetesBausparAngebot.getGesamtlaufzeitKomplettInMonaten(), ermittleLaufzeit(berechnetesBausparAngebot));

    pruefeSparplan(berechnetesBausparAngebot.getSparPhase().getSparPlan(), berechnetesBausparAngebot.getAbschlussgebuehr().getAbschlussgebuehrBetragInEuro().negate());
    pruefeTilgungsplan(berechnetesBausparAngebot.getBausparDarlehen().getTilgungsPlan());
  }

  private void berechnungsAnfrageIstGueltig(String zuPruefendeDatei) throws IOException {
    BausparBerechnungsAnfrage bausparBerechnungsAnfrage = objectMapper.readValue(getClass().getResourceAsStream(zuPruefendeDatei), BausparBerechnungsAnfrage.class);

    assertNotNull(bausparBerechnungsAnfrage);
    assertNotNull(bausparBerechnungsAnfrage.getZielTarif());
    assertNotNull(bausparBerechnungsAnfrage.getBerechnungsZiel());
    assertNotNull(bausparBerechnungsAnfrage.getVertragsDatum());
    assertNotNull(bausparBerechnungsAnfrage.getBerechnungsArt());
    assertNotNull(bausparBerechnungsAnfrage.getAbschlussgebuehrenbehandlung());
    assertNotNull(bausparBerechnungsAnfrage.getFallNummer());
    assertNotNull(bausparBerechnungsAnfrage.getRequestId());
    assertNotNull(bausparBerechnungsAnfrage.getVermittlerNr());
    assertNotNull(bausparBerechnungsAnfrage.getDarlehensWunsch());

    if (bausparBerechnungsAnfrage.getAuszahlungsbetragBeiZuteilung() == null) {
      assertNotNull(bausparBerechnungsAnfrage.getBausparsummeInEuro() != null);
    }
    if (bausparBerechnungsAnfrage.getBausparsummeInEuro() == null) {
      assertNotNull(bausparBerechnungsAnfrage.getAuszahlungsbetragBeiZuteilung() != null);
    }
    assertNotNull(bausparBerechnungsAnfrage.getDarlehensWunsch());
  }

  @Test
  public void dokumentenAnfrageBeispiel1IstSyntaktischKorrekt() throws IOException {

    pruefeDokumentenAnfrage("/testfall1/dokumenteanfrage.json");
  }

  @Test
  public void dokumentenAnfrageBeispiel2IstSyntaktischKorrekt() throws IOException {

    pruefeDokumentenAnfrage("/testfall2/dokumenteanfrage.json");
  }

  private void pruefeDokumentenAnfrage(String beispielDatei) throws IOException {
    DokumentErzeugenAnfrage dokumentErzeugenAnfrage = objectMapper.readValue(getClass().getResourceAsStream(beispielDatei), DokumentErzeugenAnfrage.class);

    assertNotNull(dokumentErzeugenAnfrage);
  }

  private void pruefeTilgungsplan(TilgungsPlan tilgungsPlan) {
    List<TilgungsPlanZahlung> tilgungsPlanZahlungen = tilgungsPlan.getZahlungen();
    List<LocalDate> tilgungsDaten = elementeAlsListe(tilgungsPlanZahlungen, z -> z.getDatum());
    assertZahlDatenAufeinanderfolgend(tilgungsDaten);

    assertSaldenPassenZuZahlungen(
        tilgungsPlanZahlungen, BigDecimal.ZERO,
        z -> z.getZahlungInEuro().subtract(z.getZinsInEuro()),
        z -> z.getSaldoNachZahlungInEuro()
    );
  }

  private void pruefeSparplan(SparPlan sparPlan, BigDecimal auszahlungsgebuehr) {
    List<SparPlanZahlung> sparPlanZahlungen = sparPlan.getZahlungen();
    List<LocalDate> zahlDaten = elementeAlsListe(sparPlanZahlungen, z -> z.getDatum());
    assertZahlDatenAufeinanderfolgend(zahlDaten);

    assertSaldenPassenZuZahlungen(
        sparPlanZahlungen, auszahlungsgebuehr,
        z -> z.getZahlungInEuro().add(z.getZinsInEuro()),
        z -> z.getSaldoNachZahlungInEuro()
    );
  }

  private <Z> void assertSaldenPassenZuZahlungen(List<Z> zahlungsobjekte, BigDecimal anfangssaldo, Function<Z, BigDecimal> zahlungsErmittler, Function<Z, BigDecimal> saldoErmittler) {

    assertTrue(zahlungsobjekte.size() > 0);
    BigDecimal letzerSaldo = anfangssaldo;

    for (int i = 0; i < zahlungsobjekte.size(); i++) {
      Z zahlungsobjektI = zahlungsobjekte.get(i);
      BigDecimal saldoNachZahlung = saldoErmittler.apply(zahlungsobjektI).setScale(2);
      BigDecimal zahlung = zahlungsErmittler.apply(zahlungsobjektI);

      assertEquals(format("Der %d. Saldo stimmt nicht überein:", i), saldoNachZahlung, letzerSaldo.add(zahlung));

      letzerSaldo = saldoNachZahlung;
    }
  }

  private void assertZahlDatenAufeinanderfolgend(List<LocalDate> zahlDaten) {
    assertTrue(zahlDaten.size() > 0);
    LocalDate datumVorigeZahlung = zahlDaten.get(0);
    for (int i = 1; i < zahlDaten.size(); i++) {
      LocalDate datumZahlung = zahlDaten.get(i);
      assertDatenFolgenAufeinander(datumVorigeZahlung, datumZahlung);
      datumVorigeZahlung = datumZahlung;
    }
  }

  private void assertDatenFolgenAufeinander(LocalDate datumVorigeZahlung, LocalDate datumZahlung) {
    long monateZwischen = monateZwischen(datumVorigeZahlung, datumZahlung);
    assertEquals(format("Die Daten %s und %s sollten aufeinander folgen", datumVorigeZahlung, datumZahlung), 1, monateZwischen);
  }

  private long ermittleLaufzeit(Bausparangebot berechnetesBausparAngebot) {
    SparPlanZahlung ersteSparrate = berechnetesBausparAngebot.getSparPhase().getSparPlan().getZahlungen().get(0);
    LocalDate tilgungsende = berechnetesBausparAngebot.getBausparDarlehen().getTilgungsende();
    return monateZwischen(ersteSparrate.getDatum(), tilgungsende);
  }

  private <S, D> List<D> elementeAlsListe(List<S> zahlungsListe, Function<S, D> f) {
    return zahlungsListe.stream().map(f).collect(Collectors.toList());
  }

  private long monateZwischen(LocalDate erstesDatum, LocalDate zweitesDatumInklusive) {
    return Period.between(erstesDatum, zweitesDatumInklusive.plusDays(1)).toTotalMonths();
  }
}
