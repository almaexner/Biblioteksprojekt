import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {
    LocalDate borrowedDate;
    LocalDate dueDate;

    ArrayList<Resource> resourceList;
    ArrayList<Member> memberList;
    ArrayList<Loan> loanList;

    Resource[] resourceArray;
    Member[] memberArray;
    Loan[] loanArray;

    Book book1, book2, book3;
    Member member1, member2, member3, member4;
    Loan loan1, loan2, almaGoT;


    Library canLoanLibra;
    Library cannotLoanLibrary;
    TestDoubleLoanPolicy canLoanPolicy;
    TestDoubleCannotLoanPolicy cannotLoanPolicy;

    @BeforeEach
    void setup(){
        book1 = new Book("Rowlings", "Harry Potter", "142", 51);
        book2 = new Book("J.R. Tolkien", "Lord of the rings", "123", 19201);
        book3 = new Book("George R.R.", "Game of Thrones", "909", 250);

        member1 = new Member("Aksel", 1);
        member2 = new Member("Storm", 2);
        member3 = new Member("alma", 3);
        member4 = new Member("david", 5);

        borrowedDate = LocalDate.now();
        dueDate = LocalDate.now().plusDays(1);


        canLoanLibra = new Library(canLoanPolicy);
        cannotLoanLibrary = new Library(cannotLoanPolicy);


        canLoanLibra.addResource(book1);
        canLoanLibra.addResource(book2);
        canLoanLibra.addResource(book3);

        canLoanLibra.addMember(member1);
        canLoanLibra.addMember(member2);
        canLoanLibra.addMember(member3);
        canLoanLibra.addMember(member4);

        canLoanLibra.addLoan(loan1);
        canLoanLibra.addLoan(loan2);
    }

    @Test
    void testNotPermitted() {

        loan1 = new Loan(book1, member1, borrowedDate, dueDate);
        AttemptLoan loan = canLoanLibra.loanResource(member1.getID(), book1.getIdentifier());


        assertEquals(AttemptLoan.NOT_PERMITTED, loan);
    }
}