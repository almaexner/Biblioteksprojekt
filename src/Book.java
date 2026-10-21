import java.util.Objects;

public class Book extends Resource{
    final int id; //Skal denne være med? Var med i første biblo projekt, men skal den være med i dette?
    final int pages;

    public Book(String author, String title, String isbn, int id, int pages) {
        super(author, title, isbn);
        this.id = id;
        this.pages = pages;
    }

    public String getAuthor() {
        return creator;
    }

    public String getIsbn() {
        return identifier;
    }

    @Override
    public String toString() {
        return getAuthor() + "; " + title + "; " + getIsbn() + id;
    }

    @Override
    public boolean equals(Object otherObj){
        if (otherObj == null || getClass() != otherObj.getClass()) return false;
        Book book = (Book) otherObj;
        return Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(title, book.title) && Objects.equals(getIsbn(), book.getIsbn()) && id == book.id;
    }
}

