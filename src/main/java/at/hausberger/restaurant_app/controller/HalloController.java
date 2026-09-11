package at.hausberger.restaurant_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HalloController {

    @GetMapping("/hallo")
    public String hallo() {
        return "Hallo aus Spring Boot!";
    }
}