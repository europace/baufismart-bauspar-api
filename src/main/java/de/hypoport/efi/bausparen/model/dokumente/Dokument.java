package de.hypoport.efi.bausparen.model.dokumente;

public class Dokument {

  String dokumentName;
  String dokumentBase64Encoded;

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
}
