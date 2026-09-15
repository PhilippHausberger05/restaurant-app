package at.hausberger.restaurant_app.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bestellposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int menge;

    @ManyToOne
    @JoinColumn(name = "bestellung_id")
    @JsonIgnore
    private Bestellung bestellung;

    @ManyToOne
    @JoinColumn(name = "gericht_id")
    private Gericht gericht;


    public Bestellposition() {

    }

    public Bestellposition(int menge, Gericht gericht, Bestellung bestellung) {
        setMenge(menge);
        setGericht(gericht);
        setBestellung(bestellung);
    }
    public void setMenge(int menge) {
        if (menge < 1) {
            throw new IllegalArgumentException("Mind. 1 Portion");
        }
        this.menge = menge;
    }

    public void setGericht(Gericht gericht) {
        if (gericht == null) {
            throw new IllegalArgumentException("kein Gericht ausgewählt");
        }
        this.gericht = gericht;
    }

    public void setBestellung(Bestellung bestellung) {
        if (bestellung == null) {
            throw new IllegalArgumentException("Bestellung exisitert nicht");
        }
        this.bestellung = bestellung;
    }

    public int getMenge() {
        return menge;
    }

    public Gericht getGericht() {
        return gericht;
    }

    public Long getId() {
        return id;
    }

    public Bestellung getBestellung() {
        return bestellung;
    }

}
