package htw.berlin.filmfinder;

import com.fasterxml.jackson.databind.ObjectMapper;
import htw.berlin.filmfinder.film.Endpoints;
import htw.berlin.filmfinder.film.Watchlist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class WatchlistControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void addAndRemoveWatchlistTest() throws  Exception {
        Watchlist tmpWatchlist = new Watchlist(0,"Movie for Test");

        mvc.perform(MockMvcRequestBuilders.post("/addToWatchlist")
                .param("ID", ""+tmpWatchlist.getWatchlist_id())
                .param("name", tmpWatchlist.getName())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated());

        mvc.perform(MockMvcRequestBuilders.post("/removeFromWatchlist")
                .param("ID", ""+tmpWatchlist.getWatchlist_id())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void addWatchlistWrongParameterNamesTest() throws  Exception {
        Watchlist tmpWatchlist = new Watchlist(0,"Movie for Test");

        mvc.perform(MockMvcRequestBuilders.post("/addToWatchlist")
                .param("ID", ""+tmpWatchlist.getWatchlist_id())
                .param("names", tmpWatchlist.getName())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void addWatchlistDublicateKeyTest() throws  Exception {
        Watchlist tmpWatchlist = new Watchlist(0,"Movie for Test");

        mvc.perform(MockMvcRequestBuilders.post("/addToWatchlist")
                .param("ID", ""+tmpWatchlist.getWatchlist_id())
                .param("name", tmpWatchlist.getName())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isCreated());

        mvc.perform(MockMvcRequestBuilders.post("/addToWatchlist")
                .param("ID", ""+tmpWatchlist.getWatchlist_id())
                .param("name", tmpWatchlist.getName())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isInternalServerError());

        mvc.perform(MockMvcRequestBuilders.post("/removeFromWatchlist")
                .param("ID", ""+tmpWatchlist.getWatchlist_id())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getFullWatchlistTest() throws  Exception {
        mvc.perform(MockMvcRequestBuilders.post("/getFullWatchlist")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
