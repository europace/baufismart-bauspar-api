package de.hypoport.efi.bausparen.proofofconcept;

import de.hypoport.efi.bausparen.model.berechnung.BausparBerechnungsAntwort;
import de.hypoport.efi.bausparen.model.berechnung.Bausparangebot;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.BausparBerechnungsAnfrage;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static java.time.LocalDate.now;
import static java.util.Arrays.asList;

@Component
public class ProofOfConceptBausparBerechnung {

  public static final String TEST_TARIF = "4711";

  public BausparBerechnungsAntwort berechneBausparAngebot(BausparBerechnungsAnfrage berechnungsdaten) {
    BausparBerechnungsAntwort bausparBerechungsErgebnis = new BausparBerechnungsAntwort();
    Bausparangebot bausparangebot = new Bausparangebot();
    bausparangebot.setTarif("Tarif DV 1");
    bausparangebot.setVertragsBeginn(now());
    bausparangebot.setAbschlussgebuehrBetragInEuro(new BigDecimal("100"));
    bausparBerechungsErgebnis.setBerechnetesBausparAngebot(bausparangebot);

    return bausparBerechungsErgebnis;
  }
}
