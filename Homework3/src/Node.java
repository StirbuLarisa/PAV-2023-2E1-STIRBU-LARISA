import java.util.Map;
import java.util.Objects;

public interface Node {
    String obtainName();
    int numRelations();
    Map<String, Node> getRelationships();

}
