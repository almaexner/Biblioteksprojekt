import java.time.LocalDate;
import java.util.List;

public class TestDoubleCannotLoanPolicy implements LoanPolicy{

    @Override
    public boolean canLoan(Resource resource, List<Loan> memberLoanList) {
        return false;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowedDate, Resource resource) {
        return borrowedDate.plusDays(1);
    }
}
