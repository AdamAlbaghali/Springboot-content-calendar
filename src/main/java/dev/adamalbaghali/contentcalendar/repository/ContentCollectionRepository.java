package dev.adamalbaghali.contentcalendar.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.adamalbaghali.contentcalendar.model.Content;
import dev.adamalbaghali.contentcalendar.model.Status;
import dev.adamalbaghali.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;




@Repository
public class ContentCollectionRepository {

    private final List<Content> content = new ArrayList<>();

    public ContentCollectionRepository(){


    }
    
    public List<Content> findAll(){
        return content;
    }

    public Optional<Content> findByID(Integer id){
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    @PostConstruct
    private void init(){
        Content c = new Content( 1 , "My First blog post", 
        "My First blog post", Status.IDEA , 
        Type.ARTICLE, LocalDateTime.now(), null, "");

        content.add(c);
    }
}
