package de.hypoport.efi.bausparen.model.dokumente;

import de.hypoport.efi.bausparen.model.berechnung.Zahlungsrhythmus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SparphaseDokument {

  Zahlungsrhythmus zahlungsRhythmus;
  LocalDate sparBeginnAb;
  LocalDate sparEnde;
  BigDecimal regelsparbeitragInEuro;

  public Zahlungsrhythmus getZahlungsRhythmus() {
    return zahlungsRhythmus;
  }

  public void setZahlungsRhythmus(Zahlungsrhythmus zahlungsRhythmus) {
    this.zahlungsRhythmus = zahlungsRhythmus;
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

  public BigDecimal getRegelsparbeitragInEuro() {
    return regelsparbeitragInEuro;
  }

  public void setRegelsparbeitragInEuro(BigDecimal regelsparbeitragInEuro) {
    this.regelsparbeitragInEuro = regelsparbeitragInEuro;
  }
}
