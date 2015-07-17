package de.hypoport.efi.bausparen.model.berechnung;

public class BausparBerechnungsAntwort {

  String tarif;
  SparPlan sparPlan;
  TilgungsPlan tilgungsPlan;

  public String getTarif() {
    return tarif;
  }

  public void setTarif(String tarif) {
    this.tarif = tarif;
  }

  public SparPlan getSparPlan() {
    return sparPlan;
  }

  public void setSparPlan(SparPlan sparPlan) {
    this.sparPlan = sparPlan;
  }

  public TilgungsPlan getTilgungsPlan() {
    return tilgungsPlan;
  }

  public void setTilgungsPlan(TilgungsPlan tilgungsPlan) {
    this.tilgungsPlan = tilgungsPlan;
  }
}
