package at.hausberger.restaurant_app.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BestellungTest {

    @Test
    void gueltigerStatuswechselVorwaertsFunktioniert() {
        Kunde kunde = new Kunde("Test", "test@test.com");
        Bestellung bestellung = new Bestellung(kunde);

        bestellung.setBestellStatus(BestellStatus.IN_KUECHE);

        assertEquals(BestellStatus.IN_KUECHE, bestellung.getStatus());
    }

    @Test
    void gueltigerStatuswechselZurueckFunktioniert() {
        Kunde kunde = new Kunde("Test", "test@test.com");
        Bestellung bestellung = new Bestellung(kunde);

        bestellung.setBestellStatus(BestellStatus.IN_KUECHE);
        bestellung.setBestellStatus(BestellStatus.AUFGEGEBEN);

        assertEquals(BestellStatus.AUFGEGEBEN, bestellung.getStatus());
    }

    @Test
    void ungueltigerStatuswechselZweiUnterschied() {
        Kunde kunde = new Kunde("Test", "test@test.com");
        Bestellung bestellung = new Bestellung(kunde);

        assertThrows(IllegalArgumentException.class, () -> {
            bestellung.setBestellStatus(BestellStatus.FERTIG);
        });

    }

    @Test
    void ungueltigerStatuswechselKeinUnterschied() {
        Kunde kunde = new Kunde("Test", "test@test.com");
        Bestellung bestellung = new Bestellung(kunde);

        assertThrows(IllegalArgumentException.class, () -> {
            bestellung.setBestellStatus(BestellStatus.AUFGEGEBEN);;
        });

    }

}