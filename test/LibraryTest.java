import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class LibraryTest {
    LocalDate borrowedDate;
    LocalDate dueDate;

    ArrayList<Resource> resourceList;
    ArrayList<Member> memberList;
    ArrayList<Loan> loanList;

    Book hp, lotr, goT;
    Member aksel, storm, alma, david;
    Loan akselhp, stormLotr, almaGoT;

    @BeforeEach
    void setup(){
        hp = new Book("Rowlings", "Harry Potter", "142", 51);
        lotr = new Book("J.R. Tolkien", "Lord of the rings", "123", 19201);
        goT = new Book("George R.R.", "Game of Thrones", "909", 250);

        aksel = new Member("Aksel", 1);
        storm = new Member("Storm", 2);
        alma = new Member("alma", 3);
        david = new Member("david", 5);

        akselhp = new Loan(hp,aksel, borrowedDate, dueDate);
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
}