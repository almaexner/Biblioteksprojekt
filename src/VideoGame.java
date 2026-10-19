public class VideoGame extends Resource {
    final String platform;

    public VideoGame (String studio, String title, String EAN, String platform) {
        super(studio, title, EAN);
        this.platform = platform;
    }

    public String getStudio(){
        return creator;
    }

    public String getEAN(){
        return identifier;
    }
}
