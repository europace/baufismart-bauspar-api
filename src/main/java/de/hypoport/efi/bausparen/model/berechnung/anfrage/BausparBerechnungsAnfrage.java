package de.hypoport.efi.bausparen.model.berechnung.anfrage;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import de.hypoport.efi.bausparen.model.berechnung.Abschlussgebuehrenbehandlung;
import de.hypoport.efi.bausparen.model.berechnung.BerechnungsZiel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BausparBerechnungsAnfrage {

  String zielTarif; //check
  BerechnungsZiel berechnungsZiel; //check
  BerechnungsArt berechnungsArt; //check
  Integer laufzeitBisZuteilungInMonaten; //check
  @JsonSerialize(using = DateSerializer.class)
  @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
  LocalDate vertragsbeginn; //check
  Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung; //check

  DarlehensWunsch darlehensWunsch; //check

  BigDecimal bausparsummeInEuro; //check
  BigDecimal einmalzahlungInEuro;//check
  BigDecimal sparBeitragInEuro; //check
  BigDecimal tilgungsRateInEuro; //check
  @JsonSerialize(using = DateSerializer.class)
  @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
  LocalDate sparBeitragsZahlungBis; //check

  public BerechnungsZiel getBerechnungsZiel() {
    return berechnungsZiel;
  }

  public void setBerechnungsZiel(BerechnungsZiel berechnungsZiel) {
    this.berechnungsZiel = berechnungsZiel;
  }

  public BerechnungsArt getBerechnungsArt() {
    return berechnungsArt;
  }

  public void setBerechnungsArt(BerechnungsArt berechnungsArt) {
    this.berechnungsArt = berechnungsArt;
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

  public Abschlussgebuehrenbehandlung getAbschlussgebuehrenbehandlung() {
    return abschlussgebuehrenbehandlung;
  }

  public void setAbschlussgebuehrenbehandlung(Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung) {
    this.abschlussgebuehrenbehandlung = abschlussgebuehrenbehandlung;
  }

  public BigDecimal getBausparsummeInEuro() {
    return bausparsummeInEuro;
  }

  public void setBausparsummeInEuro(BigDecimal bausparsummeInEuro) {
    this.bausparsummeInEuro = bausparsummeInEuro;
  }

  public BigDecimal getEinmalzahlungInEuro() {
    return einmalzahlungInEuro;
  }

  public void setEinmalzahlungInEuro(BigDecimal einmalzahlungInEuro) {
    this.einmalzahlungInEuro = einmalzahlungInEuro;
  }

  public BigDecimal getSparBeitragInEuro() {
    return sparBeitragInEuro;
  }

  public void setSparBeitragInEuro(BigDecimal sparBeitragInEuro) {
    this.sparBeitragInEuro = sparBeitragInEuro;
  }

  public BigDecimal getTilgungsRateInEuro() {
    return tilgungsRateInEuro;
  }

  public void setTilgungsRateInEuro(BigDecimal tilgungsRateInEuro) {
    this.tilgungsRateInEuro = tilgungsRateInEuro;
  }

  public String getZielTarif() {
    return zielTarif;
  }

  public void setZielTarif(String zielTarif) {
    this.zielTarif = zielTarif;
  }

  public DarlehensWunsch getDarlehensWunsch() {
    return darlehensWunsch;
  }

  public void setDarlehensWunsch(DarlehensWunsch darlehensWunsch) {
    this.darlehensWunsch = darlehensWunsch;
  }

  public LocalDate getSparBeitragsZahlungBis() {
    return sparBeitragsZahlungBis;
  }

  public void setSparBeitragsZahlungBis(LocalDate sparBeitragsZahlungBis) {
    this.sparBeitragsZahlungBis = sparBeitragsZahlungBis;
  }
}
