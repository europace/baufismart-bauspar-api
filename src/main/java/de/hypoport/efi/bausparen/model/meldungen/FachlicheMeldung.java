package de.hypoport.efi.bausparen.model.meldungen;

public class FachlicheMeldung {

  String text;
  MeldungsStatus status;
  MeldungsZuordnung zuordnung;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public MeldungsStatus getStatus() {
    return status;
  }

  public void setStatus(MeldungsStatus status) {
    this.status = status;
  }

  public MeldungsZuordnung getZuordnung() {
    return zuordnung;
  }

  public void setZuordnung(MeldungsZuordnung zuordnung) {
    this.zuordnung = zuordnung;
  }
}
