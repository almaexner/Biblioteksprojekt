import java.text.Collator;
import java.util.Comparator;

public class ResourceCreatorComparator implements Comparator<Resource> {
    Collator collator;

    public ResourceCreatorComparator(Collator collator){
        this.collator = collator;
    }

    @Override
    public int compare(Resource resource1, Resource resource2) {
        return collator.compare(resource1.getCreator(), resource2.getCreator());
        //Vi bruger collater så senere når vi sortere kan vi sortere efter sprog.
    }
}
