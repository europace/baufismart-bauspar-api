package de.hypoport.efi.bausparen.model.dokumente;

public class VermittlerDaten {

  String vorname;
  String nachName;
  String strasseHausnummer;
  String postleitzahl;
  String ort;
  String firma;
  String telefonNummer;
  String eMailAdresse;
  String vermittlerNr;

  public String getVorname() {
    return vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public String getNachName() {
    return nachName;
  }

  public void setNachName(String nachName) {
    this.nachName = nachName;
  }

  public String getStrasseHausnummer() {
    return strasseHausnummer;
  }

  public void setStrasseHausnummer(String strasseHausnummer) {
    this.strasseHausnummer = strasseHausnummer;
  }

  public String getPostleitzahl() {
    return postleitzahl;
  }

  public void setPostleitzahl(String postleitzahl) {
    this.postleitzahl = postleitzahl;
  }

  public String getOrt() {
    return ort;
  }

  public void setOrt(String ort) {
    this.ort = ort;
  }

  public String getFirma() {
    return firma;
  }

  public void setFirma(String firma) {
    this.firma = firma;
  }

  public String getTelefonNummer() {
    return telefonNummer;
  }

  public void setTelefonNummer(String telefonNummer) {
    this.telefonNummer = telefonNummer;
  }

  public String geteMailAdresse() {
    return eMailAdresse;
  }

  public void seteMailAdresse(String eMailAdresse) {
    this.eMailAdresse = eMailAdresse;
  }

  public String getVermittlerNr() {
    return vermittlerNr;
  }

  public void setVermittlerNr(String vermittlerNr) {
    this.vermittlerNr = vermittlerNr;
  }
}