public class VideoGame extends Resource {
    private final String platform;

    public VideoGame(String id, String creator, String title, String platform) {
        super(id, creator, title);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    @Override
    public String toString() {
        return getIdentifier() + ", " + getCreator() + "; " + getTitle() + "; " + getPlatform();
    }
}
