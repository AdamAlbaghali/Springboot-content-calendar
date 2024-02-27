package dev.adamalbaghali.contentcalendar.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    
    @GetMapping("/")
    public String home(){
        return null;
    }
}
