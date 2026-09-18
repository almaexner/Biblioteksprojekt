public record Member(String name, int memberNo) {
    public String toString(){
        return name + " (Lånernummer: " + memberNo + ")";
    }
}
