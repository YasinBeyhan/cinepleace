package htw.berlin.filmfinder;

import htw.berlin.filmfinder.film.Watchlist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CommonControllerTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void wrongUrlTest() throws  Exception {
        Watchlist tmpWatchlist = new Watchlist(0,"Movie for Test");

        mvc.perform(MockMvcRequestBuilders.post("/sdad")
                .param("ID", ""+tmpWatchlist.getWatchlist_id())
                .param("name", tmpWatchlist.getName())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isMethodNotAllowed());
    }

    // Comment
    // Comment 2
    // Comment 3
}
