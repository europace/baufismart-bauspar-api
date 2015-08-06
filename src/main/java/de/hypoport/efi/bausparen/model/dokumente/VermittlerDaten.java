package de.hypoport.efi.bausparen.model.dokumente;

public class VermittlerDaten {

  String vorname;//check
  String nachName;//check

  String strasseHausnummer;//check

  String postleitzahl;//check
  String ort;//check

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
}
