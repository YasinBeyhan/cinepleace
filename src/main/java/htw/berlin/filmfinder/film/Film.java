package htw.berlin.filmfinder.film;


import javax.persistence.*;

@Entity
@Table
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;
    private String bezeichnung;
    private String genre;
    private Long erscheinungsjahr;
    private String bild_url;


    public Film(int film_id, String bezeichnung, String genre, Long erscheinungsjahr, String bild_url) {
        this.film_id = film_id;
        this.bezeichnung = bezeichnung;
        this.genre = genre;
        this.erscheinungsjahr = erscheinungsjahr;
        this.bild_url = bild_url;


    }

    public Film(String bezeichnung, String genre) {
        this.bezeichnung = bezeichnung;
        this.genre = genre;
    }

    public Film() {

    }


    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public long getErscheinungsjahr(){ return erscheinungsjahr;}

    public void setErscheinungsjahr(long erscheinungsjahr) {this.erscheinungsjahr = erscheinungsjahr;}

    public String getBild_url(){ return bild_url;}

    public void setBild_url(String bild_url) {this.bild_url = bild_url;}
}
