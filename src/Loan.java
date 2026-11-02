import java.time.LocalDate;

public class Loan {
    private final Resource resource;
    private final Member member;
    private final LocalDate borrowedDate; //Dagen materialet bliver lånt
    private final LocalDate dueDate; //Dagen materialet senest skal returneres

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
