import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StandardLoanPolicyTest {
    Resource resource;
    ArrayList<Loan> memberloanlist;

    @Test
    void canLoanTest(){
        //Arrange
        StandardLoanPolicy policy = new StandardLoanPolicy();
        //Act
        boolean result = policy.canLoan(resource, memberloanlist);
        //Assert
        assertTrue(result);
    }

    @Test
    void calculateDueDateTest(){
        //Arrange
        StandardLoanPolicy policy = new StandardLoanPolicy();
        LocalDate borrowedDate = LocalDate.now();
        //Act
        LocalDate dueDate = policy.calculateDueDate(borrowedDate, resource);
        //Assert
        assertEquals(borrowedDate.plusDays(30), dueDate);
    }
}