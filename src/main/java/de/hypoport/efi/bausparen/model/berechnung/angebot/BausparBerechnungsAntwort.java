package de.hypoport.efi.bausparen.model.berechnung.angebot;

import de.hypoport.efi.bausparen.model.berechnung.angebot.Bausparangebot;

public class BausparBerechnungsAntwort {

  Bausparangebot berechnetesBausparAngebot;

  public Bausparangebot getBerechnetesBausparAngebot() {
    return berechnetesBausparAngebot;
  }

  public void setBerechnetesBausparAngebot(Bausparangebot berechnetesBausparAngebot) {
    this.berechnetesBausparAngebot = berechnetesBausparAngebot;
  }
}
