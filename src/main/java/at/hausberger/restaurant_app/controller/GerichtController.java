package at.hausberger.restaurant_app.controller;

import at.hausberger.restaurant_app.model.Gericht;
import at.hausberger.restaurant_app.repository.GerichtRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerichte")
public class GerichtController {

    private final GerichtRepository gerichtRepository;

    public GerichtController(GerichtRepository gerichtRepository) {
        this.gerichtRepository = gerichtRepository;
    }

    @GetMapping
    public List<Gericht> alleGerichte() {
        return gerichtRepository.findAll();
    }

    @PostMapping
    public Gericht neuesGericht(@RequestBody Gericht gericht) {
        return gerichtRepository.save(gericht);
    }

    @GetMapping("/{id}")
    public Gericht einGericht(@PathVariable Long id) {
        return gerichtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gericht nicht gefunden"));
    }

    @PutMapping("/{id}")
    public Gericht gerichtAendern(@PathVariable Long id, @RequestBody Gericht neueDaten) {
        Gericht gericht = gerichtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gericht nicht gefunden"));
        gericht.setName(neueDaten.getName());
        gericht.setPreis(neueDaten.getPreis());
        return gerichtRepository.save(gericht);
    }

    @DeleteMapping("/{id}")
    public void gerichtLoeschen(@PathVariable Long id) {
        gerichtRepository.deleteById(id);
    }
}
