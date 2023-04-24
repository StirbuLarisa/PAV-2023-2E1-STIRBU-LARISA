import java.awt.*;
import java.io.Serializable;

public class Line implements Serializable {
    private Dot dot1;
    private Dot dot2;
    private LineColor color;

    public Line(Dot dot1, Dot dot2) {
        this.dot1 = dot1;
        this.dot2 = dot2;
        color = LineColor.GRAY;
        dot1.addLine(this);
        dot2.addLine(this);
    }

    public LineColor getColor() {
        return color;
    }

    public void setColor(LineColor color) {
        this.color = color;
    }

    public Dot getDot1() {
        return dot1;
    }

    public Dot getDot2() {
        return dot2;
    }

    public boolean hasDot(Dot dot) {
        return dot == dot1 || dot == dot2;
    }

    //return un punct care este la celalalt capat al liniei //imi trebuie pt a verifica castigatorul

    public Dot getOtherDot(Dot dot) {
        if (dot == dot1) {
            return dot2;
        } else if (dot == dot2) {
            return dot1;
        } else {
            return null;
        }
    }
    public Dot getSharedDot(Line other) {
        if (dot1 == other.dot1 || dot1 == other.dot2) {
            return dot1;
        }
        if (dot2 == other.dot1 || dot2 == other.dot2) {
            return dot2;
        }
        return null;
    }

    public void draw(Graphics g) {
        if (color == LineColor.GRAY) {
            g.setColor(Color.LIGHT_GRAY);
        } else if (color == LineColor.RED) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLUE);
        }
        g.drawLine(dot1.getX(), dot1.getY(), dot2.getX(), dot2.getY());
    }
}