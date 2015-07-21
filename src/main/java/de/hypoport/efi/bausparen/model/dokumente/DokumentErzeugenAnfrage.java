package de.hypoport.efi.bausparen.model.dokumente;

import java.util.List;

public class DokumentErzeugenAnfrage {

  List<Antragsteller> antragsteller;//check

  String nameKreditInstitut;//check
  ZahlungsForm zahlungsForm;//check

  VermittlerDaten vermittlerDaten;//check

  public List<Antragsteller> getAntragsteller() {
    return antragsteller;
  }

  public void setAntragsteller(List<Antragsteller> antragsteller) {
    this.antragsteller = antragsteller;
  }

  public String getNameKreditInstitut() {
    return nameKreditInstitut;
  }

  public void setNameKreditInstitut(String nameKreditInstitut) {
    this.nameKreditInstitut = nameKreditInstitut;
  }

  public ZahlungsForm getZahlungsForm() {
    return zahlungsForm;
  }

  public void setZahlungsForm(ZahlungsForm zahlungsForm) {
    this.zahlungsForm = zahlungsForm;
  }

  public VermittlerDaten getVermittlerDaten() {
    return vermittlerDaten;
  }

  public void setVermittlerDaten(VermittlerDaten vermittlerDaten) {
    this.vermittlerDaten = vermittlerDaten;
  }
}
