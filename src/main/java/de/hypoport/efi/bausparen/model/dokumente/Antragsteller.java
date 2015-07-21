package de.hypoport.efi.bausparen.model.dokumente;

import java.time.LocalDate;

public class Antragsteller {

  Anrede anrede; //check
  String titel; //check
  String nachName; //check
  String vorName; //check
  LocalDate geburtsDatum; //check
  String geburtsName; //check
  String staatsangehoerigkeit; //check

  Adresse adresse;//check

  Kontakt kontakt;//check

  FamilienStand familienStand;//check

  KontoDaten kontoDaten;//check

  public String getNachName() {
    return nachName;
  }

  public void setNachName(String nachName) {
    this.nachName = nachName;
  }

  public String getVorName() {
    return vorName;
  }

  public void setVorName(String vorName) {
    this.vorName = vorName;
  }

  public Anrede getAnrede() {
    return anrede;
  }

  public void setAnrede(Anrede anrede) {
    this.anrede = anrede;
  }

  public String getTitel() {
    return titel;
  }

  public void setTitel(String titel) {
    this.titel = titel;
  }

  public LocalDate getGeburtsDatum() {
    return geburtsDatum;
  }

  public void setGeburtsDatum(LocalDate geburtsDatum) {
    this.geburtsDatum = geburtsDatum;
  }

  public String getGeburtsName() {
    return geburtsName;
  }

  public void setGeburtsName(String geburtsName) {
    this.geburtsName = geburtsName;
  }

  public String getStaatsangehoerigkeit() {
    return staatsangehoerigkeit;
  }

  public void setStaatsangehoerigkeit(String staatsangehoerigkeit) {
    this.staatsangehoerigkeit = staatsangehoerigkeit;
  }

  public Adresse getAdresse() {
    return adresse;
  }

  public void setAdresse(Adresse adresse) {
    this.adresse = adresse;
  }

  public Kontakt getKontakt() {
    return kontakt;
  }

  public void setKontakt(Kontakt kontakt) {
    this.kontakt = kontakt;
  }

  public FamilienStand getFamilienStand() {
    return familienStand;
  }

  public void setFamilienStand(FamilienStand familienStand) {
    this.familienStand = familienStand;
  }

  public KontoDaten getKontoDaten() {
    return kontoDaten;
  }

  public void setKontoDaten(KontoDaten kontoDaten) {
    this.kontoDaten = kontoDaten;
  }
}
