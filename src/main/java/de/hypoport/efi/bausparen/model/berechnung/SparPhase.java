package de.hypoport.efi.bausparen.model.berechnung;


import java.math.BigDecimal;
import java.util.List;

public class SparPhase {

  BigDecimal guthabenzinsInProzent;
  BigDecimal guthabenzinsBetragInEuro;
  BigDecimal bonuszinsInProzent;
  BigDecimal bonuszinsBetragInEuro;
  BigDecimal guthabenBeiZuteilungInEuro;
  BigDecimal regelsparbeitragInEuro;
  BigDecimal gesamtleistungSparphaseInEuro;
  List<SparBeitrag> sparBeitraege;
  SparPlan sparPlan;

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

  public List<SparBeitrag> getSparBeitraege() {
    return sparBeitraege;
  }

  public void setSparBeitraege(List<SparBeitrag> sparBeitraege) {
    this.sparBeitraege = sparBeitraege;
  }
}
