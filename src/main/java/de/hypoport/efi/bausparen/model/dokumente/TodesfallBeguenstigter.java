package de.hypoport.efi.bausparen.model.dokumente;

import java.time.LocalDate;

public class TodesfallBeguenstigter {
  Anrede anrede;
  String vorname;
  String nachname;
  LocalDate geburtsdatum;
  Adresse adresse;

  public Anrede getAnrede() {
    return anrede;
  }

  public void setAnrede(Anrede anrede) {
    this.anrede = anrede;
  }

  public String getVorname() {
    return vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
  }

  public String getNachname() {
    return nachname;
  }

  public void setNachname(String nachname) {
    this.nachname = nachname;
  }

  public LocalDate getGeburtsdatum() {
    return geburtsdatum;
  }

  public void setGeburtsdatum(LocalDate geburtsdatum) {
    this.geburtsdatum = geburtsdatum;
  }

  public Adresse getAdresse() {
    return adresse;
  }

  public void setAdresse(Adresse adresse) {
    this.adresse = adresse;
  }
}
