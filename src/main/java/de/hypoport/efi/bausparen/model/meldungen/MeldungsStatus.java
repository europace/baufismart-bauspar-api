package de.hypoport.efi.bausparen.model.meldungen;

public enum MeldungsStatus {
  HINWEIS,
  @Deprecated
  BERECHNUNG_NICHT_MOEGLICH_AUFGRUND_FEHLENDER_DATEN,
  VOLLSTAENDIGKEIT_DOKUMENT,
  NICHT_MACHBAR,
  ANPASSUNG,
  TECHNISCHER_FEHLER;
}
