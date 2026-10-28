import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LoanTest {
    LocalDate borrowedDate;
    LocalDate dueDate;

    @Test
    void testGetResource(){
        //Arrange
        Resource resource = new Resource("J.K. Rowling", "Harry Potter and the philosophers stone", "9781408855652");
        Member member1 = new Member("Alma Exner", 10);
        Loan loan = new Loan(resource, member1, borrowedDate, dueDate );

        //Act


        //Assert
        assertEquals("J.K. Rowling", loan.getResource().getCreator());
        assertEquals("Harry Potter and the philosophers stone", loan.getResource().getTitle());
        assertEquals("9781408855652", loan.getResource().getIdentifier());
    }
    @Test
    void testGetResource2() {
        //Arrange
        Resource resource = new Resource("J.K. Rowling", "Harry Potter and the philosophers stone", "9781408855652");
        Member member1 = new Member("Alma Exner", 10);
        Loan loan = new Loan(resource, member1, borrowedDate, dueDate);

        //Act


        //Assert
        assertEquals("Alma Exner", loan.getMember().getName());
        assertEquals(10, loan.getMember().getID());
    }

    @Test
    void testGetResourceFalse(){
//Arrange
        Resource resource = new Resource("J.K. Rowling", "Harry Potter and the philosophers stone", "9781408855652");
        Member member1 = new Member("Alma Exner", 10);
        Loan loan = new Loan(resource, member1, borrowedDate, dueDate);

        //Act


        //Assert
        assertEquals("I.B. Growling", loan.getResource().getCreator());
        assertEquals("Garry Bodder and the Diagonogoler's Sdone", loan.getResource().getTitle());
        assertEquals("9682623191", loan.getResource().getIdentifier());
    }


    @Test
    void testGetDueDate(){
        //Arrange
        Resource resource = new Resource("J.K. Rowling", "Harry Potter and the philosophers stone", "9781408855652");
        Member member1 = new Member("Alma Exner", 10);
        Loan loan = new Loan(resource, member1, borrowedDate, dueDate);

        //Act


        //Assert
        assertEquals(borrowedDate, loan.getDueDate());
    }

    @Test
    void testToString(){
        //Arrange
        Resource resource = new Resource("J.K. Rowling", "Harry Potter and the philosophers stone", "9781408855652");
        Member member1 = new Member("Alma Exner", 10);
        Loan loan = new Loan(resource, member1, borrowedDate, dueDate);
        //Act
        String toString = loan.toString();
        //Assert
        assertEquals(resource + "\n" + member1 + "\n" + "Afleveringsfrist: " + borrowedDate, toString);
    }

    @Test
    void testToStringFalse(){
        //Arrange
        Resource resource = new Resource("J.K. Rowling", "Harry Potter and the philosophers stone", "9781408855652");
        Member member1 = new Member("Alma Exner", 10);
        Loan loan = new Loan(resource, member1, borrowedDate, dueDate);
        //Act
        String toString = member1.toString();
        //Assert
        assertEquals(resource + "\n" + member1 + "\n" + "Afleveringsfrist: " + borrowedDate, toString);
    }

    @Test
    void testToStringFalse2(){
        //Arrange
        Resource resource = new Resource("J.K. Rowling", "Harry Potter and the philosophers stone", "9781408855652");
        Member member1 = new Member("Alma Exner", 10);
        Loan loan = new Loan(resource, member1, borrowedDate, dueDate);
        //Act
        String toString = resource.toString();
        //Assert
        assertEquals(resource + "\n" + member1 + "\n" + "Afleveringsfrist: " + borrowedDate, toString);
    }
}
