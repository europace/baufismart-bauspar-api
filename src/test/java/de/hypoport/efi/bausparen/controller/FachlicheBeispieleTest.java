package de.hypoport.efi.bausparen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hypoport.efi.bausparen.model.basis.SparBeitrag;
import de.hypoport.efi.bausparen.model.basis.TilgungsBeitrag;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.BausparBerechnungsAnfrage;
import de.hypoport.efi.bausparen.model.berechnung.angebot.BausparBerechnungsAntwort;
import de.hypoport.efi.bausparen.model.berechnung.angebot.Bausparangebot;
import de.hypoport.efi.bausparen.model.berechnung.angebot.SparPlan;
import de.hypoport.efi.bausparen.model.berechnung.angebot.SparPlanZahlung;
import de.hypoport.efi.bausparen.model.berechnung.angebot.TilgungsPlan;
import de.hypoport.efi.bausparen.model.berechnung.angebot.TilgungsPlanZahlung;
import de.hypoport.efi.bausparen.model.dokumente.Antragsteller;
import de.hypoport.efi.bausparen.model.dokumente.DokumentErzeugenAnfrage;
import de.hypoport.efi.bausparen.model.dokumente.SonderZahlung;
import de.hypoport.efi.bausparen.model.dokumente.SparphaseDokument;
import de.hypoport.efi.bausparen.model.dokumente.VermittlerDaten;
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

public class FachlicheBeispieleTest {

  private ObjectMapper objectMapper;
  private DokumentErzeugenAnfrage dokumentErzeugenAnfrage;

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
    assertNotNull(bausparBerechnungsAnfrage.getSparBeginn());
    assertNotNull(bausparBerechnungsAnfrage.getBerechnungsArt());
    assertNotNull(bausparBerechnungsAnfrage.getAbschlussgebuehrenbehandlung());
    assertNotNull(bausparBerechnungsAnfrage.getFallNummer());
    assertNotNull(bausparBerechnungsAnfrage.getRequestId());
    assertNotNull(bausparBerechnungsAnfrage.getVermittlerNr());
    assertNotNull(bausparBerechnungsAnfrage.getDarlehensWunsch());
    assertNotNull(bausparBerechnungsAnfrage.getVertriebsGruppe());
    assertNotNull(bausparBerechnungsAnfrage.getBausparsummeInEuro() != null);
    assertNotNull(bausparBerechnungsAnfrage.getBausparkasseIstDarlehensgeber() != null);

    assertNotNull(bausparBerechnungsAnfrage.getDarlehensWunsch());
  }

  @Test
  public void dokumentenAnfrageBeispiel1IstSyntaktischKorrekt() throws IOException {
    pruefeDokumentenAnfrage("/testfall1/dokumenteanfrage.json");
  }

  @Test
  public void dokumentenAnfrageBeispiel2IstSyntaktischKorrekt() throws IOException {
    pruefeDokumentenAnfrage("/testfall2/dokumenteanfrage.json");
    assertTrue(dokumentErzeugenAnfrage.getAntragsteller().size() == 2);
  }

  private void pruefeDokumentenAnfrage(String beispielDatei) throws IOException {
    dokumentErzeugenAnfrage = objectMapper.readValue(getClass().getResourceAsStream(beispielDatei), DokumentErzeugenAnfrage.class);

    assertNotNull(dokumentErzeugenAnfrage);
    assertNotNull(dokumentErzeugenAnfrage.getTarif());
    assertNotNull(dokumentErzeugenAnfrage.getBerechnungsArt());
    assertNotNull(dokumentErzeugenAnfrage.getBausparSummeInEuro());
    assertNotNull(dokumentErzeugenAnfrage.getAbschlussgebuehrenbehandlung());
    assertNotNull(dokumentErzeugenAnfrage.getAbschlussgebuehrHoeheInEuro());
    assertAntragsteller(dokumentErzeugenAnfrage.getAntragsteller());
    assertVermittlerDaten(dokumentErzeugenAnfrage.getVermittlerDaten());
    assertSparphaseDokument(dokumentErzeugenAnfrage.getSparphaseDokument());
    assertNotNull(dokumentErzeugenAnfrage.getVertragsDatum());
    assertNotNull(dokumentErzeugenAnfrage.getSparBeginn());
    assertNotNull(dokumentErzeugenAnfrage.getLaufzeitBisZuteilungInMonaten());
    assertNotNull(dokumentErzeugenAnfrage.getVertriebsGruppe());
    assertNotNull(dokumentErzeugenAnfrage.getZielTarif());
    assertNotNull(dokumentErzeugenAnfrage.getZuteilungstermin());
    assertNotNull(dokumentErzeugenAnfrage.getBerechnungsZiel());
    assertNotNull(dokumentErzeugenAnfrage.getDarlehensWunsch());
    assertTilgungsBeitrag(dokumentErzeugenAnfrage.getTilgungsBeitrag());
    assertNotNull(dokumentErzeugenAnfrage.getFallNummer());
    assertNotNull(dokumentErzeugenAnfrage.getRequestId());
    assertNotNull(dokumentErzeugenAnfrage.getFallAuswahl());
    assertNotNull(dokumentErzeugenAnfrage.getBausparkasseIstDarlehensgeber());
    assertNotNull(dokumentErzeugenAnfrage.getRiesterDaten());
    assertSonderZahlungen(dokumentErzeugenAnfrage.getSonderZahlungen());
  }

  private void assertAntragsteller(List<Antragsteller> antragstellerListe) {
    assertNotNull(antragstellerListe);
    assertTrue(antragstellerListe.size() > 0);
    assertAntragsteller(antragstellerListe.iterator().next());
  }

  private void assertTilgungsBeitrag(TilgungsBeitrag tilgungsBeitrag) {
    assertNotNull(tilgungsBeitrag);
    assertNotNull(tilgungsBeitrag.getZahlungsrhythmus());
    assertNotNull(tilgungsBeitrag.getRateInEuro());
  }

  private void assertAntragsteller(Antragsteller antragsteller) {
    assertNotNull(antragsteller.getAnrede());
    assertNotNull(antragsteller.getEinkommenssteuerpflichtigInUsa());
    assertNotNull(antragsteller.getAdresse());
    assertNotNull(antragsteller.getAdresse().getHausNummer());
    assertNotNull(antragsteller.getKontakt());
    assertNotNull(antragsteller.getKontakt().getTelefonNummer());
    assertNotNull(antragsteller.getFamilienStand());
    assertNotNull(antragsteller.getZahlungsDaten());
    assertNotNull(antragsteller.getZahlungsDaten().getBic());
    assertNotNull(antragsteller.getZahlungsDaten().getZahlungsForm());
    assertNotNull(antragsteller.getBeschaeftigungsVerhaeltnis());
    assertNotNull(antragsteller.getLegitimation());
    assertNotNull(antragsteller.getLegitimation().getAusweisArt());
    assertNotNull(antragsteller.getTodesfallBeguenstigter());
    assertNotNull(antragsteller.getTodesfallBeguenstigter().getAnrede());
    assertNotNull(antragsteller.getVermoegenswirksameLeistungenBetragInEuro());
    assertNotNull(antragsteller.getVermoegenswirksameLeistungenZahlungsrhythmus());
    assertNotNull(antragsteller.getBeruf());
  }

  private void assertVermittlerDaten(VermittlerDaten vermittlerDaten) {
    assertNotNull(vermittlerDaten);
    assertNotNull(vermittlerDaten.getOrt());
  }

  private void assertSparphaseDokument(SparphaseDokument sparphaseDokument) {
    assertNotNull(sparphaseDokument);
    assertNotNull(sparphaseDokument.getRegelsparbeitragInEuro());
    assertNotNull(sparphaseDokument.getSparBeitraege());
    assertTrue(sparphaseDokument.getSparBeitraege().size() > 0);
    SparBeitrag sparBeitrag = sparphaseDokument.getSparBeitraege().iterator().next();
    assertNotNull(sparBeitrag.getZahlungsrhythmus());
  }

  private void pruefeTilgungsplan(TilgungsPlan tilgungsPlan) {
    List<TilgungsPlanZahlung> tilgungsPlanZahlungen = tilgungsPlan.getZahlungen();
    List<LocalDate> tilgungsDaten = elementeAlsListe(tilgungsPlanZahlungen, TilgungsPlanZahlung::getDatum);
    assertZahlDatenAufeinanderfolgend(tilgungsDaten);

    assertSaldenPassenZuZahlungen(
        tilgungsPlanZahlungen, BigDecimal.ZERO,
        z -> z.getZahlungInEuro().subtract(z.getZinsInEuro()),
        z -> z.getSaldoNachZahlungInEuro()
    );
  }

  private void pruefeSparplan(SparPlan sparPlan, BigDecimal auszahlungsgebuehr) {
    List<SparPlanZahlung> sparPlanZahlungen = sparPlan.getZahlungen();
    List<LocalDate> zahlDaten = elementeAlsListe(sparPlanZahlungen, SparPlanZahlung::getDatum);
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

  private void assertSonderZahlungen(List<SonderZahlung> sonderZahlungen){
    assertNotNull(sonderZahlungen);
    assertTrue(sonderZahlungen.size() > 0);
    assertSonderZahlung(sonderZahlungen.iterator().next());
  }

  private void assertSonderZahlung(SonderZahlung sonderZahlung){
    assertNotNull(sonderZahlung.getAnzahl());
    assertNotNull(sonderZahlung.getBetrag());
    assertNotNull(sonderZahlung.getTermin());
    assertNotNull(sonderZahlung.getZahlungsrhythmus());
  }
}
