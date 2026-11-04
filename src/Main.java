void main(String[] args) throws IOException {
    LoanPolicy loanPolicy = new StandardLoanPolicy();
    Library library = new Library(loanPolicy);
    CsvMapper mapper = new CsvMapper();

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
        library.addLoan(loan);
    }
    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.run();

    memberFile.saveMember(library.getMemberList());
    loanFile.saveLoan(library.getLoanList());
    IO.println("Saved");
}