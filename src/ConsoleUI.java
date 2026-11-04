import java.text.Collator;
import java.util.List;
import java.util.Locale;

public class ConsoleUI {
    private final Library library;
    private final Collator collator = Collator.getInstance(new Locale("da"));

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
                case 2 -> returnResource();
                case 3 -> showLoans();
                case 4 -> createUser();
                case 5 -> displayMembers();
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
                "4. Opret Ny Bruger \n" +
                "5. Vis alle brugere \n" +
                "6. Vis alle Resourcer \n" +
                "0. Afslut \n");
    }

    private void borrowResource() {
        displayResources();
        int memberId = Integer.parseInt(IO.readln("Indtast memberID: "));
        String identifier = IO.readln("Indtast materialets ID: ");
        AttemptLoan loanAttempt = library.loanResource(memberId, identifier);
        Member member = library.getMember(memberId);
        Resource resource = library.getResource(identifier);
        switch (loanAttempt) {
            case RES_NOT_FOUND -> IO.println("Not found");
            case USER_NOT_FOUND -> IO.println("This user does not exist");
            case RES_NOT_AVAIL -> IO.println(resource.getTitle() + " is not currently available");
            case RES_LOAN_SUCCESS -> IO.println(resource.getTitle() + " has be registered as a loan to " + member.getName());
            case NOT_PERMITTED -> IO.println("Du overskrider lånereglen.");
        }
    }

    private void returnResource() {
        String identifier = IO.readln("Indtast materialets ID: ");
        boolean succesReturn = library.returnResource(identifier);

        IO.println(succesReturn ? "Materialet er nu returneret" : "Materialet kunne ikke returneres");
    }

    private void showLoans() {
        int memberId = Integer.parseInt(IO.readln("Indtast memberID: "));
        List<Loan> memberLoans = library.findLoansByMemberId(memberId);
        for (Loan loan : memberLoans) {
            IO.println(loan);
        }
    }

    public void createUser() {
        String usrName = IO.readln("New Username: ");
        int membId = Integer.parseInt(IO.readln("New userID: "));

        if(library.getMember(membId) != null){ // This is a naive solution and makes other members vulnerable towards a malicious person using their userID to loan or return books. But it is better than users overlaying eachother.
            IO.println("userID already in use");
            return;
        }

        Member member = new Member(usrName, membId);
        library.addMember(member);
    }

    public void displayMembers() { //Metode til at printe members fra memberList
        for (Member member : library.getMemberList()) {
            IO.println(member.getId()+ ", " + member.getId());
        }
    }

    public void displayResources() { //Metode til at printe members fra memberList
        for (Resource resource : library.getResourceList()) {
            IO.println(resource.getCreator()+ ", " + resource.getTitle()+ ", "+ resource.getIdentifier());
        }
    }
}
