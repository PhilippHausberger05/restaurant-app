package at.hausberger.restaurant_app.controller;


import at.hausberger.restaurant_app.model.Kunde;
import at.hausberger.restaurant_app.repository.KundeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kunden")
public class KundeController {

    private final KundeRepository kundeRepository;

    public KundeController(KundeRepository kundeRepository) {
        this.kundeRepository = kundeRepository;
    }

    @GetMapping
    public List<Kunde> alleKunden() {
        return kundeRepository.findAll();
    }

    @PostMapping
    public Kunde neuerKunde(@RequestBody Kunde kunde) {
        return kundeRepository.save(kunde);
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
}

