package htw.berlin.filmfinder.film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
@Repository
@Transactional("watchListTransactionManager")
public interface WatchlistRepository
        extends JpaRepository<Watchlist, Integer> {

    @PersistenceContext
    private EntityManager entityManager;
}*/
@Repository
public class WatchlistRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public ArrayList<Watchlist> getAllWatchlistMovies() {
        ArrayList<Watchlist> watchList = new ArrayList<Watchlist>();
        Query q = entityManager.createNativeQuery("SELECT watchlist_id, name FROM WATCHLIST");
        List<Object[]> tmpWatchlist = q.getResultList();
        for (Object[] a : tmpWatchlist) {
            Watchlist tmpWatchList = new Watchlist(Integer.valueOf(a[0]+""),a[1]+"");
            watchList.add(tmpWatchList);
        }

        return watchList;
    }

    @Transactional
    public void insertWithQuery(Watchlist watchlist) {
        // For test-purposes ID = 0 is used
        if (watchlist.getWatchlist_id() == 0) {
            entityManager.createNativeQuery("INSERT INTO WATCHLIST (watchlist_id, name) VALUES (?,?)")
                    .setParameter(1, watchlist.getWatchlist_id())
                    .setParameter(2, watchlist.getName())
                    .executeUpdate();
        }
        else {
            entityManager.createNativeQuery("INSERT INTO WATCHLIST (watchlist_id, name) VALUES (idwatchlist.nextval,?)")
                    .setParameter(1, watchlist.getName())
                    .executeUpdate();
        }
    }

    @Transactional
    public void removeWithQuery(Watchlist watchlist) {
        entityManager.createNativeQuery("DELETE FROM WATCHLIST WHERE watchlist_id = ?")
                .setParameter(1, watchlist.getWatchlist_id())
                .executeUpdate();
    }
}