package de.hypoport.efi.bausparen.model.dokumente;

import de.hypoport.efi.bausparen.model.berechnung.Zahlungsrhythmus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Antragsteller {

  Anrede anrede;
  String titel;
  String nachName;
  String vorname;
  LocalDate geburtsDatum;
  String geburtsName;
  String geburtsOrt;
  String staatsangehoerigkeit;
  Adresse adresse;
  Kontakt kontakt;
  FamilienStand familienStand;
  ZahlungsDaten zahlungsDaten;
  BeschaeftigungsVerhaeltnis beschaeftigungsVerhaeltnis;
  Legitimation legitimation;
  Boolean einkommenssteuerpflichtigInUsa;
  TodesfallBeguenstigter todesfallBeguenstigter;
  BigDecimal vermoegenswirksameLeistungenBetragInEuro;
  Zahlungsrhythmus vermoegenswirksameLeistungenZahlungsrhythmus;

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

  public BeschaeftigungsVerhaeltnis getBeschaeftigungsVerhaeltnis() {
    return beschaeftigungsVerhaeltnis;
  }

  public void setBeschaeftigungsVerhaeltnis(BeschaeftigungsVerhaeltnis beschaeftigungsVerhaeltnis) {
    this.beschaeftigungsVerhaeltnis = beschaeftigungsVerhaeltnis;
  }

  public String getGeburtsOrt() {
    return geburtsOrt;
  }

  public void setGeburtsOrt(String geburtsOrt) {
    this.geburtsOrt = geburtsOrt;
  }

  public Legitimation getLegitimation() {
    return legitimation;
  }

  public void setLegitimation(Legitimation legitimation) {
    this.legitimation = legitimation;
  }

  public Boolean getEinkommenssteuerpflichtigInUsa() {
    return einkommenssteuerpflichtigInUsa;
  }

  public void setEinkommenssteuerpflichtigInUsa(Boolean einkommenssteuerpflichtigInUsa) {
    this.einkommenssteuerpflichtigInUsa = einkommenssteuerpflichtigInUsa;
  }

  public TodesfallBeguenstigter getTodesfallBeguenstigter() {
    return todesfallBeguenstigter;
  }

  public void setTodesfallBeguenstigter(TodesfallBeguenstigter todesfallBeguenstigter) {
    this.todesfallBeguenstigter = todesfallBeguenstigter;
  }

  public BigDecimal getVermoegenswirksameLeistungenBetragInEuro() {
    return vermoegenswirksameLeistungenBetragInEuro;
  }

  public void setVermoegenswirksameLeistungenBetragInEuro(BigDecimal vermoegenswirksameLeistungenBetragInEuro) {
    this.vermoegenswirksameLeistungenBetragInEuro = vermoegenswirksameLeistungenBetragInEuro;
  }

  public Zahlungsrhythmus getVermoegenswirksameLeistungenZahlungsrhythmus() {
    return vermoegenswirksameLeistungenZahlungsrhythmus;
  }

  public void setVermoegenswirksameLeistungenZahlungsrhythmus(Zahlungsrhythmus vermoegenswirksameLeistungenZahlungsrhythmus) {
    this.vermoegenswirksameLeistungenZahlungsrhythmus = vermoegenswirksameLeistungenZahlungsrhythmus;
  }
}