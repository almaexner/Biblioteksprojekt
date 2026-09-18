void main() {
    Library library = new Library();
    ConsoleUI consoleUI = new ConsoleUI(library);

    Book book1 = new Book("Allan B. Downey", "Think Java", "9781492072508", 1);
    Book book2 = new Book("J.K. Rowling", "Harry Potter and the philosophers stone", "9781408855652", 2);
    Book book3 = new Book("Paulo Coelho", "The alchemist", "9780008144227", 3);

    Member member1 = new Member("Alma Exner", 10);
    Member member2 = new Member("Hans Hansen", 11);
    Member member3 = new Member("Jens Jensen", 12);

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);

    library.addMember(member1);
    library.addMember(member2);
    library.addMember(member3);

    consoleUI.run();
}