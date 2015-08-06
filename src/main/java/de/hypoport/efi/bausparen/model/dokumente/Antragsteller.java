package de.hypoport.efi.bausparen.model.dokumente;

import java.time.LocalDate;

public class Antragsteller {

  Anrede anrede; //check
  String titel; //check
  String nachName; //check
  String vorname; //check
  LocalDate geburtsDatum; //check
  String geburtsName; //check
  String staatsangehoerigkeit; //check

  Adresse adresse;//check

  Kontakt kontakt;//check

  FamilienStand familienStand;//check

  ZahlungsDaten zahlungsDaten;//check

  public String getNachName() {
    return nachName;
  }

  public void setNachName(String nachName) {
    this.nachName = nachName;
  }

  public String getVorname() {
    return vorname;
  }

  public void setVorname(String vorname) {
    this.vorname = vorname;
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

  public ZahlungsDaten getZahlungsDaten() {
    return zahlungsDaten;
  }

  public void setZahlungsDaten(ZahlungsDaten zahlungsDaten) {
    this.zahlungsDaten = zahlungsDaten;
  }
}
