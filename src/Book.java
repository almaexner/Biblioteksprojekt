import java.util.Objects;

public class Book extends Resource{
    final int pages;

    public Book(String creator, String title, String identifier, int pages) {
        super(creator, title, identifier);
        this.pages = pages;
    }

    @Override
    public String toString() {
        return creator + "; " + title + "; " + identifier;
    }

    @Override
    public boolean equals(Object otherObj){
        if (otherObj == null || getClass() != otherObj.getClass()) return false;
        Book book = (Book) otherObj;
        return Objects.equals(creator, book.creator) && Objects.equals(title, book.title) && Objects.equals(identifier, book.identifier);
    }
}

