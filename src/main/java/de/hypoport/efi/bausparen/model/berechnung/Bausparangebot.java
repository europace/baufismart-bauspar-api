package de.hypoport.efi.bausparen.model.berechnung;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Bausparangebot {
  String tarif;
  BerechnungsZiel berechnungsziel;
  Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung;
  BigDecimal abschlussgebuehrHoeheInProzent;
  BigDecimal abschlussgebuehrBetragInEuro;
  BigDecimal kontogebuehrJaehrlichInEuro;
  BigDecimal kontogebuehrGesamtSparphaseInEuro;
  BigDecimal kontogebuehrGesamtDarlehensphaseInEuro;
  BigDecimal kontogebuehrGesamtInEuro;
  BigDecimal guthabenzinsInProzent;
  BigDecimal guthabenzinsBetragInEuro;
  BigDecimal bonuszinsInProzent;
  BigDecimal bonuszinsBetragInProzent;
  BigDecimal guthabenBeiZuteilungInEuro;
  BigDecimal hoeheBauspardarlehenInEuro;
  BigDecimal bausparsummeInEuro;
  BigDecimal regelsparbeitragInEuro;
  BigDecimal sollzinsInProzent;
  BigDecimal effektiverJahreszinsInProzent;
  Integer darlehenslaufzeitInMonaten;
  LocalDate tilgungsende;
  BigDecimal hoeheLetzterTilgungsbeitragInEuro;
  BigDecimal gesamtkostenDarlehenInEuro;
  BigDecimal gesamtleistungDarlehenInEuro;
  BigDecimal gesamtleistungSparphaseInEuro;
  BigDecimal gesamtleistungKomplettInEuro;

  Integer gesamtlaufzeitKomplettInMonaten;

  BigDecimal zahlungsbetragEinmalzahlungInEuro;
  Zahlung tilgungsrate;
  Zahlung sparbeitrag;

  public String getTarif() {
    return tarif;
  }

  public void setTarif(String tarif) {
    this.tarif = tarif;
  }

  public BerechnungsZiel getBerechnungsziel() {
    return berechnungsziel;
  }

  public void setBerechnungsziel(BerechnungsZiel berechnungsziel) {
    this.berechnungsziel = berechnungsziel;
  }

  public Abschlussgebuehrenbehandlung getAbschlussgebuehrenbehandlung() {
    return abschlussgebuehrenbehandlung;
  }

  public void setAbschlussgebuehrenbehandlung(Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung) {
    this.abschlussgebuehrenbehandlung = abschlussgebuehrenbehandlung;
  }

  public BigDecimal getAbschlussgebuehrHoeheInProzent() {
    return abschlussgebuehrHoeheInProzent;
  }

  public void setAbschlussgebuehrHoeheInProzent(BigDecimal abschlussgebuehrHoeheInProzent) {
    this.abschlussgebuehrHoeheInProzent = abschlussgebuehrHoeheInProzent;
  }

  public BigDecimal getAbschlussgebuehrBetragInEuro() {
    return abschlussgebuehrBetragInEuro;
  }

  public void setAbschlussgebuehrBetragInEuro(BigDecimal abschlussgebuehrBetragInEuro) {
    this.abschlussgebuehrBetragInEuro = abschlussgebuehrBetragInEuro;
  }

  public BigDecimal getKontogebuehrJaehrlichInEuro() {
    return kontogebuehrJaehrlichInEuro;
  }

  public void setKontogebuehrJaehrlichInEuro(BigDecimal kontogebuehrJaehrlichInEuro) {
    this.kontogebuehrJaehrlichInEuro = kontogebuehrJaehrlichInEuro;
  }

  public BigDecimal getKontogebuehrGesamtSparphaseInEuro() {
    return kontogebuehrGesamtSparphaseInEuro;
  }

  public void setKontogebuehrGesamtSparphaseInEuro(BigDecimal kontogebuehrGesamtSparphaseInEuro) {
    this.kontogebuehrGesamtSparphaseInEuro = kontogebuehrGesamtSparphaseInEuro;
  }

  public BigDecimal getKontogebuehrGesamtDarlehensphaseInEuro() {
    return kontogebuehrGesamtDarlehensphaseInEuro;
  }

  public void setKontogebuehrGesamtDarlehensphaseInEuro(BigDecimal kontogebuehrGesamtDarlehensphaseInEuro) {
    this.kontogebuehrGesamtDarlehensphaseInEuro = kontogebuehrGesamtDarlehensphaseInEuro;
  }

  public BigDecimal getKontogebuehrGesamtInEuro() {
    return kontogebuehrGesamtInEuro;
  }

  public void setKontogebuehrGesamtInEuro(BigDecimal kontogebuehrGesamtInEuro) {
    this.kontogebuehrGesamtInEuro = kontogebuehrGesamtInEuro;
  }

  public BigDecimal getGuthabenzinsInProzent() {
    return guthabenzinsInProzent;
  }

  public void setGuthabenzinsInProzent(BigDecimal guthabenzinsInProzent) {
    this.guthabenzinsInProzent = guthabenzinsInProzent;
  }

  public BigDecimal getGuthabenzinsBetragInEuro() {
    return guthabenzinsBetragInEuro;
  }

  public void setGuthabenzinsBetragInEuro(BigDecimal guthabenzinsBetragInEuro) {
    this.guthabenzinsBetragInEuro = guthabenzinsBetragInEuro;
  }

  public BigDecimal getBonuszinsInProzent() {
    return bonuszinsInProzent;
  }

  public void setBonuszinsInProzent(BigDecimal bonuszinsInProzent) {
    this.bonuszinsInProzent = bonuszinsInProzent;
  }

  public BigDecimal getBonuszinsBetragInProzent() {
    return bonuszinsBetragInProzent;
  }

  public void setBonuszinsBetragInProzent(BigDecimal bonuszinsBetragInProzent) {
    this.bonuszinsBetragInProzent = bonuszinsBetragInProzent;
  }

  public BigDecimal getGuthabenBeiZuteilungInEuro() {
    return guthabenBeiZuteilungInEuro;
  }

  public void setGuthabenBeiZuteilungInEuro(BigDecimal guthabenBeiZuteilungInEuro) {
    this.guthabenBeiZuteilungInEuro = guthabenBeiZuteilungInEuro;
  }

  public BigDecimal getHoeheBauspardarlehenInEuro() {
    return hoeheBauspardarlehenInEuro;
  }

  public void setHoeheBauspardarlehenInEuro(BigDecimal hoeheBauspardarlehenInEuro) {
    this.hoeheBauspardarlehenInEuro = hoeheBauspardarlehenInEuro;
  }

  public BigDecimal getBausparsummeInEuro() {
    return bausparsummeInEuro;
  }

  public void setBausparsummeInEuro(BigDecimal bausparsummeInEuro) {
    this.bausparsummeInEuro = bausparsummeInEuro;
  }

  public BigDecimal getRegelsparbeitragInEuro() {
    return regelsparbeitragInEuro;
  }

  public void setRegelsparbeitragInEuro(BigDecimal regelsparbeitragInEuro) {
    this.regelsparbeitragInEuro = regelsparbeitragInEuro;
  }

  public BigDecimal getSollzinsInProzent() {
    return sollzinsInProzent;
  }

  public void setSollzinsInProzent(BigDecimal sollzinsInProzent) {
    this.sollzinsInProzent = sollzinsInProzent;
  }

  public BigDecimal getEffektiverJahreszinsInProzent() {
    return effektiverJahreszinsInProzent;
  }

  public void setEffektiverJahreszinsInProzent(BigDecimal effektiverJahreszinsInProzent) {
    this.effektiverJahreszinsInProzent = effektiverJahreszinsInProzent;
  }

  public Integer getDarlehenslaufzeitInMonaten() {
    return darlehenslaufzeitInMonaten;
  }

  public void setDarlehenslaufzeitInMonaten(Integer darlehenslaufzeitInMonaten) {
    this.darlehenslaufzeitInMonaten = darlehenslaufzeitInMonaten;
  }

  public LocalDate getTilgungsende() {
    return tilgungsende;
  }

  public void setTilgungsende(LocalDate tilgungsende) {
    this.tilgungsende = tilgungsende;
  }

  public BigDecimal getHoeheLetzterTilgungsbeitragInEuro() {
    return hoeheLetzterTilgungsbeitragInEuro;
  }

  public void setHoeheLetzterTilgungsbeitragInEuro(BigDecimal hoeheLetzterTilgungsbeitragInEuro) {
    this.hoeheLetzterTilgungsbeitragInEuro = hoeheLetzterTilgungsbeitragInEuro;
  }

  public BigDecimal getGesamtleistungDarlehenInEuro() {
    return gesamtleistungDarlehenInEuro;
  }

  public void setGesamtleistungDarlehenInEuro(BigDecimal gesamtleistungDarlehenInEuro) {
    this.gesamtleistungDarlehenInEuro = gesamtleistungDarlehenInEuro;
  }

  public BigDecimal getGesamtkostenDarlehenInEuro() {
    return gesamtkostenDarlehenInEuro;
  }

  public void setGesamtkostenDarlehenInEuro(BigDecimal gesamtkostenDarlehenInEuro) {
    this.gesamtkostenDarlehenInEuro = gesamtkostenDarlehenInEuro;
  }

  public BigDecimal getGesamtleistungSparphaseInEuro() {
    return gesamtleistungSparphaseInEuro;
  }

  public void setGesamtleistungSparphaseInEuro(BigDecimal gesamtleistungSparphaseInEuro) {
    this.gesamtleistungSparphaseInEuro = gesamtleistungSparphaseInEuro;
  }

  public BigDecimal getGesamtleistungKomplettInEuro() {
    return gesamtleistungKomplettInEuro;
  }

  public void setGesamtleistungKomplettInEuro(BigDecimal gesamtleistungKomplettInEuro) {
    this.gesamtleistungKomplettInEuro = gesamtleistungKomplettInEuro;
  }

  public Integer getGesamtlaufzeitKomplettInMonaten() {
    return gesamtlaufzeitKomplettInMonaten;
  }

  public void setGesamtlaufzeitKomplettInMonaten(Integer gesamtlaufzeitKomplettInMonaten) {
    this.gesamtlaufzeitKomplettInMonaten = gesamtlaufzeitKomplettInMonaten;
  }

  public BigDecimal getZahlungsbetragEinmalzahlungInEuro() {
    return zahlungsbetragEinmalzahlungInEuro;
  }

  public void setZahlungsbetragEinmalzahlungInEuro(BigDecimal zahlungsbetragEinmalzahlungInEuro) {
    this.zahlungsbetragEinmalzahlungInEuro = zahlungsbetragEinmalzahlungInEuro;
  }

  public Zahlung getTilgungsrate() {
    return tilgungsrate;
  }

  public void setTilgungsrate(Zahlung tilgungsrate) {
    this.tilgungsrate = tilgungsrate;
  }

  public Zahlung getSparbeitrag() {
    return sparbeitrag;
  }

  public void setSparbeitrag(Zahlung sparbeitrag) {
    this.sparbeitrag = sparbeitrag;
  }

}
