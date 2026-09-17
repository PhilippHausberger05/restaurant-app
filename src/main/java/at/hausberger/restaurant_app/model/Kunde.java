package at.hausberger.restaurant_app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Kunde {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)
    private String email;
    private String hashedPassword;
    private KundeRolle rolle;

    public Kunde() {
        this.rolle = KundeRolle.USER;
    }

    public Kunde(String name, String email) {
        this();
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

    public void setHashedPassword(String hashedPassword) {
        if (hashedPassword == null || hashedPassword.isEmpty()) {
            throw new IllegalArgumentException("Passwort ist leer");
        }
        this.hashedPassword = hashedPassword;
    }

    public KundeRolle getRolle() {
        return rolle;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore
    public String getHashedPassword() {
        return hashedPassword;
    }

    public Long getId() {
        return id;
    }
}
