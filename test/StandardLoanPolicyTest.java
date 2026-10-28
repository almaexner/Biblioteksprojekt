import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class StandardLoanPolicyTest {

    @Test
    void canLoanTest(){
        //Arrange
        StandardLoanPolicy policy = new StandardLoanPolicy();
        //Act
        boolean result = policy.canLoan();
        //Assert
        assertTrue(result);
    }

    @Test
    void calculateDueDateTest(){
        //Arrange
        StandardLoanPolicy policy = new StandardLoanPolicy();
        LocalDate borrowedDate = LocalDate.now();
        //Act
        LocalDate dueDate = policy.calculateDueDate(borrowedDate);
        //Assert
        assertEquals(borrowedDate.plusDays(30), dueDate);
    }
}