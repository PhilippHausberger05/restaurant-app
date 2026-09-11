package at.hausberger.restaurant_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Gericht {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double preis;

    public Gericht() {
    }

    public Gericht(String name, double preis) {
        setName(name);
        setPreis(preis);
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Produkt hat keinen Namen");
        }
        this.name = name;
    }

    public void setPreis(double preis) {
        if (preis < 0) {
            throw new IllegalArgumentException("Produkt darf nicht negativ Kosten habem");
        }
        this.preis = preis;
    }

    public double getPreis() {
        return preis;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}