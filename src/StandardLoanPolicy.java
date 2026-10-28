import java.time.LocalDate;
import java.util.ArrayList;

public class StandardLoanPolicy implements LoanPolicy{
    @Override
    public boolean canLoan(Resource resource, ArrayList<Loan> memberLoanList) {

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
