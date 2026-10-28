import java.time.LocalDate;
import java.util.ArrayList;

public interface LoanPolicy {
    boolean canLoan (Resource resource, ArrayList<Loan> memberLoanList);
    LocalDate calculateDueDate(LocalDate borrowedDate, Resource resource);
}
