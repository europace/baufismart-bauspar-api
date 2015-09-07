package de.hypoport.efi.bausparen.model.dokumente;

import java.time.LocalDate;

public class Legitimation {

  AusweisArt ausweisArt;
  String ausweisNummer;
  String austellendeBehoerde;
  LocalDate ausstellungsDatum;

  public AusweisArt getAusweisArt() {
    return ausweisArt;
  }

  public void setAusweisArt(AusweisArt ausweisArt) {
    this.ausweisArt = ausweisArt;
  }

  public String getAusweisNummer() {
    return ausweisNummer;
  }

  public void setAusweisNummer(String ausweisNummer) {
    this.ausweisNummer = ausweisNummer;
  }

  public String getAustellendeBehoerde() {
    return austellendeBehoerde;
  }

  public void setAustellendeBehoerde(String austellendeBehoerde) {
    this.austellendeBehoerde = austellendeBehoerde;
  }

  public LocalDate getAusstellungsDatum() {
    return ausstellungsDatum;
  }

  public void setAusstellungsDatum(LocalDate ausstellungsDatum) {
    this.ausstellungsDatum = ausstellungsDatum;
  }
}