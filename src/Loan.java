import java.time.LocalDate;

public record Loan(Book book, Member member, LocalDate borrowedDate) {
    public LocalDate getDueDate() { //Metode til hvornår en bog skal afleveres. 14 dage efter lånedato
        if (borrowedDate != null) {
            return borrowedDate.plusDays(14);
        }
        return null;
    }

    public String toString() {
        return book + "\n" + member + "\n" + "Afleveringsfrist: " + getDueDate();
    }
}
