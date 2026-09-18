import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> bookList = new ArrayList<>();
    private final ArrayList<Member> memberList = new ArrayList<>();
    private final ArrayList<Loan> loanList = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void addMember(Member member) {
        memberList.add(member);
    }

    public void addLoan(Loan loan) {
        loanList.add(loan);
    }

    public Member getMember(int memberId) {
        for (Member member : memberList) {
            if (member.memberNo() == memberId) {
                return member;
            }
        }
        return null;
        //   return memberList.get(memberId);
    }

    public Book getBook(int bookId) {
        for (Book book : bookList) {
            if (book.id() == bookId) {
                return book;
            }
        }
        return null;
    }

    public Loan getLoan(int bookId) {
        for (Loan loan : loanList) {
            if (loan.book().id() == bookId) {
                return loan;
            }
        } return null;

    }

    public void printBooks() {
        for (int i = 0; i < bookList.size(); i++) {
            IO.println(bookList.get(i));
        }
    }

    public void printMembers() {
        for (int i = 0; i < memberList.size(); i++) {
            IO.println(memberList.get(i));
        }
    }

    public boolean loanBook(int memberId, int bookId) {
        Member member = getMember(memberId);
        if (member == null) {
            return false;
        }
        Book book = getBook(bookId);
        if (book == null) {
            return false;
        }
        Loan loan = getLoan(bookId);
        if (loan != null){
            return false;
        }
        loanList.add(new Loan(book, member, LocalDate.now()));
        return true;
    }


    public boolean returnBook(int bookId){
        Loan loan = getLoan(bookId);
        if (loan == null){
            return false;
        }
        loanList.remove(loan);
        return true;
    }

    public ArrayList<Loan> findLoansByMemberId(int memberId){
        ArrayList<Loan> foundLoans = new ArrayList<>();

        for (Loan loan : loanList){
            if (loan.member().memberNo() == memberId){
                foundLoans.add(loan);
            }
        }
        return foundLoans;
    }
}
