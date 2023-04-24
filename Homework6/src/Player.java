import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private LineColor color;

    public Player(String name, LineColor color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public LineColor getColor() {
        return color;
    }
}
