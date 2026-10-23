import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LoanTest {
    LocalDate borrowedDate;

    @Test
    void testGetResource(){
        //Arrange
        Resource resource = new Resource("J.K. Rowling", "Harry Potter and the philosophers stone", "9781408855652");
        Member member1 = new Member("Alma Exner", 10);
        Loan loan = new Loan(resource, member1, borrowedDate);

        //Act


        //Assert
        assertEquals(loan.getResource().getCreator(), "J.K. Rowling");
        assertEquals(loan.getResource().getTitle(), "Harry Potter and the philosophers stone");
        assertEquals(loan.getResource().getIdentifier(), "9781408855652");
    }
    @Test
    void testGetResource2() {
        //Arrange
        Resource resource = new Resource("J.K. Rowling", "Harry Potter and the philosophers stone", "9781408855652");
        Member member1 = new Member("Alma Exner", 10);
        Loan loan = new Loan(resource, member1, borrowedDate);

        //Act


        //Assert
        assertEquals(loan.getMember().getName(), "Alma Exner");
        assertEquals(loan.getMember().getID(), 10);
    }

    @Test
    void testGetDueDate(){
        //Arrange
        Resource resource = new Resource("J.K. Rowling", "Harry Potter and the philosophers stone", "9781408855652");
        Member member1 = new Member("Alma Exner", 10);
        Loan loan = new Loan(resource, member1, borrowedDate);

        //Act


        //Assert
        assertEquals(loan.getDueDate(), borrowedDate);
    }
    @Test
    void testToString(){
        //Arrange
        Resource resource = new Resource("J.K. Rowling", "Harry Potter and the philosophers stone", "9781408855652");
        Member member1 = new Member("Alma Exner", 10);
        Loan loan = new Loan(resource, member1, borrowedDate);
        //Act
        String toString = loan.toString();
        //Assert
        assertEquals(resource + "\n" + member1 + "\n" + "Afleveringsfrist: " + borrowedDate, toString);
    }
}
