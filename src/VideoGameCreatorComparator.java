import java.util.Comparator;

public class VideoGameCreatorComparator implements Comparator<VideoGame> {

    @Override
    public int compare(VideoGame videoGame1, VideoGame videoGame2) {
        return videoGame1.getCreator().compareTo(videoGame2.getCreator());
    }
}
