package de.hypoport.efi.bausparen.model.dokumente;

import de.hypoport.efi.bausparen.model.basis.Abschlussgebuehrenbehandlung;
import de.hypoport.efi.bausparen.model.basis.BerechnungsZiel;
import de.hypoport.efi.bausparen.model.basis.RiesterDaten;
import de.hypoport.efi.bausparen.model.basis.DarlehensWunsch;
import de.hypoport.efi.bausparen.model.basis.TilgungsBeitrag;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.BerechnungsArt;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DokumentErzeugenAnfrage {

  String tarif;
  BerechnungsArt berechnungsArt;
  BigDecimal bausparSummeInEuro;
  Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung;
  BigDecimal abschlussgebuehrHoeheInEuro;
  Boolean bausparkasseIstDarlehensgeber;
  List<Antragsteller> antragsteller;
  VermittlerDaten vermittlerDaten;
  SparphaseDokument sparphaseDokument;
  LocalDate vertragsDatum;
  LocalDate sparBeginn;
  String fallNummer;
  String requestId;
  Boolean fallAuswahl;
  RiesterDaten riesterDaten;
  BerechnungsZiel berechnungsZiel;
  DarlehensWunsch darlehensWunsch;
  Integer laufzeitBisZuteilungInMonaten;
  String vertriebsGruppe;
  String zielTarif;
  LocalDate zuteilungstermin;
  TilgungsBeitrag tilgungsBeitrag;
  List<SonderZahlung> sonderZahlungen;

  public String getTarif() {
    return tarif;
  }

  public void setTarif(String tarif) {
    this.tarif = tarif;
  }

  public BerechnungsArt getBerechnungsArt() {
    return berechnungsArt;
  }

  public void setBerechnungsArt(BerechnungsArt berechnungsArt) {
    this.berechnungsArt = berechnungsArt;
  }

  public BigDecimal getBausparSummeInEuro() {
    return bausparSummeInEuro;
  }

  public void setBausparSummeInEuro(BigDecimal bausparSummeInEuro) {
    this.bausparSummeInEuro = bausparSummeInEuro;
  }

  public Abschlussgebuehrenbehandlung getAbschlussgebuehrenbehandlung() {
    return abschlussgebuehrenbehandlung;
  }

  public void setAbschlussgebuehrenbehandlung(Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung) {
    this.abschlussgebuehrenbehandlung = abschlussgebuehrenbehandlung;
  }

  public List<Antragsteller> getAntragsteller() {
    return antragsteller;
  }

  public void setAntragsteller(List<Antragsteller> antragsteller) {
    this.antragsteller = antragsteller;
  }

  public VermittlerDaten getVermittlerDaten() {
    return vermittlerDaten;
  }

  public void setVermittlerDaten(VermittlerDaten vermittlerDaten) {
    this.vermittlerDaten = vermittlerDaten;
  }

  public SparphaseDokument getSparphaseDokument() {
    return sparphaseDokument;
  }

  public void setSparphaseDokument(SparphaseDokument sparphaseDokument) {
    this.sparphaseDokument = sparphaseDokument;
  }

  public BigDecimal getAbschlussgebuehrHoeheInEuro() {
    return abschlussgebuehrHoeheInEuro;
  }

  public void setAbschlussgebuehrHoeheInEuro(BigDecimal abschlussgebuehrHoeheInEuro) {
    this.abschlussgebuehrHoeheInEuro = abschlussgebuehrHoeheInEuro;
  }

  public LocalDate getVertragsDatum() {
    return vertragsDatum;
  }

  public void setVertragsDatum(LocalDate vertragsDatum) {
    this.vertragsDatum = vertragsDatum;
  }

  public LocalDate getSparBeginn() {
    return sparBeginn;
  }

  public void setSparBeginn(LocalDate sparBeginn) {
    this.sparBeginn = sparBeginn;
  }

  public String getFallNummer() {
    return fallNummer;
  }

  public void setFallNummer(String fallNummer) {
    this.fallNummer = fallNummer;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public Boolean getFallAuswahl() {
    return fallAuswahl;
  }

  public void setFallAuswahl(Boolean fallAuswahl) {
    this.fallAuswahl = fallAuswahl;
  }

  public Boolean getBausparkasseIstDarlehensgeber() {
    return bausparkasseIstDarlehensgeber;
  }

  public void setBausparkasseIstDarlehensgeber(Boolean bausparkasseIstDarlehensgeber) {
    this.bausparkasseIstDarlehensgeber = bausparkasseIstDarlehensgeber;
  }

  public RiesterDaten getRiesterDaten() {
    return riesterDaten;
  }

  public void setRiesterDaten(RiesterDaten riesterDaten) {
    this.riesterDaten = riesterDaten;
  }

  public BerechnungsZiel getBerechnungsZiel() {
    return berechnungsZiel;
  }

  public void setBerechnungsZiel(BerechnungsZiel berechnungsZiel) {
    this.berechnungsZiel = berechnungsZiel;
  }

  public DarlehensWunsch getDarlehensWunsch() {
    return darlehensWunsch;
  }

  public void setDarlehensWunsch(DarlehensWunsch darlehensWunsch) {
    this.darlehensWunsch = darlehensWunsch;
  }

  public Integer getLaufzeitBisZuteilungInMonaten() {
    return laufzeitBisZuteilungInMonaten;
  }

  public void setLaufzeitBisZuteilungInMonaten(Integer laufzeitBisZuteilungInMonaten) {
    this.laufzeitBisZuteilungInMonaten = laufzeitBisZuteilungInMonaten;
  }

  public String getVertriebsGruppe() {
    return vertriebsGruppe;
  }

  public void setVertriebsGruppe(String vertriebsGruppe) {
    this.vertriebsGruppe = vertriebsGruppe;
  }

  public String getZielTarif() {
    return zielTarif;
  }

  public void setZielTarif(String zielTarif) {
    this.zielTarif = zielTarif;
  }

  public LocalDate getZuteilungstermin() {
    return zuteilungstermin;
  }

  public void setZuteilungstermin(LocalDate zuteilungstermin) {
    this.zuteilungstermin = zuteilungstermin;
  }

  public TilgungsBeitrag getTilgungsBeitrag() {
    return tilgungsBeitrag;
  }

  public void setTilgungsBeitrag(TilgungsBeitrag tilgungsBeitrag) {
    this.tilgungsBeitrag = tilgungsBeitrag;
  }

  public List<SonderZahlung> getSonderZahlungen() {
    return sonderZahlungen;
  }

  public void setSonderZahlungen(List<SonderZahlung> sonderZahlungen) {
    this.sonderZahlungen = sonderZahlungen;
  }
}