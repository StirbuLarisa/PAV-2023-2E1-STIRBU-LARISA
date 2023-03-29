import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Network {

    private List<Node> nodes;

    public Network() {
        this.nodes = new ArrayList<>();
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public List<Node> getNodesByImportance() {
        List<Node> copy = new ArrayList<>(nodes);

        Collections.sort(copy, new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return Integer.compare(n2.numRelations(), n1.numRelations());
            }
        });

        return copy;
    }

    public void printNodes() {
        List <Node> ordered = getNodesByImportance();
        for (Node n : ordered){
            System.out.println(n.obtainName());
        }
    }
}

