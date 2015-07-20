package de.hypoport.efi.bausparen.model.berechnung;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SparPhase {

  Zahlungsrhythmus zahlungsrhythmus; //check
  @JsonSerialize(using = DateSerializer.class)
  @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
  LocalDate sparBeginnAb; // check
  @JsonSerialize(using = DateSerializer.class)
  @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
  LocalDate sparEnde; // check
  BigDecimal guthabenzinsInProzent;//check
  BigDecimal guthabenzinsBetragInEuro; //check
  BigDecimal bonuszinsInProzent; //check
  BigDecimal bonuszinsBetragInEuro;//check
  BigDecimal guthabenBeiZuteilungInEuro;//check
  BigDecimal regelsparbeitragInEuro;//check
  BigDecimal gesamtleistungSparphaseInEuro;//check

  SparPlan sparPlan;//check

  public Zahlungsrhythmus getZahlungsrhythmus() {
    return zahlungsrhythmus;
  }

  public void setZahlungsrhythmus(Zahlungsrhythmus zahlungsrhythmus) {
    this.zahlungsrhythmus = zahlungsrhythmus;
  }

  public LocalDate getSparBeginnAb() {
    return sparBeginnAb;
  }

  public void setSparBeginnAb(LocalDate sparBeginnAb) {
    this.sparBeginnAb = sparBeginnAb;
  }

  public LocalDate getSparEnde() {
    return sparEnde;
  }

  public void setSparEnde(LocalDate sparEnde) {
    this.sparEnde = sparEnde;
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

  public BigDecimal getBonuszinsBetragInEuro() {
    return bonuszinsBetragInEuro;
  }

  public void setBonuszinsBetragInEuro(BigDecimal bonuszinsBetragInEuro) {
    this.bonuszinsBetragInEuro = bonuszinsBetragInEuro;
  }

  public BigDecimal getGuthabenBeiZuteilungInEuro() {
    return guthabenBeiZuteilungInEuro;
  }

  public void setGuthabenBeiZuteilungInEuro(BigDecimal guthabenBeiZuteilungInEuro) {
    this.guthabenBeiZuteilungInEuro = guthabenBeiZuteilungInEuro;
  }

  public BigDecimal getRegelsparbeitragInEuro() {
    return regelsparbeitragInEuro;
  }

  public void setRegelsparbeitragInEuro(BigDecimal regelsparbeitragInEuro) {
    this.regelsparbeitragInEuro = regelsparbeitragInEuro;
  }

  public BigDecimal getGesamtleistungSparphaseInEuro() {
    return gesamtleistungSparphaseInEuro;
  }

  public void setGesamtleistungSparphaseInEuro(BigDecimal gesamtleistungSparphaseInEuro) {
    this.gesamtleistungSparphaseInEuro = gesamtleistungSparphaseInEuro;
  }

  public SparPlan getSparPlan() {
    return sparPlan;
  }

  public void setSparPlan(SparPlan sparPlan) {
    this.sparPlan = sparPlan;
  }
}
