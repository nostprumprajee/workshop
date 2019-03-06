package toystore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import toystore.domain.Hello;

@RestController
public class HelloController {

    @GetMapping("/hello/{name}")
    public Hello sayHi(@PathVariable(name = "") String name) {
        Hello hello = new Hello(String.format("Hello %s", name));
        return hello;
    }
}
