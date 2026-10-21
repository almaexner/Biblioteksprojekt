public class Movie extends Resource {
    final String instructor;
    final int lengthMin;

    public Movie (String studio, String title, String EAN, String instructor, int lengthMin) {
        super(studio, title, EAN);
        this.instructor = instructor;
        this.lengthMin = lengthMin;

    }

    public String getStudio() {
        return creator;
    }

    public String getEAN(){
        return identifier;
    }

}
