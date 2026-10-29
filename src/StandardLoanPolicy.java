import java.time.LocalDate;
import java.util.List;

public class StandardLoanPolicy implements LoanPolicy{
    @Override
    public boolean canLoan(Resource resource, List<Loan> memberLoanList) {

        return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowedDate, Resource resource) {
        if (borrowedDate != null) {
            return borrowedDate.plusDays(30);
        }
        return null;
    }
}
