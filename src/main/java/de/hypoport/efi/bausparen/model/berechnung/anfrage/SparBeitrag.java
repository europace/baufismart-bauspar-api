package de.hypoport.efi.bausparen.model.berechnung.anfrage;

import de.hypoport.efi.bausparen.model.berechnung.Zahlungsrhythmus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SparBeitrag {

  BigDecimal beitrag;
  LocalDate zahlungAb;
  LocalDate zahlungBis;
  Zahlungsrhythmus zahlungsrhythmus;

  public BigDecimal getBeitrag() {
    return beitrag;
  }

  public void setBeitrag(BigDecimal beitrag) {
    this.beitrag = beitrag;
  }

  public LocalDate getZahlungAb() {
    return zahlungAb;
  }

  public void setZahlungAb(LocalDate zahlungAb) {
    this.zahlungAb = zahlungAb;
  }

  public LocalDate getZahlungBis() {
    return zahlungBis;
  }

  public void setZahlungBis(LocalDate zahlungBis) {
    this.zahlungBis = zahlungBis;
  }

  public Zahlungsrhythmus getZahlungsrhythmus() {
    return zahlungsrhythmus;
  }

  public void setZahlungsrhythmus(Zahlungsrhythmus zahlungsrhythmus) {
    this.zahlungsrhythmus = zahlungsrhythmus;
  }
}
