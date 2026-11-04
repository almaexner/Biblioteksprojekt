import java.text.Collator;
import java.util.Comparator;

public class ResourceTitleComparator implements Comparator<Resource> {
    Collator collator;

    public ResourceTitleComparator(Collator collator){
        this.collator = collator;
    }

    @Override
    public int compare(Resource resource1, Resource resource2){
        return collator.compare(resource1.getTitle(), resource2.getTitle());
    }
}
