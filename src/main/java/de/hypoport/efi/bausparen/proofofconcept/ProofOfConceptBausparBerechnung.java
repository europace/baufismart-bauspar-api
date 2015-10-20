package de.hypoport.efi.bausparen.proofofconcept;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hypoport.efi.bausparen.model.berechnung.BausparBerechnungsAntwort;
import de.hypoport.efi.bausparen.model.berechnung.Bausparangebot;
import de.hypoport.efi.bausparen.model.berechnung.FachlicheMeldung;
import de.hypoport.efi.bausparen.model.berechnung.MeldungsStatus;
import de.hypoport.efi.bausparen.model.berechnung.anfrage.BausparBerechnungsAnfrage;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class ProofOfConceptBausparBerechnung implements InitializingBean{

  private ObjectMapper objectMapper;

  public BausparBerechnungsAntwort berechneBausparAngebot(BausparBerechnungsAnfrage berechnungsdaten) throws Exception {
    BausparBerechnungsAntwort sampleAntwort = null;
      sampleAntwort = objectMapper.readValue(getClass().getResourceAsStream("/berechnetesbausparangebot.json"), BausparBerechnungsAntwort.class);

    Bausparangebot bausparangebot = sampleAntwort.getBerechnetesBausparAngebot();
    bausparangebot.setBausparsummeInEuro(berechnungsdaten.getBausparsummeInEuro());
    bausparangebot.getMeldungen().add(meldung());

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
