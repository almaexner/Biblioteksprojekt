import java.time.LocalDate;

public class CsvMapper {
    private String delimiter = ",";

    public Member csvToMember(String line){
        String[] tokens = line.split(delimiter, -1);
        String name = tokens[0];
        int id = Integer.parseInt(tokens[1]);
        return new Member(name, id);
    }

    public String memberToCsv(Member member){
        return member.getName()
                + delimiter + member.getID();
    }

    public Book csvToBook(String line){
        String[] tokens = line.split(delimiter, -1);
        String id = tokens[0];
        String author = tokens[1];
        String title = tokens[2];
        int pagenumber = Integer.parseInt(tokens[3]);
        return new Book(id, author, title, pagenumber);
    }

    public String bookToCSV(Book book){
        return book.getIdentifier()
                + delimiter + book.getCreator()
                + delimiter + book.getTitle()
                + delimiter + book.pages;
    }
}

