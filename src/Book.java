import java.util.Objects;

public class Book extends Resource {
    private int pages;

    public Book(String id, String creator, String title, int pages) {
        super(id, creator, title);
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return getIdentifier() + ", " + getCreator() + "; " + getTitle() + "; " + "nr. of pages: " + getPages();
    }

    @Override
    public boolean equals(Object otherObj) {
        if (otherObj == null || getClass() != otherObj.getClass()) return false;
        Book book = (Book) otherObj;
        return Objects.equals(getCreator(), book.getCreator()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getIdentifier(), book.getIdentifier());
    }
}

