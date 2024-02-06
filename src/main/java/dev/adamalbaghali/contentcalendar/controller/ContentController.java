package dev.adamalbaghali.contentcalendar.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.adamalbaghali.contentcalendar.repository.ContentCollectionRepository;
import jakarta.annotation.PostConstruct;
import dev.adamalbaghali.contentcalendar.model.Content;
import dev.adamalbaghali.contentcalendar.model.Status;
import dev.adamalbaghali.contentcalendar.model.Type;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    
    // make a request and find all the pieces of content in the system
    @GetMapping()
    public List<Content> findAll(){
        return repository.findAll();
    }


}
