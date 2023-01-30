package de.hypoport.efi.bausparen.model.dokumente;

import de.hypoport.efi.bausparen.model.basis.Zahlungsrhythmus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SonderZahlung {

    BigDecimal betrag;
    Zahlungsrhythmus zahlungsrhythmus;
    LocalDate termin;
    Integer anzahl;

    public BigDecimal getBetrag() {
        return betrag;
    }

    public void setBetrag(BigDecimal betrag) {
        this.betrag = betrag;
    }

    public Zahlungsrhythmus getZahlungsrhythmus() {
        return zahlungsrhythmus;
    }

    public void setZahlungsrhythmus(Zahlungsrhythmus zahlungsrhythmus) {
        this.zahlungsrhythmus = zahlungsrhythmus;
    }

    public LocalDate getTermin() {
        return termin;
    }

    public void setTermin(LocalDate termin) {
        this.termin = termin;
    }

    public Integer getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Integer anzahl) {
        this.anzahl = anzahl;
    }
}
