import java.util.Comparator;

public class VideoGamePlatformComparator implements Comparator<VideoGame> {

    @Override
    public int compare(VideoGame videoGame1, VideoGame videoGame2) {
        return videoGame1.getPlatform().compareTo(videoGame2.getPlatform());
    }
}
