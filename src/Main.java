void main() throws IOException {

    LoanPolicy loanPolicy = new StandardLoanPolicy();
    Library library = new Library(loanPolicy);
    ConsoleUI consoleUI = new ConsoleUI(library);

    Book book1 = new Book("101", "Allan B. Downey", "Think Java", 120);
    Book book2 = new Book("102", "J.K. Rowling", "Harry Potter and the philosophers stone", 317);
    Book book3 = new Book("103", "Paulo Coelho", "The alchemist", 274);

    Member member1 = new Member("Alma Exner", 10);
    Member member2 = new Member("Hans Hansen", 11);
    Member member3 = new Member("Jens Jensen", 12);

    library.addResource(book1);
    library.addResource(book2);
    library.addResource(book3);

    library.addMember(member1);
    library.addMember(member2);
    library.addMember(member3);

    Path path = Path.of("loans.csv");
    CsvMapper mapper = new CsvMapper();
    FileHandler handler = new FileHandler(path, mapper);

    handler.saveMember(library.getMemberList());
    for (Member member : handler.loadMembers()) {
        IO.println(member);
    }

    HashMap<String, Book> bookMap = new HashMap<>();
    bookMap.put("101", book1);
    IO.println(bookMap.get("101"));

    consoleUI.run();
}