package at.hausberger.restaurant_app.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BestellpositionTest {

    @Test
    void gueltigeBestellpositionWirdGesetzt() {
        Gericht gericht = new Gericht("Pizza", 9.5);
        Kunde kunde = new Kunde("Test", "test@test.com");
        Bestellung bestellung = new Bestellung(kunde);
        Bestellposition position = new Bestellposition(2, gericht, bestellung);

        assertEquals(2, position.getMenge());
        assertEquals(gericht, position.getGericht());
        assertEquals(bestellung, position.getBestellung());

    }

    @Test
    void ungueltigeMengeKleinerEinsWirftException() {
        Gericht gericht = new Gericht("Pizza", 9.5);
        Kunde kunde = new Kunde("Test", "test@test.com");
        Bestellung bestellung = new Bestellung(kunde);
        assertThrows(IllegalArgumentException.class, () -> {
            new Bestellposition(0, gericht, bestellung);
        });
    }

    @Test
    void ungueltigesGerichtGleichNullWirftException() {
        Kunde kunde = new Kunde("Test", "test@test.com");
        Bestellung bestellung = new Bestellung(kunde);
        assertThrows(IllegalArgumentException.class, () -> {
            new Bestellposition(2, null, bestellung);
        });
    }

    @Test
    void ungueltigeBestellungGleichNullWirftException() {
        Kunde kunde = new Kunde("Test", "test@test.com");
        Gericht gericht = new Gericht("Pizza", 9.5);
        assertThrows(IllegalArgumentException.class, () -> {
            new Bestellposition(2, gericht, null);
        });
    }


}
