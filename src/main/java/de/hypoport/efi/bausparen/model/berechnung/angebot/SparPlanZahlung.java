package de.hypoport.efi.bausparen.model.berechnung.angebot;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SparPlanZahlung {

  LocalDate datum;
  BigDecimal saldoNachZahlungInEuro;
  BigDecimal zahlungInEuro;
  BigDecimal zinsInEuro;
  BigDecimal gebuehrenInEuro;
  BigDecimal KontofuehrungsGebuehrInEuro;

  public BigDecimal getZahlungInEuro() {
    return zahlungInEuro;
  }

  public void setZahlungInEuro(BigDecimal zahlungInEuro) {
    this.zahlungInEuro = zahlungInEuro;
  }

  public LocalDate getDatum() {
    return datum;
  }

  public void setDatum(LocalDate datum) {
    this.datum = datum;
  }

  public BigDecimal getSaldoNachZahlungInEuro() {
    return saldoNachZahlungInEuro;
  }

  public void setSaldoNachZahlungInEuro(BigDecimal saldoNachZahlungInEuro) {
    this.saldoNachZahlungInEuro = saldoNachZahlungInEuro;
  }

  public BigDecimal getZinsInEuro() {
    return zinsInEuro;
  }

  public void setZinsInEuro(BigDecimal zinsInEuro) {
    this.zinsInEuro = zinsInEuro;
  }

  public BigDecimal getGebuehrenInEuro() {
    return gebuehrenInEuro;
  }

  public void setGebuehrenInEuro(BigDecimal gebuehrenInEuro) {
    this.gebuehrenInEuro = gebuehrenInEuro;
  }

  public BigDecimal getKontofuehrungsGebuehrInEuro() {
    return KontofuehrungsGebuehrInEuro;
  }

  public void setKontofuehrungsGebuehrInEuro(BigDecimal kontofuehrungsGebuehrInEuro) {
    KontofuehrungsGebuehrInEuro = kontofuehrungsGebuehrInEuro;
  }
}