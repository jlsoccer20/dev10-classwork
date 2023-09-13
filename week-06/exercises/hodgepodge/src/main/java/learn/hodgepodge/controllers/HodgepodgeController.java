package learn.hodgepodge.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HodgepodgeController {

    @GetMapping("/name")
    public String home() {
        return "your name (String)";
    }
}
