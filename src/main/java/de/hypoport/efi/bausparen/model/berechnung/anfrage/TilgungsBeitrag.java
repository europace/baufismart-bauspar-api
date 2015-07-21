package de.hypoport.efi.bausparen.model.berechnung.anfrage;

import de.hypoport.efi.bausparen.model.berechnung.Zahlungsrhythmus;

import java.math.BigDecimal;

public class TilgungsBeitrag {

  BigDecimal rateInEuro;
  Zahlungsrhythmus zahlungsrhythmus;

  public BigDecimal getRateInEuro() {
    return rateInEuro;
  }

  public void setRateInEuro(BigDecimal rateInEuro) {
    this.rateInEuro = rateInEuro;
  }

  public Zahlungsrhythmus getZahlungsrhythmus() {
    return zahlungsrhythmus;
  }

  public void setZahlungsrhythmus(Zahlungsrhythmus zahlungsrhythmus) {
    this.zahlungsrhythmus = zahlungsrhythmus;
  }
}
