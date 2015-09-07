package de.hypoport.efi.bausparen.model.berechnung;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Bausparangebot {

  String tarif;
  BerechnungsZiel berechnungsziel;
  BigDecimal bausparsummeInEuro;
  Integer laufzeitBisZuteilungInMonaten;
  LocalDate zuteilungsTermin;
  BausparDarlehen bausparDarlehen;
  SparPhase sparPhase;
  Abschlussgebuehr abschlussgebuehr;
  BigDecimal kontogebuehrJaehrlichInEuro;
  BigDecimal gesamtleistungKomplettInEuro;
  Integer gesamtlaufzeitKomplettInMonaten;
  List<FachlicheMeldung> meldungen;
  LocalDate vertragsDatum;

  public String getTarif() {
    return tarif;
  }

  public void setTarif(String tarif) {
    this.tarif = tarif;
  }

  public BerechnungsZiel getBerechnungsziel() {
    return berechnungsziel;
  }

  public void setBerechnungsziel(BerechnungsZiel berechnungsziel) {
    this.berechnungsziel = berechnungsziel;
  }

  public BigDecimal getBausparsummeInEuro() {
    return bausparsummeInEuro;
  }

  public void setBausparsummeInEuro(BigDecimal bausparsummeInEuro) {
    this.bausparsummeInEuro = bausparsummeInEuro;
  }

  public Integer getLaufzeitBisZuteilungInMonaten() {
    return laufzeitBisZuteilungInMonaten;
  }

  public void setLaufzeitBisZuteilungInMonaten(Integer laufzeitBisZuteilungInMonaten) {
    this.laufzeitBisZuteilungInMonaten = laufzeitBisZuteilungInMonaten;
  }

  public LocalDate getZuteilungsTermin() {
    return zuteilungsTermin;
  }

  public void setZuteilungsTermin(LocalDate zuteilungsTermin) {
    this.zuteilungsTermin = zuteilungsTermin;
  }

  public SparPhase getSparPhase() {
    return sparPhase;
  }

  public void setSparPhase(SparPhase sparPhase) {
    this.sparPhase = sparPhase;
  }

  public BausparDarlehen getBausparDarlehen() {
    return bausparDarlehen;
  }

  public void setBausparDarlehen(BausparDarlehen bausparDarlehen) {
    this.bausparDarlehen = bausparDarlehen;
  }

  public Abschlussgebuehr getAbschlussgebuehr() {
    return abschlussgebuehr;
  }

  public void setAbschlussgebuehr(Abschlussgebuehr abschlussgebuehr) {
    this.abschlussgebuehr = abschlussgebuehr;
  }

  public BigDecimal getKontogebuehrJaehrlichInEuro() {
    return kontogebuehrJaehrlichInEuro;
  }

  public void setKontogebuehrJaehrlichInEuro(BigDecimal kontogebuehrJaehrlichInEuro) {
    this.kontogebuehrJaehrlichInEuro = kontogebuehrJaehrlichInEuro;
  }

  public BigDecimal getGesamtleistungKomplettInEuro() {
    return gesamtleistungKomplettInEuro;
  }

  public void setGesamtleistungKomplettInEuro(BigDecimal gesamtleistungKomplettInEuro) {
    this.gesamtleistungKomplettInEuro = gesamtleistungKomplettInEuro;
  }

  public Integer getGesamtlaufzeitKomplettInMonaten() {
    return gesamtlaufzeitKomplettInMonaten;
  }

  public void setGesamtlaufzeitKomplettInMonaten(Integer gesamtlaufzeitKomplettInMonaten) {
    this.gesamtlaufzeitKomplettInMonaten = gesamtlaufzeitKomplettInMonaten;
  }

  public List<FachlicheMeldung> getMeldungen() {
    return meldungen;
  }

  public void setMeldungen(List<FachlicheMeldung> meldungen) {
    this.meldungen = meldungen;
  }

  public LocalDate getVertragsDatum() {
    return vertragsDatum;
  }

  public void setVertragsDatum(LocalDate vertragsDatum) {
    this.vertragsDatum = vertragsDatum;
  }
}
