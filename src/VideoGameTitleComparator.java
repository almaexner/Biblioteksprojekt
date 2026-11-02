import java.util.Comparator;

public class VideoGameTitleComparator implements Comparator<VideoGame> {

    @Override
    public int compare(VideoGame videoGame1, VideoGame videoGame2) {
        return videoGame1.getTitle().compareTo(videoGame2.getTitle());
    }
}
