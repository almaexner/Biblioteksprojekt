import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private final ArrayList<Resource> resourceList = new ArrayList<>();
    private final ArrayList<Member> memberList = new ArrayList<>();
    private final ArrayList<Loan> loanList = new ArrayList<>();
    LoanPolicy loanPolicy;

    public Library(LoanPolicy loanPolicy) {
        this.loanPolicy = loanPolicy;
    }

    public void addResource(Resource resource) { //Metode til at tilføje resources i resourceList ArrayListen
        resourceList.add(resource);
    }

    public void addMember(Member member) { //Metode til at tilføje medlemmer i memberList ArrayListen
        memberList.add(member);
    }

    public void addLoan(Loan loan) { //Metode til at tilføje lån i loanList ArrayListen
        loanList.add(loan); 
    }

    public Member getMember(int memberId) { //Metode til at finde medlemmer i ArrayListen for medlemmer med brug af memberId
        for (Member member : memberList) {
            if (member.getID() == memberId) {
                return member;
            }
        }
        return null;
    }

    public Resource getResource(String identifier) { //Metode til at finde resources i resourceList med identifier
        for (Resource resource : resourceList) {
            if (resource.identifier.equals(identifier)) {
                return resource;
            }
        }
        return null;
    }

    public Loan getLoan(String identifier) {
        for (Loan loan : loanList) {
            if (loan.getResource().identifier.equals(identifier)) {
                return loan;
            }
        }
        return null;

    }

    public LocalDate getDueDate(LocalDate borrowedDate, Resource resource) {
        return loanPolicy.calculateDueDate(borrowedDate, resource);

    }

    public void printBooks() { //Metode til at printe resources fra resourceList
        for (int i = 0; i < resourceList.size(); i++) {
            IO.println(resourceList.get(i));
        }
    }

    public void printMembers() { //Metode til at printe members fra memberList
        for (int i = 0; i < memberList.size(); i++) {
            IO.println(memberList.get(i));
        }
    }

    public AttemptLoan loanResource(int memberId, String identifier) { //Metode til at låne en resource, hvis både medlem og resource er oprrettet i ArrayListerne
        // og resourcen ikke er på låne listen i forvejen.
        Member member = getMember(memberId);
        if (member == null) {
            return AttemptLoan.USER_NOT_FOUND;
        }
        Resource resource = getResource(identifier);
        if (resource == null) {
            return AttemptLoan.RES_NOT_FOUND;
        }

        Loan loan = getLoan(identifier);
        if (loan != null) {
            return AttemptLoan.RES_NOT_AVAIL;
        }
        if (!loanPolicy.canLoan(resource, loanList)) {
            return AttemptLoan.NOT_PERMITTED;
        }

        LocalDate borrowedDate = LocalDate.now();
        LocalDate dueDate = getDueDate(borrowedDate, resource);
        loanList.add(new Loan(resource, member, borrowedDate, dueDate));
        return AttemptLoan.RES_LOAN_SUCCESS;
    }


    public boolean returnResource(String identifier) { //Metode til at fjerne en resource fra loanList
        Loan loan = getLoan(identifier);
        if (loan == null) {
            return false;
        }
        loanList.remove(loan);
        return true;
    }

    public ArrayList<Loan> findLoansByMemberId(int memberId) { //Metode til at finde hvilke lån et medlem har.
        ArrayList<Loan> foundLoans = new ArrayList<>();

        for (Loan loan : loanList) {
            if (loan.getMember().getID() == memberId) {
                foundLoans.add(loan);
            }
        }
        return foundLoans;
    }
}
