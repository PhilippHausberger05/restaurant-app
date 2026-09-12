package at.hausberger.restaurant_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kunde {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    public Kunde() {
    }

    public Kunde(String name, String email) {
        setName(name);
        setEmail(email);
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name wurde leergelassen.");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        boolean richtigeEmail = email.contains("@");
        if (!richtigeEmail) {
            throw new IllegalArgumentException("keine gültige Email-Adresse");
        }
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
