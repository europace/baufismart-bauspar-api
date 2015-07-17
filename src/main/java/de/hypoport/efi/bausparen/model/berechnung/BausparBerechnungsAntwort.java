package de.hypoport.efi.bausparen.model.berechnung;

import java.util.List;

public class BausparBerechnungsAntwort {

  List<Bausparangebot> berechneteBausparAngebote;

  public List<Bausparangebot> getBerechneteBausparAngebote() {
    return berechneteBausparAngebote;
  }

  public void setBerechneteBausparAngebote(List<Bausparangebot> berechneteBausparAngebote) {
    this.berechneteBausparAngebote = berechneteBausparAngebote;
  }
}
