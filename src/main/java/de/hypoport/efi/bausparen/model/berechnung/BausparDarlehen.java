package de.hypoport.efi.bausparen.model.berechnung;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BausparDarlehen {

  BigDecimal zahlungsBeitragTilgungsRateInEuro; //check
  Zahlungsrhythmus zahlungsrhythmus; //check
  BigDecimal hoeheBauspardarlehenInEuro; //check
  BigDecimal sollzinsInProzent;//check
  BigDecimal effektiverJahreszinsInProzent;//check
  Integer darlehenslaufzeitInMonaten;//check
  @JsonSerialize(using = DateSerializer.class)
  @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
  LocalDate tilgungsende;//check
  BigDecimal hoeheLetzterTilgungsbeitragInEuro;//check
  BigDecimal gesamtleistungDarlehenInEuro;//check
  BigDecimal gesamtkostenDarlehenInEuro;//check

  TilgungsPlan tilgungsPlan;//check

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

  public TilgungsPlan getTilgungsPlan() {
    return tilgungsPlan;
  }

  public void setTilgungsPlan(TilgungsPlan tilgungsPlan) {
    this.tilgungsPlan = tilgungsPlan;
  }
}
