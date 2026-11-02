public class VideoGame extends Resource implements Comparable<VideoGame> {
    private final String platform;

    public VideoGame(String id, String creator, String title, String platform) {
        super(creator, title, id);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    @Override
    public int compareTo(VideoGame otherVideoGame) {
        return this.getIdentifier().compareTo(otherVideoGame.getIdentifier());
    }
}
