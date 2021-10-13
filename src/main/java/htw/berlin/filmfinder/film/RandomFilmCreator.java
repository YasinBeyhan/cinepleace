package htw.berlin.filmfinder.film;


import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.management.ObjectName;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

@Service
public class RandomFilmCreator {
    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;
    private final Random random;

    public RandomFilmCreator(ResourceLoader resourceLoader, ObjectMapper objectMapper){

        this.resourceLoader = resourceLoader;
        this.objectMapper = objectMapper;
        random = new Random();
    }

    }

