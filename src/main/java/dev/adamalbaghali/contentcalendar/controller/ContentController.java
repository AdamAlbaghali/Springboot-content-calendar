package dev.adamalbaghali.contentcalendar.controller;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findByID(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
    }

    //posting a request to api/content
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content){
        repository.save(content);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        repository.save(content);
    }
    
}

