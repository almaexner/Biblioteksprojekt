import java.util.Comparator;

public class AudioBookTitleComparator implements Comparator<AudioBook> {

    @Override
    public int compare(AudioBook audioBook1, AudioBook audioBook2) {
        return audioBook1.getTitle().compareTo(audioBook2.getTitle());
    }
}
