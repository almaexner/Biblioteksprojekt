import java.util.Comparator;

public class Sorter implements Comparator<Resource> {

    @Override
    public int compare(Resource o1, Resource o2) {
        return CharSequence.compare(o1.title, o2.title);
    }
}
