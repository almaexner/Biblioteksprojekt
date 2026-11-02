public class AudioBook extends Resource implements Comparable<AudioBook> {
    private final int lengthMin;

    public AudioBook(String id, String creator, String title, int lengthMin) {
        super(id, creator, title);
        this.lengthMin = lengthMin;
    }

    public int getLengthMin() {
        return lengthMin;
    }

    @Override
    public int compareTo(AudioBook otherAudioBook) {
        return this.getIdentifier().compareTo(otherAudioBook.getIdentifier());
    }
}
