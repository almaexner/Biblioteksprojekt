public class Movie extends Resource {
    final String instructor;
    final int lengthMin;

    public Movie (String creator, String title, String identifier, String instructor, int lengthMin) {
        super(creator, title, identifier);
        this.instructor = instructor;
        this.lengthMin = lengthMin;

    }
}
