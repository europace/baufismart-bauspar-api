package de.hypoport.efi.bausparen.model.dokumente;

public class ZahlungsDaten {

  String iban;

  String nameKreditInstitut;
  ZahlungsForm zahlungsForm;

  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
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
}
