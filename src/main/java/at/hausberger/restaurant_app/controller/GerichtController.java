package at.hausberger.restaurant_app.controller;

import at.hausberger.restaurant_app.model.Gericht;
import at.hausberger.restaurant_app.repository.GerichtRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}