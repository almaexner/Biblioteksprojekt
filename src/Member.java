public class Member {

    private final String name;
    private final int ID;
    public Member(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String toString(){
        return name + " (Lånernummer: " + ID + ")";
    }
}
