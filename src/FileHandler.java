import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
        private Path path;
        private CsvMapper mapper;

        public FileHandler(Path path, CsvMapper mapper){
            this.path = path;
            this.mapper = mapper;
        }

    // SAVERS
    public void saveMember(List<Member> memberList) throws IOException {
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (Member member : memberList){
                String line = mapper.memberToCsv(member);
                bufferedWriter.write(line);
                bufferedWriter.newLine();

            }
        }
    }


    public void saveResource(List<Resource> resourceList) throws IOException {
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (Resource resource : resourceList){
                if (resource instanceof Book) {
                    String line = mapper.bookToCSV((Book) resource);
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }

            }
        }
    }

    // LOADERS
    public List<Member> loadMembers() throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            List<Member> members = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                members.add(mapper.csvToMember(line));

            }
            return members;
        }
    }

    public List<Resource> loadResources() throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            List<Resource> resources = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // I will make this glorious later!
                resources.add(mapper.csvToBook(line));

            }
            return resources;
        }
    }
}


