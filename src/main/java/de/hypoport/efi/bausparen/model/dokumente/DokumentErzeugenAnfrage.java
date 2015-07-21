package de.hypoport.efi.bausparen.model.dokumente;

import de.hypoport.efi.bausparen.model.berechnung.Abschlussgebuehrenbehandlung;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.SparBeitrag;

import java.math.BigDecimal;
import java.util.List;

public class DokumentErzeugenAnfrage {

  String tarif; //check

  BigDecimal bausparSummeInEuro; //check
  BigDecimal abzuloesendesDarlehenInEuro;

  List<SparBeitrag> sparBeitraege;

  Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung;

  List<Antragsteller> antragsteller;//check

  String nameKreditInstitut;//check
  ZahlungsForm zahlungsForm;//check

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

  public BigDecimal getAbzuloesendesDarlehenInEuro() {
    return abzuloesendesDarlehenInEuro;
  }

  public void setAbzuloesendesDarlehenInEuro(BigDecimal abzuloesendesDarlehenInEuro) {
    this.abzuloesendesDarlehenInEuro = abzuloesendesDarlehenInEuro;
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

  public String getNameKreditInstitut() {
    return nameKreditInstitut;
  }

  public void setNameKreditInstitut(String nameKreditInstitut) {
    this.nameKreditInstitut = nameKreditInstitut;
  }

  public ZahlungsForm getZahlungsForm() {
    return zahlungsForm;
  }

  public void setZahlungsForm(ZahlungsForm zahlungsForm) {
    this.zahlungsForm = zahlungsForm;
  }

  public VermittlerDaten getVermittlerDaten() {
    return vermittlerDaten;
  }

  public void setVermittlerDaten(VermittlerDaten vermittlerDaten) {
    this.vermittlerDaten = vermittlerDaten;
  }
}
