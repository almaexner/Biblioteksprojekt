import java.util.Comparator;

public class AudioBookCreatorComparator implements Comparator<AudioBook> {

    @Override
    public int compare(AudioBook audioBook1, AudioBook audioBook2) {
        return audioBook1.getCreator().compareTo(audioBook2.getCreator());
    }
}
