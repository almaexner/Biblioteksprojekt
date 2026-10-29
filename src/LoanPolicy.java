import java.time.LocalDate;
import java.util.List;

public interface LoanPolicy {
    boolean canLoan (Resource resource, List<Loan> memberLoanList);
    LocalDate calculateDueDate(LocalDate borrowedDate, Resource resource);
}
