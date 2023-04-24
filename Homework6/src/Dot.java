
import java.io.Serializable;
import java.util.ArrayList;

public  class Dot implements Serializable {
    private int x;
    private int y;
    private ArrayList<Line> lines;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
        lines = new ArrayList<>();
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
