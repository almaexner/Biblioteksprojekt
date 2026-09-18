public record Book(String author, String title, String isbn, int id) {
    @Override
    public String toString() {
        return author + "; " + title + "; " + isbn + id;
    }
}

