public class AudioBook extends Resource{
    private int lengthMin;

    public AudioBook(String id, String creator, String title, int lengthMin) {
        super(id, creator, title);
        this.lengthMin = lengthMin;
    }

    public int getLengthMin(){
        return lengthMin;
    }
}
