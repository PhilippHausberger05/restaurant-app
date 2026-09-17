package at.hausberger.restaurant_app.controller;


import at.hausberger.restaurant_app.dto.KundeRequest;
import at.hausberger.restaurant_app.model.Kunde;
import at.hausberger.restaurant_app.repository.KundeRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kunden")
public class KundeController {

    private final KundeRepository kundeRepository;
    private final PasswordEncoder passwordEncoder;

    public KundeController(KundeRepository kundeRepository, PasswordEncoder passwordEncoder) {
        this.kundeRepository = kundeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<Kunde> alleKunden() {
        return kundeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Kunde einKunde(@PathVariable Long id) {
        return kundeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kunde nicht gefunden"));
    }

    @PutMapping("/{id}")
    public Kunde kundeAendern(@PathVariable Long id, @RequestBody Kunde neueDaten) {
        Kunde kunde = kundeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kunde nicht gefunden"));
        kunde.setName(neueDaten.getName());
        kunde.setEmail(neueDaten.getEmail());
        return kundeRepository.save(kunde);
    }

    @DeleteMapping("/{id}")
    public void kundeLoeschen(@PathVariable Long id) {
        kundeRepository.deleteById(id);
    }

    @PostMapping
    public Kunde neuerKunde(@RequestBody KundeRequest request) {
        if (request.getPasswort() == null || request.getPasswort().length() < 8) {
            throw new IllegalArgumentException("Passwort muss mindestens 8 Zeichen haben");
        }

        Kunde kunde = new Kunde(request.getName(), request.getEmail());

        String hashedPassword = passwordEncoder.encode(request.getPasswort());
        kunde.setHashedPassword(hashedPassword);

        return kundeRepository.save(kunde);
    }
}

