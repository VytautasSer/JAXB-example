package pojo;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Movie {

    Movie() {
    }

    public Movie(String id, String title, List<String> actors, Genre genre) {
        this.id = id;
        this.title = title;
        this.actors = actors;
        this.genre = genre;
    }

    @XmlAttribute(name = "id")
    private String id;
    private String title;

    @XmlElementWrapper(name = "actors")
    @XmlElement(name = "actor")
    private List<String> actors;
    private Genre genre;

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", actors=" + actors +
                ", genre=" + genre +
                '}';
    }
}
