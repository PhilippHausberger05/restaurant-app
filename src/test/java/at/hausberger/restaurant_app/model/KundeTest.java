package at.hausberger.restaurant_app.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KundeTest {

    @Test
    void gueltigeEmailWirdGesetzt() {
        Kunde kunde = new Kunde("test", "test@gmail.com");
        assertEquals("test@gmail.com", kunde.getEmail());
    }

    @Test
    void ungueltigeEmailWirftException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Kunde("test", "testgmail.com");
        });
    }

    @Test
    void gueltigerNameWirdGesetzt() {
        Kunde kunde = new Kunde("test", "test@gmail.com");
        assertEquals("test",kunde.getName());
    }

    @Test
    void ungueltigerNameWirftException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Kunde("", "test@gmail.com");
        });
    }


}