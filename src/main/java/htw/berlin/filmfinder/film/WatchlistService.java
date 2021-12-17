package htw.berlin.filmfinder.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class WatchlistService {

    private final WatchlistRepository watchlistRepository;

    @Autowired
    public WatchlistService(WatchlistRepository watchlistRepository) {
        this.watchlistRepository = watchlistRepository;
    }

    @Transactional
    public ArrayList<Watchlist> getAllWatchlistMovies() {

        return watchlistRepository.getAllWatchlistMovies();
    }

    @Transactional
    public void addToWatchlist(Watchlist watchlist) {

        watchlistRepository.insertWithQuery(watchlist);
    }

    @Transactional
    public void removeFromWatchlist(Watchlist watchlist) {

        watchlistRepository.removeWithQuery(watchlist);
    }
}

