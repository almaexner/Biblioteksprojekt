import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> bookList = new ArrayList<>();
    private final ArrayList<Member> memberList = new ArrayList<>();
    private final ArrayList<Loan> loanList = new ArrayList<>();

    public void addBook(Book book) { //Metode til at tilføje bøger i bookList ArrayListen
        bookList.add(book);
    }

    public void addMember(Member member) { //Metode til at tilføje medlemmer i memberList ArrayListen
        memberList.add(member);
    }

    public void addLoan(Loan loan) { //Metode til at tilføje lån i loanList ArrayListen
        loanList.add(loan);
    }

    public Member getMember(int memberId) { //Metode til at finde medlemmer i ArrayListen for medlemmer med brug af memberId
        for (Member member : memberList) {
            if (member.memberNo() == memberId) {
                return member;
            }
        }
        return null;
    }

    public Book getBook(int bookId) { //Metode til at finde bøger i bookList med bookId
        for (Book book : bookList) {
            if (book.id == bookId) {
                return book;
            }
        }
        return null;
    }

    public Loan getLoan(int identifier) {
        for (Loan loan : loanList) {
            if (loan.getBook().id == identifier) {
                return loan;
            }
        } return null;

    }

    public void printBooks() { //Metode til at printe bøger fra bookList
        for (int i = 0; i < bookList.size(); i++) {
            IO.println(bookList.get(i));
        }
    }

    public void printMembers() { //Metode til at printe members fra memberList
        for (int i = 0; i < memberList.size(); i++) {
            IO.println(memberList.get(i));
        }
    }

    public boolean loanBook(int memberId, int bookId) { //Metode til at låne en bog, hvis både medlem og bog er oprrettet i ArrayListerne
        // og bogen ikke er på låne listen i forvejen.
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


    public boolean returnBook(int bookId){ //Metode til at fjerne en bog fra loanList
        Loan loan = getLoan(bookId);
        if (loan == null){
            return false;
        }
        loanList.remove(loan);
        return true;
    }

    public ArrayList<Loan> findLoansByMemberId(int memberId){ //Metode til at finde hvilke lån et medlem har.
        ArrayList<Loan> foundLoans = new ArrayList<>();

        for (Loan loan : loanList){
            if (loan.getMember().memberNo() == memberId){
                foundLoans.add(loan);
            }
        }
        return foundLoans;
    }
}
