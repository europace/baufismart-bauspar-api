package de.hypoport.efi.bausparen.model.dokumente;

public class Kontakt {

  String telefonNummer;
  String mobilNummer;
  String eMailAdresse;

  public String getTelefonNummer() {
    return telefonNummer;
  }

  public void setTelefonNummer(String telefonNummer) {
    this.telefonNummer = telefonNummer;
  }

  public String getMobilNummer() {
    return mobilNummer;
  }

  public void setMobilNummer(String mobilNummer) {
    this.mobilNummer = mobilNummer;
  }

  public String geteMailAdresse() {
    return eMailAdresse;
  }

  public void seteMailAdresse(String eMailAdresse) {
    this.eMailAdresse = eMailAdresse;
  }
}
