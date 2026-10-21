import java.time.LocalDate;

public class Loan {
    final private Book book;
    final private Member member;
    final LocalDate borrowedDate;

    public Loan(Book book, Member member, LocalDate borrowedDate) {
        this.book = book;
        this.member = member;
        this.borrowedDate = borrowedDate;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getDueDate() {
        if (borrowedDate != null) {
            return borrowedDate.plusDays(14);
        }
        return null;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(getDueDate());
    }

    public String toString() {
        return book + "\n" + member + "\n" + "Afleveringsfrist: " + getDueDate();
    }
}
