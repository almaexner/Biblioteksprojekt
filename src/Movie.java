public class Movie extends Resource implements Comparable<Movie> {
    private final String instructor;
    private final int lengthMin;

    public Movie(String id, String creator, String title, String instructor, int lengthMin) {
        super(id, creator, title);
        this.instructor = instructor;
        this.lengthMin = lengthMin;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getLengthMin() {
        return lengthMin;
    }

    @Override
    public int compareTo(Movie otherMovie) {
        return this.getIdentifier().compareTo(otherMovie.getIdentifier());
    }
}
