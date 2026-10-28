import java.time.LocalDate;
import java.util.ArrayList;

public class AalborgLoanPolicy implements LoanPolicy {

    @Override
    public boolean canLoan(Resource resource, ArrayList<Loan> memberLoanList) {
        if (!(resource instanceof Movie || resource instanceof VideoGame)){
            return true;
        }
        int nrOfMovies = 0;
        int nrOfVideoGames = 0;

        for(Loan loan : memberLoanList){
            if(loan.getResource() instanceof Movie){
                nrOfMovies++;
            }
            if (loan.getResource() instanceof VideoGame){
                nrOfVideoGames++;
            }
        } if (nrOfMovies >= 3 || nrOfVideoGames >= 3){
            return false;
        }return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowedDate, Resource resource) {
        if (borrowedDate != null) {
            return borrowedDate.plusDays(30);
        }
        return null;
    }

}
