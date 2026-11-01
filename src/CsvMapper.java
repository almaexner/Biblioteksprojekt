public class CsvMapper {
    private String delimiter = ",";

    public Member csvToMember(String line) {
        String[] tokens = line.split(delimiter, -1);
        String name = tokens[0];
        int id = Integer.parseInt(tokens[1]);

        return new Member(name, id);
    }

    public String memberToCsv(Member member) {
        return member.getName()
                + delimiter + member.getID();
    }

    public Book csvToBook(String line) {
        String[] tokens = line.split(delimiter, -1);
        String id = tokens[0];
        String creator = tokens[1];
        String title = tokens[2];
        int pages = Integer.parseInt(tokens[3]);

        return new Book(id, creator, title, pages);
    }

    public String bookToCsv(Book book) {
        return book.getIdentifier()
                + delimiter + book.getCreator()
                + delimiter + book.getTitle()
                + delimiter + book.getPages();
    }

    public AudioBook csvToAudioBook(String line){
        String[] tokens = line.split(delimiter, -1);
        String id = tokens[0];
        String creator = tokens[1];
        String title = tokens[2];
        int lengthMin = Integer.parseInt(tokens[3]);

        return new AudioBook(id, creator, title, lengthMin);
    }

    public String audioBookToCsv(AudioBook audioBook){
        return audioBook.getIdentifier()
                + delimiter + audioBook.getCreator()
                + delimiter + audioBook.getTitle()
                + delimiter + audioBook.getLengthMin();
    }

    public Movie csvToMovie(String line) {
        String[] tokens = line.split(delimiter, -1);
        String id = tokens[0];
        String creator = tokens[1];
        String title = tokens[2];
        String instructor = tokens[3];
        int lengthMin = Integer.parseInt(tokens[4]);

        return new Movie(id, creator, title, instructor, lengthMin);
    }

    public String movieToCsv(Movie movie) {
        return movie.getIdentifier()
                + delimiter + movie.getCreator()
                + delimiter + movie.getTitle()
                + delimiter + movie.getInstructor()
                + delimiter + movie.getLengthMin();
    }

    public VideoGame csvToVideoGame(String line){
        String[] tokens = line.split(delimiter, -1);
        String id = tokens[0];
        String creator = tokens[1];
        String title = tokens[2];
        String platform = tokens[3];

        return new VideoGame(id, creator, title, platform);
    }

    public String videoGameToCsv(VideoGame videoGame){
        return videoGame.getIdentifier()
                + delimiter + videoGame.getCreator()
                + delimiter + videoGame.getTitle()
                + delimiter + videoGame.getPlatform();
    }
}

