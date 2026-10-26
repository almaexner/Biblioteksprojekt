import java.time.LocalDate;

public class StandardLoanPolicy implements LoanPolicy{
    @Override
    public boolean canLoan() {

        return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowedDate) {
        if (borrowedDate != null) {
            return borrowedDate.plusDays(30);
        }
        return null;
    }
}
