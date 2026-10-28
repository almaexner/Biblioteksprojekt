import java.time.LocalDate;

public class Loan {
    final private Resource resource;
    final private Member member;
    final LocalDate borrowedDate; //Dagen materialet bliver lånt
    final LocalDate dueDate; //Dagen materialet senest skal returneres

    public Loan(Resource resource, Member member, LocalDate borrowedDate, LocalDate dueDate) {
        this.resource = resource;
        this.member = member;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public Resource getResource() {
        return resource;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(getDueDate());
    }

    public String toString() {
        return resource + "\n" + member + "\n" + "Afleveringsfrist: " + getDueDate();
    }
}
