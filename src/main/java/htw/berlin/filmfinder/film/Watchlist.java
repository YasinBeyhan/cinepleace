package htw.berlin.filmfinder.film;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "watchlist")
public class Watchlist implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int watchlist_id;
    private String name;


    public Watchlist(int watchlist_id, String name) {
        this.watchlist_id = watchlist_id;
        this.name = name;
    }


    @Column(name = "watchlist_id", unique = true, nullable = false)
    public int getWatchlist_id() {
        return watchlist_id;
    }

    public void setWatchlist_id(int watchlist_id) {
        this.watchlist_id = watchlist_id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
