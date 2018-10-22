package de.hypoport.efi.bausparen.model.basis;

import de.hypoport.efi.bausparen.model.dokumente.BeschaeftigungsVerhaeltnis;
import de.hypoport.efi.bausparen.model.dokumente.FamilienStand;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class RiesterDaten {

  private String riesterzulagenVerwendung;
  private LocalDate geburtsdatumAntragsteller;
  private BeschaeftigungsVerhaeltnis beschaeftigungAntragsteller;
  private BigDecimal einkommenVorjahrAntragsteller;
  private BigDecimal einkommenAktuellesJahrAntragsteller;
  private List<ZulagenKind> zulagenKinderAntragsteller;
  private FamilienStand familienstand;
  private Boolean gueterTrennungVereinbart;
  private LocalDate geburtsdatumEhepartner;
  private BeschaeftigungsVerhaeltnis beschaeftigungEhepartner;
  private BigDecimal einkommenVorjahrEhepartner;
  private BigDecimal einkommenAktuellesJahrEhepartner;
  private List<ZulagenKind> zulagenKinderEhepartner;

  public String getRiesterzulagenVerwendung() {
    return riesterzulagenVerwendung;
  }

  public void setRiesterzulagenVerwendung(String riesterzulagenVerwendung) {
    this.riesterzulagenVerwendung = riesterzulagenVerwendung;
  }

  public LocalDate getGeburtsdatumAntragsteller() {
    return geburtsdatumAntragsteller;
  }

  public void setGeburtsdatumAntragsteller(LocalDate geburtsdatumAntragsteller) {
    this.geburtsdatumAntragsteller = geburtsdatumAntragsteller;
  }

  public BeschaeftigungsVerhaeltnis getBeschaeftigungAntragsteller() {
    return beschaeftigungAntragsteller;
  }

  public void setBeschaeftigungAntragsteller(BeschaeftigungsVerhaeltnis beschaeftigungAntragsteller) {
    this.beschaeftigungAntragsteller = beschaeftigungAntragsteller;
  }

  public BigDecimal getEinkommenVorjahrAntragsteller() {
    return einkommenVorjahrAntragsteller;
  }

  public void setEinkommenVorjahrAntragsteller(BigDecimal einkommenVorjahrAntragsteller) {
    this.einkommenVorjahrAntragsteller = einkommenVorjahrAntragsteller;
  }

  public BigDecimal getEinkommenAktuellesJahrAntragsteller() {
    return einkommenAktuellesJahrAntragsteller;
  }

  public void setEinkommenAktuellesJahrAntragsteller(BigDecimal einkommenAktuellesJahrAntragsteller) {
    this.einkommenAktuellesJahrAntragsteller = einkommenAktuellesJahrAntragsteller;
  }

  public List<ZulagenKind> getZulagenKinderAntragsteller() {
    return zulagenKinderAntragsteller;
  }

  public void setZulagenKinderAntragsteller(List<ZulagenKind> zulagenKinderAntragsteller) {
    this.zulagenKinderAntragsteller = zulagenKinderAntragsteller;
  }

  public FamilienStand getFamilienstand() {
    return familienstand;
  }

  public void setFamilienstand(FamilienStand familienStand) {
    this.familienstand = familienStand;
  }

  public Boolean getGueterTrennungVereinbart() {
    return gueterTrennungVereinbart;
  }

  public void setGueterTrennungVereinbart(Boolean gueterTrennungVereinbart) {
    this.gueterTrennungVereinbart = gueterTrennungVereinbart;
  }

  public LocalDate getGeburtsdatumEhepartner() {
    return geburtsdatumEhepartner;
  }

  public void setGeburtsdatumEhepartner(LocalDate geburtsdatumEhepartner) {
    this.geburtsdatumEhepartner = geburtsdatumEhepartner;
  }

  public BeschaeftigungsVerhaeltnis getBeschaeftigungEhepartner() {
    return beschaeftigungEhepartner;
  }

  public void setBeschaeftigungEhepartner(BeschaeftigungsVerhaeltnis beschaeftigungEhepartner) {
    this.beschaeftigungEhepartner = beschaeftigungEhepartner;
  }

  public BigDecimal getEinkommenVorjahrEhepartner() {
    return einkommenVorjahrEhepartner;
  }

  public void setEinkommenVorjahrEhepartner(BigDecimal einkommenVorjahrEhepartner) {
    this.einkommenVorjahrEhepartner = einkommenVorjahrEhepartner;
  }

  public BigDecimal getEinkommenAktuellesJahrEhepartner() {
    return einkommenAktuellesJahrEhepartner;
  }

  public void setEinkommenAktuellesJahrEhepartner(BigDecimal einkommenAktuellesJahrEhepartner) {
    this.einkommenAktuellesJahrEhepartner = einkommenAktuellesJahrEhepartner;
  }

  public List<ZulagenKind> getZulagenKinderEhepartner() {
    return zulagenKinderEhepartner;
  }

  public void setZulagenKinderEhepartner(List<ZulagenKind> zulagenKinderEhepartner) {
    this.zulagenKinderEhepartner = zulagenKinderEhepartner;
  }
}
