import java.util.ArrayList;

public class ConsoleUI {
    private final Library library;

    public ConsoleUI(Library library) {
        this.library = library;
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            int userInput = Integer.parseInt(IO.readln("Indtast dit valg:"));
            switch (userInput) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> showLoans();
                case 0 -> isRunning = false;
                default -> IO.println("Ugyldigt input. Prøv igen.");
            }
        }
    }

    private void showMenu() {
        IO.println("\nBIBLIOTEKS MENU\n" +
                "1. Lån \n" +
                "2. Aflever \n" +
                "3. Vis alle lån \n" +
                "0. Afslut \n");
    }

    private void borrowBook() {
        int memberId = Integer.parseInt(IO.readln("Indtast memberID: "));
        int bookId = Integer.parseInt(IO.readln("Indtast bogens ID: "));
        AttemptLoan loanAttempt = library.loanBook(memberId, bookId);
            switch (loanAttempt){
                case RES_NOT_FOUND -> IO.println("Not found");
                case USER_NOT_FOUND ->  IO.println("This user does not exist");
                case RES_NOT_AVAIL -> IO.println(bookId + "is not currently available");
                case RES_LOAN_SUCCESS ->  IO.println(bookId + "has be registered as a loan to " + memberId);
            }
    }

    private void returnBook() {
        int bookId = Integer.parseInt(IO.readln("Indtast bogens ID: "));
        boolean succesReturn = library.returnBook(bookId);

        IO.println(succesReturn ? "Bogen er nu returneret" : "Bogen kunne ikke returneres");
    }

    private void showLoans() {
        int memberId = Integer.parseInt(IO.readln("Indtast memberID: "));
        ArrayList<Loan> memberLoans = library.findLoansByMemberId(memberId);
        for (Loan loan : memberLoans) {
            IO.println(loan);
        }
    }
}
