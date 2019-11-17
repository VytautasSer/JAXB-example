package jaxb;

import org.junit.Test;
import pojo.Movies;

public class MarshallerTest {

    @Test
    public void unmarshallXmlFile() {
        Movies movies = Marshaller.parseXmlFile(".\\src\\main\\resources\\movies.xml", Movies.class);
        movies.getMovies().stream().forEach(System.out::println);
    }
}