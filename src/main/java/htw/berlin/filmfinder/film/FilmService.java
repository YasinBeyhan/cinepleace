package htw.berlin.filmfinder.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FilmService {

    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getFilme() {

        return filmRepository.findAll();
    }

    public void addNewFilm(Film film) {

        Optional<Film> filmOptional = filmRepository.findFilmByBezeichnung(film.getBezeichnung());

        if (filmOptional.isPresent()) {
            throw new IllegalStateException("Film bereits in der Datenbank");
        }

        if(filmOptional.isPresent()) {
            throw new IllegalStateException("Film bereits in der Datenbank");
        }

        filmRepository.insertFilm(film.getFilm_id(), film.getBezeichnung(), film.getGenre(), film.getErscheinungsjahr(), film.getBild_url());
    }

    public void deleteFilm(int film_id) {
        boolean exists = filmRepository.existsById(film_id);
        if (!exists) {
            throw new IllegalStateException("film with id " + film_id + " dies not exists");
        }
        filmRepository.deleteFilm(film_id);
        //filmRepository.deleteById(film_id);
    }




}

