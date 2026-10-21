import java.time.LocalDate;

public class Loan {
    final private Resource resource;
    final private Member member;
    final LocalDate borrowedDate;

    public Loan(Resource resource, Member member, LocalDate borrowedDate) {
        this.resource = resource;
        this.member = member;
        this.borrowedDate = borrowedDate;
    }

    public Resource getResource() {
        return resource;
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
        return resource + "\n" + member + "\n" + "Afleveringsfrist: " + getDueDate();
    }
}
