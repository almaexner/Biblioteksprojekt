import java.time.LocalDate;
import java.util.List;

public class TestDoubleLoanPolicy implements LoanPolicy{

    @Override
    public boolean canLoan(Resource resource, List<Loan> memberLoanList) {
        return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowedDate, Resource resource) {
        return LocalDate.now();
    }
}
