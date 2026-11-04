public class AudioBook extends Resource {
    private final int lengthMin;

    public AudioBook(String id, String creator, String title, int lengthMin) {
        super(id, creator, title);
        this.lengthMin = lengthMin;
    }

    public int getLengthMin() {
        return lengthMin;
    }

    @Override
    public String toString() {
        return getIdentifier() + ", " + getCreator() + "; " + getTitle() + "; " + "lenght: " + getLengthMin() + "min";
    }
}
