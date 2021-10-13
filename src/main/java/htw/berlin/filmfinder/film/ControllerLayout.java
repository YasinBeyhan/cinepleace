package htw.berlin.filmfinder.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ControllerLayout {
    @Autowired
    private FilmService filmService;

    @GetMapping("layout")

    String getTemp(Model model){
        List<Film> meinefilme=filmService.getFilme();
        model .addAttribute("something", "this is coming");
        model .addAttribute("test", meinefilme);

        return "Frontend/layout";
    }



}