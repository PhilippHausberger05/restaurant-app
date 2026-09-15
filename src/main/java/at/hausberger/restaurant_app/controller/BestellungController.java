package at.hausberger.restaurant_app.controller;

import at.hausberger.restaurant_app.dto.BestellungRequest;
import at.hausberger.restaurant_app.dto.PositionRequest;
import at.hausberger.restaurant_app.model.*;
import at.hausberger.restaurant_app.repository.BestellungRepository;
import at.hausberger.restaurant_app.repository.KundeRepository;
import at.hausberger.restaurant_app.repository.GerichtRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bestellungen")
public class BestellungController {

    private final BestellungRepository bestellungRepository;
    private final KundeRepository kundeRepository;
    private final GerichtRepository gerichtRepository;

    public BestellungController(BestellungRepository bestellungRepository, KundeRepository kundeRepository, GerichtRepository gerichtRepository) {
        this.bestellungRepository = bestellungRepository;
        this.kundeRepository = kundeRepository;
        this.gerichtRepository = gerichtRepository;
    }

    @GetMapping
    public List<Bestellung> alleBestellungen() {
        return bestellungRepository.findAll();
    }

    @GetMapping("/{id}")
    public Bestellung eineBestellung(@PathVariable Long id) {
        return bestellungRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("keine Bestellung gefunden"));
    }

    @PostMapping
    public Bestellung neueBestellung(@RequestBody BestellungRequest request) {
        Kunde kunde = kundeRepository.findById(request.getKundeId())
                .orElseThrow(() -> new RuntimeException("Kunde nicht gefunden"));
        Bestellung bestellung = new Bestellung(kunde);

        for (PositionRequest positionRequest : request.getPositionen()) {
            Gericht gericht = gerichtRepository.findById(positionRequest.getGerichtId())
                    .orElseThrow(() -> new RuntimeException("Gericht nicht gefunden"));
            Bestellposition bestellposition = new Bestellposition(positionRequest.getMenge(), gericht, bestellung);
            bestellung.addPositionen(bestellposition);
        }
        return bestellungRepository.save(bestellung);
    }


}