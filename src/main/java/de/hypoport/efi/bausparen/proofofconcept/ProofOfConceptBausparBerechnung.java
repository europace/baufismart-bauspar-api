package de.hypoport.efi.bausparen.proofofconcept;

import de.hypoport.efi.bausparen.model.berechnung.BausparBerechnungsAnfrage;
import de.hypoport.efi.bausparen.model.berechnung.BausparBerechnungsAntwort;
import de.hypoport.efi.bausparen.model.berechnung.Bausparangebot;
import org.springframework.stereotype.Component;

@Component
public class ProofOfConceptBausparBerechnung {

  public static final String TEST_TARIF = "4711";

  public BausparBerechnungsAntwort berechneBausparAngebot(BausparBerechnungsAnfrage berechnungsdaten) {
    BausparBerechnungsAntwort bausparBerechungsErgebnis = new BausparBerechnungsAntwort();
    Bausparangebot bausparangebot = new Bausparangebot();
    bausparangebot.setTarif("Tarif DV 1");
    bausparBerechungsErgebnis.getBerechneteBausparAngebote().add(bausparangebot);

    return bausparBerechungsErgebnis;
  }
}
