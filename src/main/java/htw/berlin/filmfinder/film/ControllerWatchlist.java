package htw.berlin.filmfinder.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerWatchlist {

    @Autowired
    WatchlistService watchlistService;

    @PostMapping(path = "/addToWatchlist")
    public ResponseEntity addToWatchlist(@RequestParam(name = "ID") int watchlist_id,
                                  @RequestParam(name = "name") String name) {
        Watchlist watchlist = new Watchlist(watchlist_id, name);
        try {

            watchlistService.addToWatchlist(watchlist);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(path = "/getFullWatchlist")
    public ResponseEntity getAllWatchlistMovies() {
        String returnCode = "<div>";
        try {
           ArrayList<Watchlist> list = watchlistService.getAllWatchlistMovies();
           for (int i = 0; i < list.size(); ++i) {
                returnCode += "<div id='movie_"+list.get(i).getWatchlist_id()+"'>"+list.get(i).getName()+"</div>";
           }
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        returnCode += "</div>";
        return new ResponseEntity<>(returnCode,HttpStatus.OK);
    }
}
