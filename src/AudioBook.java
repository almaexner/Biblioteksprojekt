public class AudioBook extends Resource{
    final int lengthMin;

    public AudioBook(String creator, String title, String identifier, int lengthMin) {
        super(creator, title, identifier);
        this.lengthMin = lengthMin;
    }
}
