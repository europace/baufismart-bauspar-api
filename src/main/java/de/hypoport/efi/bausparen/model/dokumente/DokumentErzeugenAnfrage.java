package de.hypoport.efi.bausparen.model.dokumente;

import de.hypoport.efi.bausparen.model.basis.Abschlussgebuehrenbehandlung;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.BerechnungsArt;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DokumentErzeugenAnfrage {

  String tarif;
  BerechnungsArt berechnungsArt;
  BigDecimal bausparSummeInEuro;
  Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung;
  BigDecimal abschlussgebuehrHoeheInEuro;
  List<Antragsteller> antragsteller;
  VermittlerDaten vermittlerDaten;
  SparphaseDokument sparphaseDokument;
  LocalDate vertragsDatum;
  String fallNummer;
  String requestId;
  Boolean fallAuswahl;

  public String getTarif() {
    return tarif;
  }

  public void setTarif(String tarif) {
    this.tarif = tarif;
  }

  public BerechnungsArt getBerechnungsArt() {
    return berechnungsArt;
  }

  public void setBerechnungsArt(BerechnungsArt berechnungsArt) {
    this.berechnungsArt = berechnungsArt;
  }

  public BigDecimal getBausparSummeInEuro() {
    return bausparSummeInEuro;
  }

  public void setBausparSummeInEuro(BigDecimal bausparSummeInEuro) {
    this.bausparSummeInEuro = bausparSummeInEuro;
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

  public SparphaseDokument getSparphaseDokument() {
    return sparphaseDokument;
  }

  public void setSparphaseDokument(SparphaseDokument sparphaseDokument) {
    this.sparphaseDokument = sparphaseDokument;
  }

  public BigDecimal getAbschlussgebuehrHoeheInEuro() {
    return abschlussgebuehrHoeheInEuro;
  }

  public void setAbschlussgebuehrHoeheInEuro(BigDecimal abschlussgebuehrHoeheInEuro) {
    this.abschlussgebuehrHoeheInEuro = abschlussgebuehrHoeheInEuro;
  }

  public LocalDate getVertragsDatum() {
    return vertragsDatum;
  }

  public void setVertragsDatum(LocalDate vertragsDatum) {
    this.vertragsDatum = vertragsDatum;
  }

  public String getFallNummer() {
    return fallNummer;
  }

  public void setFallNummer(String fallNummer) {
    this.fallNummer = fallNummer;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public Boolean getFallAuswahl() {
    return fallAuswahl;
  }

  public void setFallAuswahl(Boolean fallAuswahl) {
    this.fallAuswahl = fallAuswahl;
  }
}