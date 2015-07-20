package de.hypoport.efi.bausparen.model.berechnung;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SparPlanZahlung {

  @JsonSerialize(using = DateSerializer.class)
  @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
  LocalDate datum;
  BigDecimal saldoNachZahlungInEuro;
  BigDecimal zahlungInEuro;
  BigDecimal zinsInEuro;
  BigDecimal abgeltungsSteuerInEuro;
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

  public BigDecimal getAbgeltungsSteuerInEuro() {
    return abgeltungsSteuerInEuro;
  }

  public void setAbgeltungsSteuerInEuro(BigDecimal abgeltungsSteuerInEuro) {
    this.abgeltungsSteuerInEuro = abgeltungsSteuerInEuro;
  }
}
