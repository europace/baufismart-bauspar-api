package de.hypoport.efi.bausparen.model.berechnung;

import java.util.ArrayList;
import java.util.List;

public class TilgungsPlan {

  List<TilgungsPlanZahlung> zahlungen = new ArrayList<>();

  public List<TilgungsPlanZahlung> getZahlungen() {
    return zahlungen;
  }

  public void setZahlungen(List<TilgungsPlanZahlung> zahlungen) {
    this.zahlungen = zahlungen;
  }
}
