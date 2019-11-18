package jaxb;

import org.junit.Test;
import pojo.Genre;
import pojo.Movie;
import pojo.Movies;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertTrue;

public class JaxbTest {

    @Test
    public void unmarshalXmlFile() {
        Movies movies = Jaxb.parseXmlFile("./src/main/resources/movies.xml", Movies.class);
        movies.getMovies().stream().forEach(System.out::println);

        assertTrue(movies.getMovies().size() == 2);
    }

    @Test
    public void serializeAndUnmarshal() {
        Movies moviesToSerialize = new Movies(
                asList(
                        new Movie("0", "new world", asList("Duke", "Jake"), Genre.ACTION),
                        new Movie("1", "GIT down", asList("John", "Patrik"), Genre.HORROR)
                )
        );
        Jaxb.serializeToXmlFile(moviesToSerialize, "test.xml");

        Movies movies = Jaxb.parseXmlFile("./src/main/resources/test.xml", Movies.class);
        movies.getMovies().stream().forEach(System.out::println);

        assertTrue(movies.getMovies().size() == 2);
    }
}