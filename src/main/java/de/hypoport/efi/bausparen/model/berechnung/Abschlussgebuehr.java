package de.hypoport.efi.bausparen.model.berechnung;

import java.math.BigDecimal;

public class Abschlussgebuehr {
  Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung; //check
  BigDecimal abschlussgebuehrHoeheInProzent;//check
  BigDecimal abschlussgebuehrBetragInEuro;//check

  public Abschlussgebuehrenbehandlung getAbschlussgebuehrenbehandlung() {
    return abschlussgebuehrenbehandlung;
  }

  public void setAbschlussgebuehrenbehandlung(Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung) {
    this.abschlussgebuehrenbehandlung = abschlussgebuehrenbehandlung;
  }

  public BigDecimal getAbschlussgebuehrHoeheInProzent() {
    return abschlussgebuehrHoeheInProzent;
  }

  public void setAbschlussgebuehrHoeheInProzent(BigDecimal abschlussgebuehrHoeheInProzent) {
    this.abschlussgebuehrHoeheInProzent = abschlussgebuehrHoeheInProzent;
  }

  public BigDecimal getAbschlussgebuehrBetragInEuro() {
    return abschlussgebuehrBetragInEuro;
  }

  public void setAbschlussgebuehrBetragInEuro(BigDecimal abschlussgebuehrBetragInEuro) {
    this.abschlussgebuehrBetragInEuro = abschlussgebuehrBetragInEuro;
  }
}
