package de.hypoport.efi.bausparen.model.berechnung.angebot;

import de.hypoport.efi.bausparen.model.basis.Zahlungsrhythmus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BausparDarlehen {

  BigDecimal zahlungsBeitragTilgungsRateInEuro;
  Zahlungsrhythmus zahlungsrhythmus;
  BigDecimal hoeheBauspardarlehenInEuro;
  BigDecimal sollzinsInProzent;
  BigDecimal effektiverJahreszinsInProzent;
  Integer darlehenslaufzeitInMonaten;
  LocalDate tilgungsende;
  TilgungsPlan tilgungsPlan;
  BigDecimal gesamtleistungDarlehenInEuro;

  public BigDecimal getZahlungsBeitragTilgungsRateInEuro() {
    return zahlungsBeitragTilgungsRateInEuro;
  }

  public void setZahlungsBeitragTilgungsRateInEuro(BigDecimal zahlungsBeitragTilgungsRateInEuro) {
    this.zahlungsBeitragTilgungsRateInEuro = zahlungsBeitragTilgungsRateInEuro;
  }

  public Zahlungsrhythmus getZahlungsrhythmus() {
    return zahlungsrhythmus;
  }

  public void setZahlungsrhythmus(Zahlungsrhythmus zahlungsrhythmus) {
    this.zahlungsrhythmus = zahlungsrhythmus;
  }

  public BigDecimal getHoeheBauspardarlehenInEuro() {
    return hoeheBauspardarlehenInEuro;
  }

  public void setHoeheBauspardarlehenInEuro(BigDecimal hoeheBauspardarlehenInEuro) {
    this.hoeheBauspardarlehenInEuro = hoeheBauspardarlehenInEuro;
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

  public TilgungsPlan getTilgungsPlan() {
    return tilgungsPlan;
  }

  public void setTilgungsPlan(TilgungsPlan tilgungsPlan) {
    this.tilgungsPlan = tilgungsPlan;
  }

  public BigDecimal getGesamtleistungDarlehenInEuro() {
    return gesamtleistungDarlehenInEuro;
  }

  public void setGesamtleistungDarlehenInEuro(BigDecimal gesamtleistungDarlehenInEuro) {
    this.gesamtleistungDarlehenInEuro = gesamtleistungDarlehenInEuro;
  }
}