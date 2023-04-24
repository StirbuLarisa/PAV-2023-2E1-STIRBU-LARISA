import java.awt.*;
import java.io.Serializable;
import java.util.*;
public class Board implements Serializable {
    private ArrayList<Dot> dots;
    private ArrayList<Line> lines;

    public Board(int numDots, double probLines) {
        dots = new ArrayList<>();
        lines = new ArrayList<>();
        int centerX = 400;
        int centerY = 300;
        int radius = 200;
        double angle = 0;
        double angleIncrement = 2 * Math.PI / numDots;
        for (int i = 0; i < numDots; i++) {
            int x = (int) (centerX + radius * Math.cos(angle));
            int y = (int) (centerY + radius * Math.sin(angle));
            dots.add(new Dot(x, y));
            angle += angleIncrement;
        }
        for (int i = 0; i < numDots; i++) {
            for (int j = i + 1; j < numDots; j++) {
                if (Math.random() < probLines) {
                    Line line = new Line(dots.get(i), dots.get(j));
                    lines.add(line);
                }
            }
        }
    }
    public void draw(Graphics g) {
        for (Line line : lines) {
            line.draw(g);
        }
        for (Dot dot : dots) {
            g.setColor(Color.BLACK);
            g.fillOval(dot.getX() - 5, dot.getY() - 5, 10, 10);
        }
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    //verifica daca lina contine un anumit punct, trb pentru mouse

    public Line getLineAt(int x, int y, int threshold) {
        for (Line line : lines) {
            int x1 = line.getDot1().getX();
            int y1 = line.getDot1().getY();
            int x2 = line.getDot2().getX();
            int y2 = line.getDot2().getY();

            // calculate distance between mouse click and line
            double distance = Math.abs((y2-y1)*x - (x2-x1)*y + x2*y1 - y2*x1) /
                    Math.sqrt(Math.pow(y2-y1, 2) + Math.pow(x2-x1, 2));

            // check if distance is less than threshold
            if (distance < threshold &&
                    x >= Math.min(x1, x2) && x <= Math.max(x1, x2) &&
                    y >= Math.min(y1, y2) && y <= Math.max(y1, y2)) {
                return line;
            }
        }
        return null;
    }

    public boolean isFull() {
        for (Line line : lines) {
            if (line.getColor() == LineColor.GRAY) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        for (Line line : lines) {
            line.setColor(LineColor.GRAY);
        }
    }
}