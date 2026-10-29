import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    LocalDate borrowedDate;
    LocalDate dueDate;

    ArrayList<Resource> resourceList;
    ArrayList<Member> memberList;
    ArrayList<Loan> loanList;

    LoanPolicy testPolicy;
    Library testLib;
    Book hp, lotr, goT;
    Member aksel, storm, alma, david;
    Loan akselhp, stormLotr, almaGoT;

    Library library;
    TestDoubleLoanPolicy canLoanPolicy;
    TestDoubleCannotLoanPolicy cannotLoanPolicy;

    @BeforeEach
    void setup() {
        testPolicy = new StandardLoanPolicy();
        testLib = new Library(testPolicy);
        LoanPolicy loanPolicy = new StandardLoanPolicy();
        Library libX = new Library(loanPolicy);

        hp = new Book("Rowlings", "Harry Potter", "142", 51);
        lotr = new Book("J.R. Tolkien", "Lord of the rings", "123", 19201);
        goT = new Book("George R.R.", "Game of Thrones", "909", 250);

        aksel = new Member("Aksel", 1);
        storm = new Member("Storm", 2);
        alma = new Member("alma", 3);
        david = new Member("david", 5);

        akselhp = new Loan(hp, aksel, borrowedDate, dueDate);
        stormLotr = new Loan(lotr, storm, borrowedDate, dueDate);

        resourceList = new ArrayList<>();
        memberList = new ArrayList<>();
        loanList = new ArrayList<>();

        resourceList.add(hp);
        resourceList.add(lotr);
        resourceList.add(goT);

        memberList.add(aksel);
        memberList.add(storm);
        memberList.add(alma);
        memberList.add(david);

        loanList.add(akselhp);
        loanList.add(stormLotr);

    }

    @Test
    void testNotPermitted() {

        library = new Library(canLoanPolicy);
        library.loanResource();
        assertEquals(AttemptLoan.NOT_PERMITTED, loan);
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
        assertEquals(result, aksel);
    }

    @Test
    void testGetBook(){
        //
        testLib.addResource(hp);
        // get with ID instead of name, name doesnt work
        Resource result = testLib.getResource("142");
        //
        assertEquals(result, hp);
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

}