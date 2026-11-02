public class Resource {
    private final String creator;
    private final String title;
    private final String id;

    public Resource(String id, String creator, String title) {
        this.creator = creator;
        this.title = title;
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public String getTitle() {
        return title;
    }

    public String getIdentifier() {
        return id;
    }
}
