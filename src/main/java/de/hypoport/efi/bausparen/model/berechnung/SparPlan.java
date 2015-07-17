package de.hypoport.efi.bausparen.model.berechnung;

import java.util.ArrayList;
import java.util.List;

public class SparPlan {

  List<SparPlanZahlung> zahlungen = new ArrayList<>();

  public List<SparPlanZahlung> getZahlungen() {
    return zahlungen;
  }

  public void setZahlungen(List<SparPlanZahlung> zahlungen) {
    this.zahlungen = zahlungen;
  }
}
