package de.hypoport.efi.bausparen.model.dokumente;

public class Adresse {

  String strasse;//check
  String hausNummer;//check
  String postleitzahl;//check
  String wohnOrt;//check
  String landWohnsitz;//check

  public String getStrasse() {
    return strasse;
  }

  public void setStrasse(String strasse) {
    this.strasse = strasse;
  }

  public String getHausNummer() {
    return hausNummer;
  }

  public void setHausNummer(String hausNummer) {
    this.hausNummer = hausNummer;
  }

  public String getPostleitzahl() {
    return postleitzahl;
  }

  public void setPostleitzahl(String postleitzahl) {
    this.postleitzahl = postleitzahl;
  }

  public String getWohnOrt() {
    return wohnOrt;
  }

  public void setWohnOrt(String wohnOrt) {
    this.wohnOrt = wohnOrt;
  }

  public String getLandWohnsitz() {
    return landWohnsitz;
  }

  public void setLandWohnsitz(String landWohnsitz) {
    this.landWohnsitz = landWohnsitz;
  }
}
