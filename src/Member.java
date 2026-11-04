import java.text.Collator;

public class Member implements Comparable<Member> {
    private final String name;
    private final int id;

    public Member(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Member otherMember){
        return Integer.compare(this.id, otherMember.id);
    }

    public String toString() {
        return name + " (Lånernummer: " + id + ")";
    }
}
