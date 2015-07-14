package de.hypoport.efi.bausparen.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Berechnungsdaten {

  BerechnungsZiel berechnungsZiel;
  Berechnungsart zinsabsicherung;
  Integer laufzeitBisZuteilungInMonaten;
  LocalDate vertragsbeginn;
  Abschlussgebuehrenbehandlung verrechnung;

  BigDecimal bausparsumme;
  BigDecimal einmalzahlung;
  BigDecimal sparBeitrag;
  BigDecimal tilgungsRate;


}
