package htw.berlin.filmfinder.film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface FilmRepository
        extends JpaRepository<Film, Integer> {

    @Query("SELECT s FROM Film s WHERE  s.bezeichnung = ?1")
    Optional<Film> findFilmByBezeichnung(String bezeichnung);


    Optional<Film> findByBezeichnung(String bezeichungn);

    @Modifying
    @Query(value = "INSERT INTO Film (film_id, name, genre, erscheinungsjahr, bild_url) VALUES (:id,:name,:genre,:erscheinungsjahr,:bildurl)", nativeQuery = true)
    @Transactional
    void insertFilm(@Param("id") int film_id,@Param("name") String name,@Param("genre") String genre,@Param("erscheinungsjahr") long erscheinungsJahr,@Param("bildurl") String bildUrl);

    @Modifying
    @Query(value = "DELETE FROM Film WHERE film_id=:id", nativeQuery = true)
    @Transactional
    void deleteFilm(@Param("id") int film_id);
}
