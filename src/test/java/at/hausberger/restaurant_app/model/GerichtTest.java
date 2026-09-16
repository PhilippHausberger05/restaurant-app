package at.hausberger.restaurant_app.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class GerichtTest {

    @Test
    void gueltigerPreisWirdGesetzt() {
        Gericht gericht = new Gericht("Pizza", 9.5);
        assertEquals(9.5, gericht.getPreis());
    }

    @Test
    void negativerPreisWirftException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Gericht("Pizza", -5);
        });
    }


    @Test
    void gueltigerNameWirdGesetzt() {
        Gericht gericht = new Gericht("Pizza", 9.5);
        assertEquals("Pizza",gericht.getName());
    }

    @Test
    void ungueltigerNameWirftException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Gericht("", 9.5);
        });
    }



}