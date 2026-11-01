public class Movie extends Resource {
    private String instructor;
    private int lengthMin;

    public Movie (String id, String creator, String title, String instructor, int lengthMin) {
        super(id, creator, title);
        this.instructor = instructor;
        this.lengthMin = lengthMin;
    }

    public String getInstructor(){
        return instructor;
    }

    public int getLengthMin(){
        return lengthMin;
    }
}
