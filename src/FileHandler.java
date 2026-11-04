import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private Path path;
    private CsvMapper mapper;

    public FileHandler(Path path, CsvMapper mapper) {
        this.path = path;
        this.mapper = mapper;
    }

    // SAVERS
    public void saveMember(List<Member> memberList) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (Member member : memberList) {
                String line = mapper.memberToCsv(member);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }

    public void saveBook(List<Book> bookList) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (Book book : bookList) {
                String line = mapper.bookToCsv(book);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }

    public void saveAudioBook(List<AudioBook> audioBookList) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (AudioBook audioBook : audioBookList) {
                String line = mapper.audioBookToCsv(audioBook);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }

    public void saveMovie(List<Movie> movieList) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (Movie movie : movieList) {
                String line = mapper.movieToCsv(movie);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }

    public void saveVideoGame(List<VideoGame> videoGameList) throws IOException {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (VideoGame videoGame : videoGameList) {
                String line = mapper.videoGameToCsv(videoGame);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }

    public void saveLoan (List < Loan > loanList) throws IOException{
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)){
            for (Loan loan : loanList) {
                String line = mapper.loanToCsv(loan);
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }

    public List<Loan> loadLoans(Library library) throws IOException {
        List<Loan> loans = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Loan loan = mapper.csvToLoan(line, library);
                loans.add(loan);
            }
        }
        return loans;
    }


    // LOADERS
    public List<Member> loadMembers() throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            List<Member> members = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                members.add(mapper.csvToMember(line));
            }
            return members;
        }
    }

    public List<Book> loadBook() throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            List<Book> books = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // I will make this glorious later!
                books.add(mapper.csvToBook(line));
            }
            return books;
        }
    }

    public List<AudioBook> loadAudioBook() throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            List<AudioBook> audioBooks = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                audioBooks.add(mapper.csvToAudioBook(line));
            }
            return audioBooks;
        }
    }

    public List<Movie> loadMovie() throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            List<Movie> movies = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // I will make this glorious later!
                movies.add(mapper.csvToMovie(line));
            }
            return movies;
        }
    }

    public List<VideoGame> loadVideoGame() throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            List<VideoGame> videoGames = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                videoGames.add(mapper.csvToVideoGame(line));
            }
            return videoGames;
        }
    }

    public List<Loan> loadLoan(Library library) throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            List<Loan> loans = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                loans.add(mapper.csvToLoan(line, library));
            }
            return loans;
        }
    }
}


