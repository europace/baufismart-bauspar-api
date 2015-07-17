package de.hypoport.efi.bausparen.model.berechnung;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Zahlung {
  BigDecimal betragInEuro;
  Zahlungsrhythmus zahlungsrhythmus;
  LocalDate zahlungAb;
  LocalDate zahlungBis;


  public BigDecimal getBetragInEuro() {
    return betragInEuro;
  }

  public void setBetragInEuro(BigDecimal betragInEuro) {
    this.betragInEuro = betragInEuro;
  }

  public Zahlungsrhythmus getZahlungsrhythmus() {
    return zahlungsrhythmus;
  }

  public void setZahlungsrhythmus(Zahlungsrhythmus zahlungsrhythmus) {
    this.zahlungsrhythmus = zahlungsrhythmus;
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
}
