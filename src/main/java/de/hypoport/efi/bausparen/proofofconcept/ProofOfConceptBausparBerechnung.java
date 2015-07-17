package de.hypoport.efi.bausparen.proofofconcept;

import de.hypoport.efi.bausparen.model.berechnung.BausparBerechnungsAnfrage;
import de.hypoport.efi.bausparen.model.berechnung.BausparBerechnungsAntwort;
import org.springframework.stereotype.Component;

@Component
public class ProofOfConceptBausparBerechnung {

  public static final String TEST_TARIF = "4711";

  public BausparBerechnungsAntwort berechneBausparAngebot(BausparBerechnungsAnfrage berechnungsdaten) {
    BausparBerechnungsAntwort bausparBerechungsErgebnis = new BausparBerechnungsAntwort();
    bausparBerechungsErgebnis.setTarif(TEST_TARIF);

    return bausparBerechungsErgebnis;
  }
}
