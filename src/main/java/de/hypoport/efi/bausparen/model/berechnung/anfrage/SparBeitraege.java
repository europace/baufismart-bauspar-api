package de.hypoport.efi.bausparen.model.berechnung.anfrage;

import de.hypoport.efi.bausparen.model.berechnung.Zahlungsrhythmus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SparBeitraege {

  BigDecimal beitrag; //check
  LocalDate zahlungAb; //check
  LocalDate zahlungBis; //check
  Zahlungsrhythmus zahlungsrhythmus; //check

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
