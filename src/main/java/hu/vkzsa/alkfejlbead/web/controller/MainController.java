package hu.vkzsa.alkfejlbead.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MainController {
    @RequestMapping("/")
    public String index() {
        return "Index oldal";
    }
}