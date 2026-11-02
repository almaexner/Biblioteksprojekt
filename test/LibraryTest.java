import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    LocalDate borrowedDate;
    LocalDate dueDate;

    LoanPolicy testPolicy;
    Library testLib;
    Book hp, lotr, goT;
    Member aksel, storm, alma, david;
    Loan akselhp, stormLotr;

    Library library;
    TestDoubleLoanPolicy canLoanPolicy;
    TestDoubleCannotLoanPolicy cannotLoanPolicy;

    @BeforeEach
    void setup() {
        testPolicy = new StandardLoanPolicy();
        testLib = new Library(testPolicy);
        LoanPolicy loanPolicy = new StandardLoanPolicy();
        Library libX = new Library(loanPolicy);

        hp = new Book("142", "Rowlings", "Harry Potter", 51);
        lotr = new Book("123", "J.R. Tolkien", "Lord of the rings", 19201);
        goT = new Book("909", "George R.R.", "Game of Thrones", 250);

        aksel = new Member("Aksel", 1);
        storm = new Member("Storm", 2);
        alma = new Member("alma", 3);
        david = new Member("david", 5);

        akselhp = new Loan(hp, aksel, borrowedDate, dueDate);
        stormLotr = new Loan(lotr, storm, borrowedDate, dueDate);


    }

    private void addDefaultToLib(Library lib){
        lib.addResource(hp);
        lib.addResource(lotr);
        lib.addResource(goT);

        lib.addMember(aksel);
        lib.addMember(storm);
        lib.addMember(alma);
        lib.addMember(david);

        lib.addLoan(akselhp);
        lib.addLoan(stormLotr);
    }

    @Test
    void testGetDueDate() {
        LoanPolicy loanPolicy = new StandardLoanPolicy();
        Library libX = new Library(loanPolicy);

        LocalDate borrowDate = LocalDate.now();
        LocalDate expectedDate = borrowDate.plusDays(30);

        assertEquals(libX.getDueDate(borrowDate, lotr), expectedDate);
    }


    @Test
    void testGetMember(){
        //
        testLib.addMember(aksel);
        //
        Member result = testLib.getMember(1);
        //
        assertEquals(aksel, result);
    }

    @Test
    void testGetBook(){
        //
        testLib.addResource(hp);
        // get with ID instead of name, name doesnt work
        Book result = (Book) testLib.getResource("142");
        //
        assertEquals(hp, result);
    }

    @Test
    void testGetLoan(){
        //
        testLib.addLoan(akselhp);
        //
        Loan result = testLib.getLoan("aksel");
        //
        assertEquals(result, akselhp);
    }

    @Test
    void addMemberGetMember(){
        Member inMember = new Member("test", 0);
        testLib.addMember(inMember);

        Member outMember = testLib.getMember(0);
        assertEquals(inMember, outMember);
    }

    @Test
    void addBookGetBook(){
        Book inBook = new Book("testID", "Carl Stefansen","testBook", 12);
        testLib.addResource(inBook);

        Book outBook = (Book) testLib.getResource("testID");
        assertEquals(inBook, outBook);
    }

    @Test
    void addLoanGetLoan(){
        Book inBook = new Book("testID", "Carl Stefansen","testBook", 12);
        Member inMember = new Member("test", 0);

        Loan inLoan = new Loan(inBook, inMember, LocalDate.now(), LocalDate.now().plusWeeks(2));
        testLib.addLoan(inLoan);

        Loan outLoan = testLib.getLoan(inBook.id);
        assertEquals(inLoan, outLoan);
    }
}