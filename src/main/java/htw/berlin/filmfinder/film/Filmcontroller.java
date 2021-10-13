package htw.berlin.filmfinder.film;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Filmcontroller {

    private final FilmService filmService;
    @Autowired
    public Filmcontroller(FilmService filmService) {
        this.filmService = filmService;
    }



//    @GetMapping(path=Endpoints.Rest.MOVIES)
//    public List<Film> getFilme() {
//        return filmService.getFilme();
//    }

    @PostMapping(path=Endpoints.Rest.MOVIES_ADD)
    public void RegisterNewFilm(@RequestBody Film film){
        filmService.addNewFilm(film);
        }

//    @DeleteMapping(path = Endpoints.Rest.MOVIES_DELETE)
//    public void deleteStudent(@PathVariable("film_id") int film_id) {
//        filmService.deleteFilm(film_id);
//    }
//    }



    @RequestMapping("/addfilme")
    @GetMapping
    public List<Film> getFilme() {
    return filmService.getFilme();
    }

    @PostMapping
    public void registerNewFIlm(@RequestBody Film film) {
        filmService.addNewFilm(film);
    }

    @DeleteMapping(path = "{film_id}")
    public void deleteStudent(@PathVariable("film_id") int film_id) {
        filmService.deleteFilm(film_id);
    }
}


