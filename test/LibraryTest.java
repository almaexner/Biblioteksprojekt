import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    LocalDate borrowedDate;
    LocalDate dueDate;

    LoanPolicy testDefaultPolicy;
    LoanPolicy testCanLoanPolicy;
    LoanPolicy testCannotLoanPolicy;
    Library testLib;
    Book book1, book2, book3;
    Member member1, member2, member3, member4;
    Loan loan1, loan2;

    Library library;
    TestDoubleLoanPolicy canLoanPolicy;
    TestDoubleCannotLoanPolicy cannotLoanPolicy;

    @BeforeEach
    void setup() {
        testDefaultPolicy = new StandardLoanPolicy();
        testCanLoanPolicy = new TestDoubleLoanPolicy();
        testCannotLoanPolicy = new TestDoubleCannotLoanPolicy();

        testLib = new Library(testDefaultPolicy);

        book1 = new Book("142", "Rowlings", "Harry Potter", 51);
        book2 = new Book("123", "J.R. Tolkien", "Lord of the rings", 19201);
        book3 = new Book("909", "George R.R.", "Game of Thrones", 250);

        member1 = new Member("Aksel", 1);
        member2 = new Member("Storm", 2);
        member3 = new Member("alma", 3);
        member4 = new Member("david", 5);

        loan1 = new Loan(book1, member1, borrowedDate, dueDate);
        loan2 = new Loan(book2, member2, borrowedDate, dueDate);


    }

    private void addAllToLib(Library lib){
        addResourcesToLib(lib);
        addMembersToLib(lib);
    }

    private void addMembersToLib(Library lib) {
        lib.addMember(member1);
        lib.addMember(member2);
        lib.addMember(member3);
        lib.addMember(member4);
    }

    private void addResourcesToLib(Library lib) {
        lib.addResource(book1);
        lib.addResource(book2);
        lib.addResource(book3);
    }

    @Test
    void testGetDueDate() {
        LoanPolicy loanPolicy = new StandardLoanPolicy();
        Library libX = new Library(loanPolicy);

        LocalDate borrowDate = LocalDate.now();
        LocalDate expectedDate = borrowDate.plusDays(30);

        assertEquals(libX.getDueDate(borrowDate, book2), expectedDate);
    }


    @Test
    void testGetMember(){
        //
        testLib.addMember(member1);
        //
        Member result = testLib.getMember(1);
        //
        assertEquals(member1, result);
    }

    @Test
    void testGetBook(){
        //
        testLib.addResource(book1);
        // get with ID instead of name, name doesnt work
        Book result = (Book) testLib.getResource("142");
        //
        assertEquals(book1, result);
    }

    @Test
    void testGetLoan(){
        //
        testLib.addLoan(loan1);
        //
        Loan result = testLib.getLoan(book1.getIdentifier());
        //
        assertEquals(loan1, result);
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

    @Test
    void attemptLoanSuccess(){
        Library canLoadLib = new Library(testCanLoanPolicy);
        addAllToLib(canLoadLib);

        assertEquals(AttemptLoan.RES_LOAN_SUCCESS, canLoadLib.loanResource(member1.getId(),book1.getIdentifier()));
    }

    @Test
    void attempLoanNotPermitted(){
        Library cannotLoadLib = new Library(testCannotLoanPolicy);
        addAllToLib(cannotLoadLib);

        assertEquals(AttemptLoan.NOT_PERMITTED, cannotLoadLib.loanResource(member1.getId(),book1.getIdentifier()));
    }

    @Test
    void attempLoanUserNotFound(){
        Library canLoadLib = new Library(testCanLoanPolicy);
        addAllToLib(canLoadLib);
        Member testMember = new Member("Martin", 10000);

        assertEquals(AttemptLoan.USER_NOT_FOUND, canLoadLib.loanResource(testMember.getId(),book1.getIdentifier()));
    }

    @Test
    void attempLoanRessNotFound(){
        Library canLoadLib = new Library(testCanLoanPolicy);
        addAllToLib(canLoadLib);
        Book testBook = new Book("00", "Martin", "Kewl", 1);

        assertEquals(AttemptLoan.RES_NOT_FOUND, canLoadLib.loanResource(member1.getId(),testBook.getIdentifier()));
    }

    @Test
    void attempLoanNotAvailable(){
        Library canLoadLib = new Library(testCanLoanPolicy);
        addAllToLib(canLoadLib);
        canLoadLib.loanResource(member2.getId(),book1.getIdentifier());

        assertEquals(AttemptLoan.RES_NOT_AVAIL, canLoadLib.loanResource(member1.getId(),book1.getIdentifier()));
    }
}