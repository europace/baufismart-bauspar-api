package de.hypoport.efi.bausparen.model.berechnung.anfrage;

import de.hypoport.efi.bausparen.model.basis.Abschlussgebuehrenbehandlung;
import de.hypoport.efi.bausparen.model.basis.BerechnungsZiel;
import de.hypoport.efi.bausparen.model.basis.SparBeitrag;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BausparBerechnungsAnfrage {

  String zielTarif;
  BerechnungsZiel berechnungsZiel;
  BerechnungsArt berechnungsArt;
  BigDecimal bausparsummeInEuro;
  Integer laufzeitBisZuteilungInMonaten;
  LocalDate zuteilungstermin;
  LocalDate vertragsDatum;
  List<SparBeitrag> sparBeitraege;
  TilgungsBeitrag tilgungsBeitrag;
  Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung;
  DarlehensWunsch darlehensWunsch;
  String vermittlerNr;
  String requestId;
  String fallNummer;
  String vertriebsGruppe;

  public LocalDate getZuteilungstermin() {
    return zuteilungstermin;
  }

  public void setZuteilungstermin(LocalDate zuteilungstermin) {
    this.zuteilungstermin = zuteilungstermin;
  }

  public String getVermittlerNr() {
    return vermittlerNr;
  }

  public void setVermittlerNr(String vermittlerNr) {
    this.vermittlerNr = vermittlerNr;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public String getZielTarif() {
    return zielTarif;
  }

  public void setZielTarif(String zielTarif) {
    this.zielTarif = zielTarif;
  }

  public BerechnungsZiel getBerechnungsZiel() {
    return berechnungsZiel;
  }

  public void setBerechnungsZiel(BerechnungsZiel berechnungsZiel) {
    this.berechnungsZiel = berechnungsZiel;
  }

  public BigDecimal getBausparsummeInEuro() {
    return bausparsummeInEuro;
  }

  public void setBausparsummeInEuro(BigDecimal bausparsummeInEuro) {
    this.bausparsummeInEuro = bausparsummeInEuro;
  }

  public Integer getLaufzeitBisZuteilungInMonaten() {
    return laufzeitBisZuteilungInMonaten;
  }

  public void setLaufzeitBisZuteilungInMonaten(Integer laufzeitBisZuteilungInMonaten) {
    this.laufzeitBisZuteilungInMonaten = laufzeitBisZuteilungInMonaten;
  }

  public Abschlussgebuehrenbehandlung getAbschlussgebuehrenbehandlung() {
    return abschlussgebuehrenbehandlung;
  }

  public void setAbschlussgebuehrenbehandlung(Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung) {
    this.abschlussgebuehrenbehandlung = abschlussgebuehrenbehandlung;
  }

  public DarlehensWunsch getDarlehensWunsch() {
    return darlehensWunsch;
  }

  public void setDarlehensWunsch(DarlehensWunsch darlehensWunsch) {
    this.darlehensWunsch = darlehensWunsch;
  }

  public List<SparBeitrag> getSparBeitraege() {
    return sparBeitraege;
  }

  public void setSparBeitraege(List<SparBeitrag> sparBeitraege) {
    this.sparBeitraege = sparBeitraege;
  }

  public TilgungsBeitrag getTilgungsBeitrag() {
    return tilgungsBeitrag;
  }

  public void setTilgungsBeitrag(TilgungsBeitrag tilgungsBeitrag) {
    this.tilgungsBeitrag = tilgungsBeitrag;
  }

  public String getFallNummer() {
    return fallNummer;
  }

  public void setFallNummer(String fallNummer) {
    this.fallNummer = fallNummer;
  }

  public LocalDate getVertragsDatum() {
    return vertragsDatum;
  }

  public void setVertragsDatum(LocalDate vertragsDatum) {
    this.vertragsDatum = vertragsDatum;
  }

  public BerechnungsArt getBerechnungsArt() {
    return berechnungsArt;
  }

  public void setBerechnungsArt(BerechnungsArt berechnungsArt) {
    this.berechnungsArt = berechnungsArt;
  }

  public String getVertriebsGruppe() {
    return vertriebsGruppe;
  }

  public void setVertriebsGruppe(String vertriebsGruppe) {
    this.vertriebsGruppe = vertriebsGruppe;
  }
}