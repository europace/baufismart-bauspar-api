package de.hypoport.efi.bausparen.model.berechnung;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BausparBerechnungsAnfrage {

  BerechnungsZiel berechnungsZiel;
  Berechnungsart berechnungsart;
  Integer laufzeitBisZuteilungInMonaten;
  LocalDate vertragsbeginn;
  Abschlussgebuehrenbehandlung verrechnung;

  BigDecimal bausparsumme;
  BigDecimal einmalzahlung;
  BigDecimal sparBeitrag;
  BigDecimal tilgungsRate;

  public BerechnungsZiel getBerechnungsZiel() {
    return berechnungsZiel;
  }

  public void setBerechnungsZiel(BerechnungsZiel berechnungsZiel) {
    this.berechnungsZiel = berechnungsZiel;
  }

  public Berechnungsart getBerechnungsart() {
    return berechnungsart;
  }

  public void setBerechnungsart(Berechnungsart berechnungsart) {
    this.berechnungsart = berechnungsart;
  }

  public Integer getLaufzeitBisZuteilungInMonaten() {
    return laufzeitBisZuteilungInMonaten;
  }

  public void setLaufzeitBisZuteilungInMonaten(Integer laufzeitBisZuteilungInMonaten) {
    this.laufzeitBisZuteilungInMonaten = laufzeitBisZuteilungInMonaten;
  }

  public LocalDate getVertragsbeginn() {
    return vertragsbeginn;
  }

  public void setVertragsbeginn(LocalDate vertragsbeginn) {
    this.vertragsbeginn = vertragsbeginn;
  }

  public Abschlussgebuehrenbehandlung getVerrechnung() {
    return verrechnung;
  }

  public void setVerrechnung(Abschlussgebuehrenbehandlung verrechnung) {
    this.verrechnung = verrechnung;
  }

  public BigDecimal getBausparsumme() {
    return bausparsumme;
  }

  public void setBausparsumme(BigDecimal bausparsumme) {
    this.bausparsumme = bausparsumme;
  }

  public BigDecimal getEinmalzahlung() {
    return einmalzahlung;
  }

  public void setEinmalzahlung(BigDecimal einmalzahlung) {
    this.einmalzahlung = einmalzahlung;
  }

  public BigDecimal getSparBeitrag() {
    return sparBeitrag;
  }

  public void setSparBeitrag(BigDecimal sparBeitrag) {
    this.sparBeitrag = sparBeitrag;
  }

  public BigDecimal getTilgungsRate() {
    return tilgungsRate;
  }

  public void setTilgungsRate(BigDecimal tilgungsRate) {
    this.tilgungsRate = tilgungsRate;
  }
}
