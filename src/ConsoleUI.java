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
                case 1 -> borrowResource();
                case 2 -> returnMaterial();
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

    private void borrowResource() {
        int memberId = Integer.parseInt(IO.readln("Indtast memberID: "));
        String identifier = IO.readln("Indtast materialets ID: ");
        AttemptLoan loanAttempt = library.loanResource(memberId, identifier);
        switch (loanAttempt) {
            case RES_NOT_FOUND -> IO.println("Not found");
            case USER_NOT_FOUND -> IO.println("This user does not exist");
            case RES_NOT_AVAIL -> IO.println(identifier + "is not currently available");
            case RES_LOAN_SUCCESS -> IO.println(identifier + "has be registered as a loan to " + memberId);
        }
    }

    private void returnMaterial() {
        String identifier = IO.readln("Indtast materialets ID: ");
        boolean succesReturn = library.returnResource(identifier);

        IO.println(succesReturn ? "Materialet er nu returneret" : "Materialet kunne ikke returneres");
    }

    private void showLoans() {
        int memberId = Integer.parseInt(IO.readln("Indtast memberID: "));
        ArrayList<Loan> memberLoans = library.findLoansByMemberId(memberId);
        for (Loan loan : memberLoans) {
            IO.println(loan);
        }
    }
}
