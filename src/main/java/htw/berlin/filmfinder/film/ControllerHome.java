package htw.berlin.filmfinder.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerHome {

    @Autowired
    FilmService filmService;

    @GetMapping("home")
    String getTemp(Model model) {
        model.addAttribute("home", "Filmfinder");


        return "Frontend/Homepage";


    }

    @GetMapping(path = "star")
    public String showabc(Model model) {
        return "Frontend/index";
    }

    @GetMapping(path = "rate")
    public String ratingtest(Model model) {
        return "Frontend/bewertung";
    }

    @GetMapping(path = "beschreibung")
    public String testa(Model model) {
        return "Frontend/beschreibung";
    }



    @PostMapping(path = "/addFilm")
    public ResponseEntity addFilm(@RequestParam(name = "ID") int film_id,
                                    @RequestParam(name = "name") String bezeichnung,
                                  @RequestParam(name = "genre") String genre,
                                  @RequestParam(name = "erscheinungsJahr") String erscheinungsjahr,
                                  @RequestParam(name = "bildUrl") String bildUrl) {
        System.out.println(bezeichnung + genre + erscheinungsjahr + bildUrl);
        Film film = new Film();
        film.setFilm_id(film_id);
        film.setBild_url(bildUrl);
        film.setErscheinungsjahr(Long.parseLong(erscheinungsjahr));
        film.setBezeichnung(bezeichnung);
        film.setGenre(genre);
        try {
            filmService.addNewFilm(film);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
