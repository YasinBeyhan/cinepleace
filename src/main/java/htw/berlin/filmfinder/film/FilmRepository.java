package htw.berlin.filmfinder.film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository
        extends JpaRepository<Film, Integer> {

    @Query("SELECT s FROM Film s WHERE  s.bezeichnung = ?1")
    Optional<Film> findFilmByBezeichnung(String bezeichnung);


    Optional<Film> findByBezeichnung(String bezeichungn);

}
