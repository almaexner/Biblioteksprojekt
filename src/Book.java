import java.util.Objects;

public class Book extends Resource{
    private int pages;

    public Book(String id, String creator, String title, int pages) {
        super(id, creator, title);
        this.pages = pages;
    }

    public int getPages(){
        return pages;
    }

    @Override
    public String toString() {
        return id + creator + "; " + title + "; ";
    }

    @Override
    public boolean equals(Object otherObj){
        if (otherObj == null || getClass() != otherObj.getClass()) return false;
        Book book = (Book) otherObj;
        return Objects.equals(creator, book.creator) && Objects.equals(title, book.title) && Objects.equals(id, book.id);
    }
}

