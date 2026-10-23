public class VideoGame extends Resource {
    final String platform;

    public VideoGame (String creator, String title, String identifier, String platform) {
        super(creator, title, identifier);
        this.platform = platform;
    }
}
