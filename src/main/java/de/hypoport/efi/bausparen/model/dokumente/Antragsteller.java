package de.hypoport.efi.bausparen.model.dokumente;

import java.time.LocalDate;

public class Antragsteller {

  Anrede anrede; //check
  String titel; //check
  String nachName; //check
  String vorName; //check
  LocalDate geburtsDatum; //check
  String geburtsName; //check
  String staatsangehoerigkeit; //check

  Adresse adresse;//check

  Kontakt kontakt;//check

  FamilienStand familienStand;//check

  KontoDaten kontoDaten;//check

  public String getNachName() {
    return nachName;
  }

  public void setNachName(String nachName) {
    this.nachName = nachName;
  }

  public String getVorName() {
    return vorName;
  }

  public void setVorName(String vorName) {
    this.vorName = vorName;
  }
}
