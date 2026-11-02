import java.util.Comparator;

public class MovieInstructorComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie movie1, Movie movie2) {
        return movie1.getInstructor().compareTo(movie2.getInstructor());
    }
}
