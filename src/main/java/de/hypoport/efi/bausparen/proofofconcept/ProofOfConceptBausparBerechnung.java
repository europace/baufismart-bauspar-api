package de.hypoport.efi.bausparen.proofofconcept;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hypoport.efi.bausparen.model.berechnung.angebot.BausparBerechnungsAntwort;
import de.hypoport.efi.bausparen.model.berechnung.angebot.Bausparangebot;
import de.hypoport.efi.bausparen.model.meldungen.FachlicheMeldung;
import de.hypoport.efi.bausparen.model.meldungen.MeldungsStatus;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.BausparBerechnungsAnfrage;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class ProofOfConceptBausparBerechnung implements InitializingBean {

  private ObjectMapper objectMapper;

  public BausparBerechnungsAntwort berechneBausparAngebot(BausparBerechnungsAnfrage berechnungsdaten) throws Exception {
    BausparBerechnungsAntwort sampleAntwort = null;
    sampleAntwort = objectMapper.readValue(getClass().getResourceAsStream("/berechnetesbausparangebot.json"), BausparBerechnungsAntwort.class);

    Bausparangebot bausparangebot = sampleAntwort.getBerechnetesBausparAngebot();
    bausparangebot.setBausparsummeInEuro(berechnungsdaten.getBausparsummeInEuro());
    bausparangebot.getMeldungen().add(meldung());

    if (berechnungsdaten.getSparBeitraege() != null &&
        berechnungsdaten.getSparBeitraege().size() > 0 &&
        berechnungsdaten.getSparBeitraege().get(0).getBeitrag() != null) {
      bausparangebot.getSparPhase().setRegelsparbeitragInEuro(berechnungsdaten.getSparBeitraege().get(0).getBeitrag());
    }

    return sampleAntwort;
  }

  private FachlicheMeldung meldung() {
    FachlicheMeldung fachlicheMeldung = new FachlicheMeldung();
    fachlicheMeldung.setStatus(MeldungsStatus.HINWEIS);
    fachlicheMeldung.setText("Dies ist ein Beispiel Bauspar Angebot mit fixen Werten");
    return fachlicheMeldung;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    objectMapper = new ObjectMapper();
    objectMapper.findAndRegisterModules();
  }
}
