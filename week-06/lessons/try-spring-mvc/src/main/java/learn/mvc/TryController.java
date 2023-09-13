package learn.mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TryController {

    @GetMapping("/hello")
    public String home() {
        return "Hello World!<br>Beautiful day!";
    }

    @PostMapping("/greet")
    public String generateGreeting(@RequestBody String name) {
        return "Hello, " + name;
    }

    @PostMapping
    public String add(@RequestBody String value){
        return value + value;
    }

}

