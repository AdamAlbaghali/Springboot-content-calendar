package dev.adamalbaghali.contentcalendar;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import dev.adamalbaghali.contentcalendar.config.ContentCalendarProperties;
import dev.adamalbaghali.contentcalendar.model.Content;
import dev.adamalbaghali.contentcalendar.model.Status;
import dev.adamalbaghali.contentcalendar.model.Type;
import dev.adamalbaghali.contentcalendar.repository.ContentRepository;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository) {
		return args -> {
			//insert some data into the database
			 Content content = new Content( null , "Hello Github", 
        		"All about Github", Status.IDEA , 
        		Type.VIDEO, LocalDateTime.now(), null, "");
			
			repository.save(content);

		};
	}
}
