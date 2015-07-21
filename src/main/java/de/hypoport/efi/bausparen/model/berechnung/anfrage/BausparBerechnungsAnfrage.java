package de.hypoport.efi.bausparen.model.berechnung.anfrage;

import de.hypoport.efi.bausparen.model.berechnung.Abschlussgebuehrenbehandlung;
import de.hypoport.efi.bausparen.model.berechnung.BerechnungsZiel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BausparBerechnungsAnfrage {

  BerechnungsArt berechnungsArt; //check
  String zielTarif; //check
  LocalDate vertragsbeginn; //check
  BerechnungsZiel berechnungsZiel; //check
  BigDecimal bausparsummeInEuro; //check
  BigDecimal abzuloesendesDarlehenInEuro; //check
  Integer laufzeitBisZuteilungInMonaten; //check

  Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung; //check

  DarlehensWunsch darlehensWunsch; //check

  List<SparBeitrag> sparBeitraege;

  TilgungsBeitrag tilgungsBeitrag;

  public BerechnungsArt getBerechnungsArt() {
    return berechnungsArt;
  }

  public void setBerechnungsArt(BerechnungsArt berechnungsArt) {
    this.berechnungsArt = berechnungsArt;
  }

  public String getZielTarif() {
    return zielTarif;
  }

  public void setZielTarif(String zielTarif) {
    this.zielTarif = zielTarif;
  }

  public LocalDate getVertragsbeginn() {
    return vertragsbeginn;
  }

  public void setVertragsbeginn(LocalDate vertragsbeginn) {
    this.vertragsbeginn = vertragsbeginn;
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

  public BigDecimal getAbzuloesendesDarlehenInEuro() {
    return abzuloesendesDarlehenInEuro;
  }

  public void setAbzuloesendesDarlehenInEuro(BigDecimal abzuloesendesDarlehenInEuro) {
    this.abzuloesendesDarlehenInEuro = abzuloesendesDarlehenInEuro;
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
}
