package at.hausberger.restaurant_app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bestellung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BestellStatus status;
    private LocalDateTime bestellzeit;

    @OneToMany(mappedBy = "bestellung", cascade = CascadeType.ALL)
    private List<Bestellposition> positionen = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "kunde_id")
    private Kunde kunde;

    public Bestellung() {
        this.status = BestellStatus.AUFGEGEBEN;
        this.bestellzeit = LocalDateTime.now();
    }

    public Bestellung(Kunde kunde) {
        this();
        setKunde(kunde);
    }

    public void setBestellStatus(BestellStatus status){
        if (status == null) {
            throw new IllegalArgumentException("Status darf nicht leer sein");
        }
        this.status = status;
    }

    public void setKunde(Kunde kunde) {
        if (kunde == null) {
            throw new IllegalArgumentException("Kein Kunde ausgewählt");
        }
        this.kunde = kunde;
    }

    public void addPositionen (Bestellposition position) {
        positionen.add(position);
        position.setBestellung(this);
    }

    public BestellStatus getStatus() {
        return status;
    }

    public LocalDateTime getBestellzeit(){
        return bestellzeit;
    }

    public Kunde getKunde(){
        return kunde;
    }

    public Long getId() {
        return id;
    }

    public List<Bestellposition> getPositionen() {
        return positionen;
    }

}