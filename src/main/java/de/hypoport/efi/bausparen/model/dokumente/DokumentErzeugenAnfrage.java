package de.hypoport.efi.bausparen.model.dokumente;

import de.hypoport.efi.bausparen.model.berechnung.Abschlussgebuehrenbehandlung;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.SparBeitrag;

import java.math.BigDecimal;
import java.util.List;

public class DokumentErzeugenAnfrage {

  String tarif; //check

  BigDecimal bausparSummeInEuro; //check
  BigDecimal auszahlungsbetragBeiZuteilung; //check

  List<SparBeitrag> sparBeitraege;//check

  Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung;//check

  List<Antragsteller> antragsteller;//check


  VermittlerDaten vermittlerDaten;//check

  public String getTarif() {
    return tarif;
  }

  public void setTarif(String tarif) {
    this.tarif = tarif;
  }

  public BigDecimal getBausparSummeInEuro() {
    return bausparSummeInEuro;
  }

  public void setBausparSummeInEuro(BigDecimal bausparSummeInEuro) {
    this.bausparSummeInEuro = bausparSummeInEuro;
  }

  public BigDecimal getAuszahlungsbetragBeiZuteilung() {
    return auszahlungsbetragBeiZuteilung;
  }

  public void setAuszahlungsbetragBeiZuteilung(BigDecimal auszahlungsbetragBeiZuteilung) {
    this.auszahlungsbetragBeiZuteilung = auszahlungsbetragBeiZuteilung;
  }

  public List<SparBeitrag> getSparBeitraege() {
    return sparBeitraege;
  }

  public void setSparBeitraege(List<SparBeitrag> sparBeitraege) {
    this.sparBeitraege = sparBeitraege;
  }

  public Abschlussgebuehrenbehandlung getAbschlussgebuehrenbehandlung() {
    return abschlussgebuehrenbehandlung;
  }

  public void setAbschlussgebuehrenbehandlung(Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung) {
    this.abschlussgebuehrenbehandlung = abschlussgebuehrenbehandlung;
  }

  public List<Antragsteller> getAntragsteller() {
    return antragsteller;
  }

  public void setAntragsteller(List<Antragsteller> antragsteller) {
    this.antragsteller = antragsteller;
  }

  public VermittlerDaten getVermittlerDaten() {
    return vermittlerDaten;
  }

  public void setVermittlerDaten(VermittlerDaten vermittlerDaten) {
    this.vermittlerDaten = vermittlerDaten;
  }
}
