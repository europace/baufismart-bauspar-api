package de.hypoport.efi.bausparen.model.dokumente;

import de.hypoport.efi.bausparen.model.berechnung.Abschlussgebuehrenbehandlung;
import org.joda.time.LocalDate;

import java.math.BigDecimal;
import java.util.List;

public class DokumentErzeugenAnfrage {

  String tarif;
  BigDecimal bausparSummeInEuro;
  BigDecimal auszahlungsbetragBeiZuteilung;
  Abschlussgebuehrenbehandlung abschlussgebuehrenbehandlung;
  BigDecimal abschlussgebuehrHoeheInEuro;
  BigDecimal zahlungsbetragEinmalzahlungInEuro;
  List<Antragsteller> antragsteller;
  VermittlerDaten vermittlerDaten;
  SparphaseDokument sparphaseDokument;
  LocalDate vertragsDatum;
  String fallNummer;

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

  public BigDecimal getZahlungsbetragEinmalzahlungInEuro() {
    return zahlungsbetragEinmalzahlungInEuro;
  }

  public void setZahlungsbetragEinmalzahlungInEuro(BigDecimal zahlungsbetragEinmalzahlungInEuro) {
    this.zahlungsbetragEinmalzahlungInEuro = zahlungsbetragEinmalzahlungInEuro;
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
}