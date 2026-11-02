import java.util.Comparator;

public class MovieCreatorComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie movie1, Movie movie2) {
        return movie1.getCreator().compareTo(movie2.getCreator());
    }
}
