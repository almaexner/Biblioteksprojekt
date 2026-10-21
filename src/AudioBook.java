public class AudioBook extends Resource{
    final int lengthMin;

    public AudioBook(String author, String title, String isbn, int lengthMin) {
        super(author, title, isbn);
        this.lengthMin = lengthMin;
    }

    public String getAuthor(){
        return creator;
    }

    public String getIsbn(){
        return identifier;
    }
}
