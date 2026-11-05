import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileNotFoundException;

void main() throws IOException {
    LoanPolicy loanPolicy = new StandardLoanPolicy();
    Library library = new Library(loanPolicy);
    CsvMapper mapper = new CsvMapper();

    // Will create CSV files if missing or first time running program, otherwise nothing.
    createFileIfNotExists(Path.of("members.csv"));
    createFileIfNotExists(Path.of("books.csv"));
    createFileIfNotExists(Path.of("audioBooks.csv"));
    createFileIfNotExists(Path.of("movies.csv"));
    createFileIfNotExists(Path.of("videoGames.csv"));
    createFileIfNotExists(Path.of("loans.csv"));

    FileHandler memberFile = new FileHandler(Path.of("members.csv"), mapper);
    FileHandler bookFile = new FileHandler(Path.of("books.csv"), mapper);
    FileHandler audioBookFile = new FileHandler(Path.of("audioBooks.csv"), mapper);
    FileHandler movieFile = new FileHandler(Path.of("movies.csv"), mapper);
    FileHandler videoGameFile = new FileHandler(Path.of("videoGames.csv"), mapper);
    FileHandler loanFile = new FileHandler(Path.of("loans.csv"), mapper);

    // A Rough way to do it. Would rather just use relative position from a main path.

    //Loader alle lister ved programmets start
    for (Member member : memberFile.loadMembers()) {
        library.addMember(member);
    }

    for (Book book : bookFile.loadBook()) {
        library.addResource(book);
    }

    for (AudioBook audioBook : audioBookFile.loadAudioBook()) {
        library.addResource(audioBook);
    }

    for (Movie movie : movieFile.loadMovie()) {
        library.addResource(movie);
    }

    for (VideoGame videoGame : videoGameFile.loadVideoGame()) {
        library.addResource(videoGame);
    }

    for (Loan loan : loanFile.loadLoan(library)) {
        library.loanResource(loan.getMember().getId(), loan.getResource().getIdentifier());
    }
    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.run();
}

public void createFileIfNotExists(Path path) throws IOException {
    if (!Files.exists(path)) {
        Files.createFile(path);
        IO.println("Oprettede fil: " + path);
    }

    memberFile.saveMember(library.getMemberList());
    loanFile.saveLoan(library.getLoanList());
    IO.println("Saved");
}