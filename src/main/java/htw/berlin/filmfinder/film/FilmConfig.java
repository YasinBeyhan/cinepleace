package htw.berlin.filmfinder.film;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FilmConfig {

    @Bean
    CommandLineRunner commandLineRunner1(FilmRepository repository){
        return args -> {
          Film Kingkong = new Film(
                    "Kingkong",
                    "Monster"

            );

            Film Godzilla = new Film(
                    "Godzilla",
                    "Monster"

            );
            repository.saveAll(
                    List.of()
            );
        };

    }
}
