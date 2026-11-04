public class VideoGame extends Resource {
    private final String platform;

    public VideoGame(String id, String creator, String title, String platform) {
        super(creator, title, id);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }
}
