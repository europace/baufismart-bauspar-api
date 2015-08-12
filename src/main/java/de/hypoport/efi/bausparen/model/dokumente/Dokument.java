package de.hypoport.efi.bausparen.model.dokumente;

import de.hypoport.efi.bausparen.model.berechnung.FachlicheMeldung;

import java.util.List;

public class Dokument {

  String dokumentName;
  String dokumentBase64Encoded;
  List<FachlicheMeldung> vollstaendigkeitsMeldungen;

  public String getDokumentName() {
    return dokumentName;
  }

  public void setDokumentName(String dokumentName) {
    this.dokumentName = dokumentName;
  }

  public String getDokumentBase64Encoded() {
    return dokumentBase64Encoded;
  }

  public void setDokumentBase64Encoded(String dokumentBase64Encoded) {
    this.dokumentBase64Encoded = dokumentBase64Encoded;
  }

  public List<FachlicheMeldung> getVollstaendigkeitsMeldungen() {
    return vollstaendigkeitsMeldungen;
  }

  public void setVollstaendigkeitsMeldungen(List<FachlicheMeldung> vollstaendigkeitsMeldungen) {
    this.vollstaendigkeitsMeldungen = vollstaendigkeitsMeldungen;
  }
}
